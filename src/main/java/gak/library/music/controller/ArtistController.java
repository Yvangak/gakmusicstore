package gak.library.music.controller;

import gak.library.music.domain.Artist;
import gak.library.music.service.IArtistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/artists")
public class ArtistController {

    @Autowired
    private IArtistService artistService;

    @RequestMapping("{name}")
    public ResponseEntity<Artist> findArtist(@PathVariable String name) {
        return ResponseEntity.ok(artistService.find(name));
    }
}
