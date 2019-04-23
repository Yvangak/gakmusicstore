package gak.library.music.adapter;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import gak.library.music.exception.ApiCorruptedResultException;
import gak.library.music.exception.LyricsNotFoundException;

import java.io.IOException;

public class LyricsAdapter {

    public static String convertToLyrics(String content) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            JsonNode lyricsNode = mapper.readTree(content);
            if (lyricsNode != null) {
                String lyrics = lyricsNode.path("message").path("body").path("lyrics").path("lyrics_body").asText();
                return lyrics;
            } else {
                throw new LyricsNotFoundException("No lyrics found for the track");
            }
        } catch (IOException io) {
            throw new ApiCorruptedResultException("Corrupted result");
        }
    }
}
