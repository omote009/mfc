package mfc.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="user_counter")
public class UserCounter extends AbstractEntity {

	@Id
	@Column(name = "user_id")
	private String userId;
	@Id
	@Column(name = "event_id")
	private String eventId;
	@Column(name = "count")
	private Long count;

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

	public Long getCount() {
		return count;
	}

	public void setCount(Long count) {
		this.count = count;
	}

}
