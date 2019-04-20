package gak.library.music.service.implementation;

import gak.library.music.domain.Artist;
import gak.library.music.exception.ApiCorruptedResultException;
import gak.library.music.exception.ArtistNotFoundException;
import gak.library.music.proxy.IArtistProxy;
import gak.library.music.service.IArtistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArtistService implements IArtistService {

    @Autowired
    private IArtistProxy artistProxy;

    @Override
    public Artist find(String artistName) throws ArtistNotFoundException, ApiCorruptedResultException {
        return artistProxy.getArtistInfo(artistName);
    }
}
