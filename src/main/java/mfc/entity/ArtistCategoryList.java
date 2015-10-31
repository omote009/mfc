package mfc.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * アーティストに紐づく音楽ジャンルリスト<br />
 * 
 * @author omote
 *
 */
@Entity
@Table(name="artist_category_list")
public class ArtistCategoryList extends AbstractEntity {

	@Id
	@Column(name = "artist_code")
	private String artistCode;
	
	@Id
	@Column(name = "category_code")
	private String categoryCode;
	

	public String getArtistCode() {
		return artistCode;
	}

	public void setArtistCode(String artistCode) {
		this.artistCode = artistCode;
	}

	public String getCategoryCode() {
		return categoryCode;
	}

	public void setCategoryCode(String categoryCode) {
		this.categoryCode = categoryCode;
	}


}
