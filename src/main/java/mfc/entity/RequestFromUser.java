package mfc.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * ユーザからのリクエスト<br />
 * 
 * @author omote
 *
 */
@Entity
@Table(name="request_from_user")
public class RequestFromUser extends AbstractEntity{

	@Id
	@Column(name = "request_id")
	private String requestId;
	@Temporal(TemporalType.DATE)
	@Column(name = "request_recieved_date")
	private Date requestRecievedDate;
	@Column(name = "request_body")
	private String requestBody;
	@Column(name = "contributor_name")
	private String contributorName;
	@Column(name = "contributor_user_id")
	private String contributorUserId;
	@Column(name = "contributor_mailaddr")
	private String contributorMailaddr;
	private String comment = "";;
	@Column(name = "comment_user_id")
	private String commentUserId = "";;
	@Temporal(TemporalType.DATE)
	@Column(name = "comment_date")
	private Date commentDate;
	@Column(name = "request_status")
	private String requestStatus = "0";;
	@Column(name = "response_detail")
	private String responseDetail = "";;
	@Column(name = "response_name")
	private String responseName = "";;
	@Column(name = "for_user_count")
	private Long forUserCount;
	@Column(name = "against_user_count")
	private Long againstUserCount;

	public String getRequestId() {
		return requestId;
	}

	public void setRequestId(String requestId) {
		this.requestId = requestId;
	}

	public Date getRequestRecievedDate() {
		return requestRecievedDate;
	}

	public void setRequestRecievedDate(Date requestRecievedDate) {
		this.requestRecievedDate = requestRecievedDate;
	}

	public String getRequestBody() {
		return requestBody;
	}

	public void setRequestBody(String requestBody) {
		this.requestBody = requestBody;
	}

	public String getContributorName() {
		return contributorName;
	}

	public void setContributorName(String contributorName) {
		this.contributorName = contributorName;
	}

	public String getContributorUserId() {
		return contributorUserId;
	}

	public void setContributorUserId(String contributorUserId) {
		this.contributorUserId = contributorUserId;
	}

	public String getContributorMailaddr() {
		return contributorMailaddr;
	}

	public void setContributorMailaddr(String contributorMailaddr) {
		this.contributorMailaddr = contributorMailaddr;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getCommentUserId() {
		return commentUserId;
	}

	public void setCommentUserId(String commentUserId) {
		this.commentUserId = commentUserId;
	}

	public Date getCommentDate() {
		return commentDate;
	}

	public void setCommentDate(Date commentDate) {
		this.commentDate = commentDate;
	}

	public String getRequestStatus() {
		return requestStatus;
	}

	public void setRequestStatus(String requestStatus) {
		this.requestStatus = requestStatus;
	}

	public String getResponseDetail() {
		return responseDetail;
	}

	public void setResponseDetail(String responseDetail) {
		this.responseDetail = responseDetail;
	}

	public String getResponseName() {
		return responseName;
	}

	public void setResponseName(String responseName) {
		this.responseName = responseName;
	}

	public Long getForUserCount() {
		return forUserCount;
	}

	public void setForUserCount(Long forUserCount) {
		this.forUserCount = forUserCount;
	}

	public Long getAgainstUserCount() {
		return againstUserCount;
	}

	public void setAgainstUserCount(Long againstUserCount) {
		this.againstUserCount = againstUserCount;
	}
}
