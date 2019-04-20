package gak.library.music.proxy;

import gak.library.music.domain.Artist;
import gak.library.music.exception.ArtistNotFoundException;

public interface IArtistProxy {
    Artist getArtistInfo(String artistName) throws ArtistNotFoundException;
}
