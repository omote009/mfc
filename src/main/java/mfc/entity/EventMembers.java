package mfc.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * セッション参加メンバーリスト<br />
 * 
 * @author omote
 *
 */
@Entity
@Table(name="event_members")
public class EventMembers extends AbstractEntity {

	@Id
	@Column(name = "event_id")
	private String eventId;
	@Id
	@Column(name = "user_id")
	private String userId;
	@Column(name = "parts_code")
	private String partsCode;
	@Column(name = "comment")
	private String comment;
	@Column(name = "ok_flag")
	private String okFlag;
	@Column(name = "reason")
	private String reason;
	@Column(name = "ticket_id")
	private String ticketId;
	

	public String getEventId() {
		return eventId;
	}

	public void setEventId(String eventId) {
		this.eventId = eventId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPartsCode() {
		return partsCode;
	}

	public void setPartsCode(String partsCode) {
		this.partsCode = partsCode;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getOkFlag() {
		return okFlag;
	}

	public void setOkFlag(String okFlag) {
		this.okFlag = okFlag;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getTicketId() {
		return this.ticketId;
	}

	public void setTicketId(String val) {
		this.ticketId = val;
	}

}
