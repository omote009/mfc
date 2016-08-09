package mfc.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="song_mr")
public class SongMr extends AbstractEntity {

    @Id
    @Column(name = "song_key")
    private String songKey;

    @Column(name = "song_name")
    private String songName;

    @Column(name = "link_url")
    private String linkUrl;

    @Column(name = "artist_code")
    private String artistCode;

    public String getSongKey() {
        return songKey;
    }

    public void setSongKey(String songKey) {
        this.songKey = songKey;
    }

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public String getLinkUrl() {
        return linkUrl;
    }

    public void setLinkUrl(String linkUrl) {
        this.linkUrl = linkUrl;
    }

    public String getArtistCode() {
        return artistCode;
    }

    public void setArtistCode(String artistCode) {
        this.artistCode = artistCode;
    }

}
