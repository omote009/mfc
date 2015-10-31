package mfc.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * お気に入りイベント<br />
 * 
 * @author omote
 *
 */
@Entity
@Table(name="my_favorite_session")
public class MyFavoriteSession extends AbstractEntity {

	@Id
	@Column(name = "user_id")
	private String userId;
	@Id
	@Column(name = "event_id")
	private String eventId;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getEventId() {
		return eventId;
	}

	public void setEventId(String eventId) {
		this.eventId = eventId;
	}

}
