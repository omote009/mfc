package mfc.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * お気に入りアーティストリスト<br />
 * 
 * @author omote
 *
 */
@Entity
@Table(name="my_artist")
public class MyArtist extends AbstractEntity{

	@Id
	@Column(name = "user_id")
	private String userId;
	@Id
	@Column(name = "artist_code")
	private String artistCode;
	
	public void setUserId(final String id){
		this.userId = id;
	}
	
	public String getUserId() {
		return this.userId;
	}
	
	public void setArtistCode(final String code) {
		this.artistCode = code;
	}
	
	public String getArtistCode() {
		return this.artistCode;
	}

}
