package gak.library.music.domain;

import java.util.Objects;

public class Artist {

    private String name;
    private String url;
    private String summary;
    private String imageUrl;

    public Artist() {
    }

    public Artist(String name, String url, String summary, String imageUrl) {
        this.name = name;
        this.url = url;
        this.summary = summary;
        this.imageUrl = imageUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Artist artist = (Artist) o;
        return Objects.equals(name, artist.name) &&
                Objects.equals(url, artist.url) &&
                Objects.equals(summary, artist.summary) &&
                Objects.equals(imageUrl, artist.imageUrl);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, url, summary, imageUrl);
    }

    @Override
    public String toString() {
        return "Artist{" +
                "name='" + name + '\'' +
                ", url='" + url + '\'' +
                ", summary='" + summary + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                '}';
    }
}
