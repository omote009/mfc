package mfc.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="event_artist_eval_history")
public class EventArtistEvalHistory extends AbstractEntity{

	@Id
	@Column(name = "event_id")
	private String eventId;
	@Id
	@Column(name = "artist_code")
	private String artistCode;
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

	public String getArtistCode() {
		return artistCode;
	}

	public void setArtistCode(String artistCode) {
		this.artistCode = artistCode;
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
