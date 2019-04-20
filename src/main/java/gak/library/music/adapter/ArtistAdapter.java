package gak.library.music.adapter;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import gak.library.music.domain.Artist;
import gak.library.music.exception.ApiCorruptedResultException;
import gak.library.music.exception.ArtistNotFoundException;

import java.io.IOException;

public class ArtistAdapter {

    private static ObjectMapper mapper = new ObjectMapper();

    public static Artist convertToArtist(String result) {
        try {
            JsonNode jsonNode = mapper.readTree(result);
            if (jsonNode != null) {
                JsonNode artistNode = jsonNode.path("artist");

                Artist artist = new Artist();
                artist.setName(artistNode.path("name").asText());
                artist.setUrl(artistNode.path("url").asText());
                artist.setSummary(artistNode.path("bio").path("summary").asText());
                artist.setImageUrl(getMediumImageUrl(artistNode.path("image")));

                return artist;

            } else {
                throw new ArtistNotFoundException("No artist found with the corresponding given name");
            }

        } catch (IOException io) {
            throw new ApiCorruptedResultException("The response was corrupted");
        }
    }

    private static String getMediumImageUrl(JsonNode imageUrls) {

        for (JsonNode imageUrl : imageUrls) {
            if (imageUrl.path("size").asText().equals("medium")) {
                return imageUrl.path("#text").asText();
            }
        }
        return null;
    }
}
