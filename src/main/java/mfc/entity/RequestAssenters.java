package mfc.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * リクエスト賛同者<br />
 * 
 * @author omote
 *
 */
@Entity
@Table(name="request_assenters")
public class RequestAssenters extends AbstractEntity{

	@Id
	@Column(name = "request_id")
	private String requestId;
	@Id
	@Column(name = "user_id")
	private String userId;
	@Column(name = "for_or_against_flag")
	private String forOrAgainstFlag;

	public String getRequestId() {
		return requestId;
	}

	public void setRequestId(String requestId) {
		this.requestId = requestId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getForOrAgainstFlag() {
		return forOrAgainstFlag;
	}

	public void setForOrAgainstFlag(String forOrAgainstFlag) {
		this.forOrAgainstFlag = forOrAgainstFlag;
	}

}
