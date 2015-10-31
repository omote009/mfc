package mfc.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="session_comment_history")
public class SessionCommentHistory extends AbstractEntity {

	@Id
	@Column(name = "event_id")
	private String eventId;
	
	@Id
	@Column(name = "user_id")
	private String userId;
	
	@Id
	@Column(name = "seq_no")
	private Long seqNo;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "update_date_time")
	private Timestamp updateDateTime;
	
	@Column(name = "comment_user_id")
	private String commentUserId;
	
	@Column(name = "comment_user_name")
	private String commentUserName;
	
	@Column(name = "comment_user_image")
	private String commentUserImage;
	
	@Column(name = "comment")
	private String comment;

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

	public Long getSeqNo() {
		return seqNo;
	}

	public void setSeqNo(Long seqNo) {
		this.seqNo = seqNo;
	}

	public Timestamp getUpdateDateTime() {
		return updateDateTime;
	}

	public void setUpdateDateTime(Timestamp updateDateTime) {
		this.updateDateTime = updateDateTime;
	}

	public String getCommentUserId() {
		return commentUserId;
	}

	public void setCommentUserId(String commentUserId) {
		this.commentUserId = commentUserId;
	}

	public String getCommentUserName() {
		return commentUserName;
	}

	public void setCommentUserName(String commentUserName) {
		this.commentUserName = commentUserName;
	}

	public String getCommentUserImage() {
		return commentUserImage;
	}

	public void setCommentUserImage(String commentUserImage) {
		this.commentUserImage = commentUserImage;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

}
