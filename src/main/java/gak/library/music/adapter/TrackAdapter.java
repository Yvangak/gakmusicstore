package gak.library.music.adapter;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import gak.library.music.domain.Track;
import gak.library.music.exception.ApiCorruptedResultException;
import gak.library.music.exception.TrackNotFoundException;

import java.io.IOException;

public class TrackAdapter {

    public static Track convertToTrack(String content) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            Track track = new Track();
            JsonNode jsonNode = mapper.readTree(content);

            if (jsonNode != null) {
                JsonNode tracksNode = jsonNode.path("tracks");

                if(!tracksNode.isMissingNode()){
                    JsonNode trackNode = tracksNode.path("track");

                    if(!trackNode.isMissingNode() && trackNode.isArray() ){
                        JsonNode topTrack = trackNode.elements().next();

                        if (!topTrack.isMissingNode()){

                            track.setTrackName(trackNode.path("name").asText());
                            track.setArtistName(trackNode.path("artist").path("name").asText());
                            track.setUrl(trackNode.path("url").asText());
                            track.setDuration(trackNode.path("duration").asLong());
                            track.setListeners(trackNode.path("listeners").asLong());

                            return track;
                        }else{
                            throw new TrackNotFoundException("No top track found in the array");
                        }
                    }else{
                        throw new TrackNotFoundException("Missing the track Node that contains the array of tracks");
                    }
                }else{
                    throw new TrackNotFoundException("No top tracks found for the searched country");
                }

            } else {
                throw new TrackNotFoundException("Tracks Node tree is Empty");
            }
        } catch (IOException io) {
            throw new ApiCorruptedResultException(io.getMessage());
        }
    }
}
