package mfc.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * お仲間リスト<br />
 * 
 * @author omote
 *
 */
@Entity
@Table(name="event_friend_list")
public class EventFriendList extends AbstractEntity {

	@Id
	@Column(name = "event_id")
	private String eventId;
	@Id
	@Column(name = "friend_user_id")

	private String friendUserId;

	public String getEventId() {
		return eventId;
	}

	public void setEventId(String eventId) {
		this.eventId = eventId;
	}

	public String getFriendUserId() {
		return friendUserId;
	}

	public void setFriendUserId(String friendUserId) {
		this.friendUserId = friendUserId;
	}

}
