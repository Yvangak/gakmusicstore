package gak.library.music.proxy.implementation;

import gak.library.music.adapter.AlbumAdapter;
import gak.library.music.adapter.LyricsAdapter;
import gak.library.music.adapter.TrackAdapter;
import gak.library.music.domain.Album;
import gak.library.music.domain.Track;
import gak.library.music.exception.AlbumNotFoundException;
import gak.library.music.exception.ApiCorruptedResultException;
import gak.library.music.exception.ArtistNotFoundException;
import gak.library.music.exception.LyricsNotFoundException;
import gak.library.music.proxy.IAlbumProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.text.MessageFormat;

@Component
public class AlbumProxy extends ProxyConfiguration implements IAlbumProxy {

    @Value("${last.fm.api.key}")
    private String fmApiKey;
    @Value("${music.match.api.key}")
    private String musicMatchApiKey;

    @Value("${last.fm.api.track.top.url}")
    private String fmTopTrackUrl;
    @Value("${last.fm.api.track.info.url}")
    private String fmTrackInfoUrl;
    @Value("${music.match.api.lyrics.url}")
    private String lyricsUrl;

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public Album getAlbum(String country) throws ApiCorruptedResultException, ArtistNotFoundException, LyricsNotFoundException, AlbumNotFoundException {

        Track topTrack = getTopTrack(country);

        String albumRequestUrl = MessageFormat.format(fmTrackInfoUrl, fmApiKey, topTrack.getTrackName(), topTrack.getArtistName());

        ResponseEntity<String> responseEntity = restTemplate.getForEntity(albumRequestUrl, String.class);

        String albumResult = responseEntity.getBody();

        Album album = AlbumAdapter.convertToAlbum(albumResult);
        album.setTopTrack(topTrack);

        return album;
    }

    private Track getTopTrack(String country) throws ApiCorruptedResultException, ArtistNotFoundException, LyricsNotFoundException {
        String topTrackRequestUrl = MessageFormat.format(fmTopTrackUrl, fmApiKey, country);

        ResponseEntity<String> responseEntity = restTemplate.getForEntity(topTrackRequestUrl, String.class);

        String result = responseEntity.getBody();

        Track topTrack = TrackAdapter.convertToTrack(result);
        topTrack.setLyrics(getLyrics(topTrack.getTrackName(), topTrack.getArtistName()));

        return topTrack;
    }

    private String getLyrics(String trackName, String artistName) throws ApiCorruptedResultException, LyricsNotFoundException {

        String lyricsRequestUrl = MessageFormat.format(lyricsUrl, musicMatchApiKey, trackName, artistName);

        ResponseEntity<String> responseEntity = restTemplate.getForEntity(lyricsRequestUrl, String.class);

        String result = responseEntity.getBody();

        return LyricsAdapter.convertToLyrics(result);
    }
}
