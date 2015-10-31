package mfc.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 音楽出演者マスタ<br />
 *
 * @author omote
 *
 */
@Entity
@Table(name="artist_link")
public class ArtistLink extends AbstractEntity{

	@Id
	@Column(name = "artist_code")
	private String artistCode;

	@Id
	@Column(name = "disp_name")
	private String dispName;

	@Column(name = "link_url")
	private String linkUrl;

	public String getArtistCode() {
		return artistCode;
	}

	public void setArtistCode(String artistCode) {
		this.artistCode = artistCode;
	}

	public String getDispName() {
		return dispName;
	}

	public void setDispName(String dispName) {
		this.dispName = dispName;
	}

	public String getLinkUrl() {
		return linkUrl;
	}

	public void setLinkUrl(String linkUrl) {
		this.linkUrl = linkUrl;
	}

}
