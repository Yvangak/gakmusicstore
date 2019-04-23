package gak.library.music.exception;

public class TrackNotFoundException extends RuntimeException{
    public TrackNotFoundException(String message){
        super(message);
    }
}
