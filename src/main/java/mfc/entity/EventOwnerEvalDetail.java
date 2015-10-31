package mfc.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="event_owner_eval_detail")
public class EventOwnerEvalDetail {

	@Id
	@Column(name = "event_id")
	private String eventId;
	@Id
	@Column(name = "owner_user_id")
	private String ownerUserId;
	@Id
	@Column(name = "user_id")
	private String userId;
	@Column(name = "value")
	private Long value;

	public String getEventId() {
		return eventId;
	}

	public void setEventId(String eventId) {
		this.eventId = eventId;
	}

	public String getOwnerUserId() {
		return ownerUserId;
	}

	public void setOwnerUserId(String ownerUserId) {
		this.ownerUserId = ownerUserId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Long getValue() {
		return value;
	}

	public void setValue(Long value) {
		this.value = value;
	}

}
