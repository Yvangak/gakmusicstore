package gak.library.music.domain;

import java.util.Objects;

public class Track {

    private String trackName;
    private String artistName;
    private String url;
    private long duration;
    private long listeners;
    private String lyrics;

    public Track() {
    }

    public Track(String trackName, String artistName, String url, long duration, long listeners, String lyrics) {
        this.trackName = trackName;
        this.artistName = artistName;
        this.url = url;
        this.duration = duration;
        this.listeners = listeners;
        this.lyrics = lyrics;
    }

    public String getTrackName() {
        return trackName;
    }

    public void setTrackName(String trackName) {
        this.trackName = trackName;
    }

    public String getArtistName() {
        return artistName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public long getDuration() {
        return duration;
    }

    public void setDuration(long duration) {
        this.duration = duration;
    }

    public long getListeners() {
        return listeners;
    }

    public void setListeners(long listeners) {
        this.listeners = listeners;
    }

    public String getLyrics() {
        return lyrics;
    }

    public void setLyrics(String lyrics) {
        this.lyrics = lyrics;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Track track = (Track) o;
        return duration == track.duration &&
                listeners == track.listeners &&
                Objects.equals(trackName, track.trackName) &&
                Objects.equals(artistName, track.artistName) &&
                Objects.equals(url, track.url) &&
                Objects.equals(lyrics, track.lyrics);
    }

    @Override
    public int hashCode() {
        return Objects.hash(trackName, artistName, url, duration, listeners, lyrics);
    }

    @Override
    public String toString() {
        return "Track{" +
                "trackName='" + trackName + '\'' +
                ", artistName='" + artistName + '\'' +
                ", url='" + url + '\'' +
                ", duration=" + duration +
                ", listeners=" + listeners +
                ", lyrics='" + lyrics + '\'' +
                '}';
    }
}
