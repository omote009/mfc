package mfc.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * お気に入り音楽ジャンル<br />
 * 
 * @author omote
 *
 */
@Entity
@Table(name="my_category")
public class MyCategory extends AbstractEntity{

	@Id
	@Column(name = "user_id")
	private String userId = "";
	@Id
	@Column(name = "category_code")
	private String categoryCode = "";
	
	public void setUserId(final String id) {
		this.userId = id;
	}
	
	public String getUserId() {
		return this.userId;
	}
	
	public void setCategoryCode(final String code){
		this.categoryCode = code;
	}
	
	public String getCategoryCode() {
		return this.categoryCode;
	}

}
