package gak.library.music.controller;

import gak.library.music.domain.Album;
import gak.library.music.domain.Artist;
import gak.library.music.service.IArtistService;
import gak.library.music.service.implementation.IAlbumService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/music")
public class MusicController {

    @Autowired
    private IArtistService artistService;

    @Autowired
    private IAlbumService albumService;

    @ApiOperation(value = "Retrieves the artist information given the artist name", response= Artist.class)
    @RequestMapping("artist/{name}")
    public ResponseEntity<Artist> findArtist(@PathVariable String name) {
        Artist artist = artistService.find(name);

        return ResponseEntity.ok(artist);
    }

    @ApiOperation(value="Retrieves the album of the top chat track", response = Album.class)
    @ApiResponses( value ={
            @ApiResponse(code = 200, message = "Album retrieved successfully"),
            @ApiResponse(code=404, message = "URL not found")
    })
    @RequestMapping("album/{country}")
    public ResponseEntity<Album> findAlbum (@PathVariable String country){
        Album album = albumService.find(country);

        return ResponseEntity.ok(album);
    }
}
