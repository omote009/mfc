package mfc.entity;

import java.sql.Time;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * イベント評価コメント<br />
 * 
 * @author omote
 *
 */
@Entity
@Table(name="event_evaluate_comment")
public class EventEvaluateComment extends AbstractEntity{

	@Id
	@Column(name = "event_id")
	private String eventId;
	@Id
	@Column(name = "user_id")
	private String userId;
	@Column(name = "comment")
	private String comment;
	@Column(name = "user_name")
	private String userName;
	@Temporal(TemporalType.DATE)
	@Column(name = "update_date")
	private Date updateDate;
	@Temporal(TemporalType.DATE)
	@Column(name = "update_time")
	private Time updateTime;
	@Column(name = "event_value")
	private Long eventValue;
	@Column(name = "user_image_path")
	private String userImagePath;

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

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public Time getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Time updateTime) {
		this.updateTime = updateTime;
	}

	public Long getEventValue() {
		return eventValue;
	}

	public void setEventValue(Long eventValue) {
		this.eventValue = eventValue;
	}

	public String getUserImagePath() {
		return userImagePath;
	}

	public void setUserImagePath(String userImagePath) {
		this.userImagePath = userImagePath;
	}

}
