package mfc.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="long_live_control")
public class LongLiveControl extends AbstractEntity {

	@Id
	@Column(name = "long_live_id")
	private String longLiveId;
	@Column(name = "user_id")
	private String userId;
	@Column(name = "password")
	private String password;

	public String getLongLiveId() {
		return longLiveId;
	}

	public void setLongLiveId(String longLiveId) {
		this.longLiveId = longLiveId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
