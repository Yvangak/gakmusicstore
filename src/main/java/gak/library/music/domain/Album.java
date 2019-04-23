package gak.library.music.domain;

import java.util.Objects;

public class Album {

    private String name;
    private Track topTrack;
    private String albumUrl;

    public Album(){}

    public Album(String name, Track topTrack, String albumUrl) {
        this.name = name;
        this.topTrack = topTrack;
        this.albumUrl = albumUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Track getTopTrack() {
        return topTrack;
    }

    public void setTopTrack(Track topTrack) {
        this.topTrack = topTrack;
    }

    public String getAlbumUrl() {
        return albumUrl;
    }

    public void setAlbumUrl(String albumUrl) {
        this.albumUrl = albumUrl;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Album album = (Album) o;
        return Objects.equals(name, album.name) &&
                Objects.equals(topTrack, album.topTrack) &&
                Objects.equals(albumUrl, album.albumUrl);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, topTrack, albumUrl);
    }

    @Override
    public String toString() {
        return "Album{" +
                "name='" + name + '\'' +
                ", topTrack=" + topTrack +
                ", albumUrl='" + albumUrl + '\'' +
                '}';
    }
}
