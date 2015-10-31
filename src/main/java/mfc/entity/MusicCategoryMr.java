package mfc.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 音楽ジャンルマスタ<br />
 * 
 * @author omote
 *
 */
@Entity
@Table(name="music_category_mr")
public class MusicCategoryMr extends AbstractEntity{

	@Id
	@Column(name = "category_code")
	private String categoryCode;
	@Column(name = "category_name")
	private String categoryName;
	@Column(name = "category_kana_name")
	private String categoryKanaName;

	public String getCategoryCode() {
		return categoryCode;
	}

	public void setCategoryCode(String categoryCode) {
		this.categoryCode = categoryCode;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getCategoryKanaName() {
		return categoryKanaName;
	}

	public void setCategoryKanaName(String categoryKanaName) {
		this.categoryKanaName = categoryKanaName;
	}
}
