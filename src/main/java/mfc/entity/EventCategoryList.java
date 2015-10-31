package mfc.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * イベントと音楽ジャンルを関連づけるリスト<br />
 * 
 * @author omote
 *
 */
@Entity
@Table(name="event_category_list")
public class EventCategoryList extends AbstractEntity {

	@Id
	@Column(name = "event_id")
	private String eventId;
	@Id
	@Column(name = "category_code")
	private String categoryCode;

	public String getEventId() {
		return eventId;
	}

	public void setEventId(String eventId) {
		this.eventId = eventId;
	}

	public String getCategoryCode() {
		return categoryCode;
	}

	public void setCategoryCode(String categoryCode) {
		this.categoryCode = categoryCode;
	}

	
	// 1:n　結合定義　MusicCategoryMr　にparrentの名前で受け側（n:1側）を定義する
	@OneToOne
	@JoinColumn(name = "category_code")
	public EventCategoryMr child;

}
