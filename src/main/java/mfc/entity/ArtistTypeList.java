package mfc.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * アーティストに音楽タイプを関連づけるリスト<br />
 * 
 * @author omote
 *
 */
@Entity
@Table(name="artist_type_list")
public class ArtistTypeList extends AbstractEntity {

	@Id
	@Column(name = "artist_code")
	private String artistCode;
	@Id
	@Column(name = "music_type_code")
	private String musicTypeCode;

	public String getArtistCode() {
		return artistCode;
	}

	public void setArtistCode(String artistCode) {
		this.artistCode = artistCode;
	}

	public String getMusicTypeCode() {
		return musicTypeCode;
	}

	public void setMusicTypeCode(String musicTypeCode) {
		this.musicTypeCode = musicTypeCode;
	}

}
