package gak.library.music.service.implementation;

import gak.library.music.domain.Album;
import gak.library.music.exception.AlbumNotFoundException;
import gak.library.music.exception.ApiCorruptedResultException;
import gak.library.music.exception.LyricsNotFoundException;
import gak.library.music.exception.TrackNotFoundException;
import gak.library.music.proxy.IAlbumProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AlbumService implements IAlbumService {

    @Autowired
    private IAlbumProxy albumProxy;

    @Override
    public Album find(String country) throws LyricsNotFoundException, TrackNotFoundException, AlbumNotFoundException, ApiCorruptedResultException {
        Album album = albumProxy.getAlbum(country);
        return album;
    }
}
