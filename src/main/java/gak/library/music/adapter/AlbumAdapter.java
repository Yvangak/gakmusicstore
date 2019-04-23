package gak.library.music.adapter;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import gak.library.music.domain.Album;
import gak.library.music.exception.AlbumNotFoundException;
import gak.library.music.exception.ApiCorruptedResultException;

import java.io.IOException;

public class AlbumAdapter {

    public static Album convertToAlbum(String content) {
        ObjectMapper mapper = new ObjectMapper();

        try {
            JsonNode jsonNode = mapper.readTree(content);

            if (jsonNode != null) {
                Album album = new Album();

                JsonNode trackNode = jsonNode.path("track");

                if (!trackNode.isMissingNode()) {

                    JsonNode albumNode = trackNode.path("album");

                    if (!albumNode.isMissingNode()) {

                        album.setAlbumUrl(albumNode.path("url").asText());
                        album.setName(albumNode.path("title").asText());
                        return album;

                    } else {
                        throw new AlbumNotFoundException("Album Node missing");
                    }
                } else {
                    throw new AlbumNotFoundException("Track Node missing");
                }
            } else {
                throw new AlbumNotFoundException("Couldn't read the tree node");
            }
        } catch (IOException io) {
            throw new ApiCorruptedResultException(io.getMessage());
        }
    }
}
