package gak.library.music.proxy.implementation;

import gak.library.music.adapter.ArtistAdapter;
import gak.library.music.domain.Artist;
import gak.library.music.exception.ApiCorruptedResultException;
import gak.library.music.exception.ArtistNotFoundException;
import gak.library.music.proxy.IArtistProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.text.MessageFormat;

@Component
public class ArtistProxy extends ProxyConfiguration implements IArtistProxy {

    @Value("${last.fm.api.artist.info.url}")
    private String url;
    @Value("${last.fm.api.key}")
    private String apiKey;

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public Artist getArtistInfo(String artistName) throws ArtistNotFoundException, ApiCorruptedResultException {


        String request = MessageFormat.format(url, apiKey, artistName);
        System.out.println("#################  "+request);

        ResponseEntity<String> response = restTemplate.getForEntity(request, String.class);

        String result = response.getBody();

        return ArtistAdapter.convertToArtist(result);
    }
}
