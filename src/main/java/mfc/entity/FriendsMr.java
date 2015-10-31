package mfc.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * お仲間マスタ<br />
 * 
 * @author omote
 *
 */
@Entity
@Table(name="friends_mr")
public class FriendsMr extends AbstractEntity{

	@Id
	@Column(name = "user_id")
	private String userId;
	@Id
	@Column(name = "friend_user_id")
	private String friendUserId;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getFriendUserId() {
		return friendUserId;
	}

	public void setFriendUserId(String friendUserId) {
		this.friendUserId = friendUserId;
	}
}
