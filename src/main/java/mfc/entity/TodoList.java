package mfc.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="todo_list")
public class TodoList {

	@Id
	@Column(name = "user_id")
	private String userId;

	@Id
	@Column(name = "activity_date")
	private Date activityDate;

	@Id
	@Column(name = "seq_no")
	private Integer seqNo;

	@Column(name = "todo_comment")
	private String todoComment;

	@Column(name = "todo_flag")
	private String todoFlag;

	@Column(name = "yobi_one")
	private String yobiOne;

	@Column(name = "yobi_two")
	private String yobiTwo;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Date getActivityDate() {
		return activityDate;
	}

	public void setActivityDate(Date activityDate) {
		this.activityDate = activityDate;
	}

	public Integer getSeqNo() {
		return seqNo;
	}

	public void setSeqNo(Integer seqNo) {
		this.seqNo = seqNo;
	}

	public String getTodoComment() {
		return todoComment;
	}

	public void setTodoComment(String todoComment) {
		this.todoComment = todoComment;
	}

	public String getTodoFlag() {
		return todoFlag;
	}

	public void setTodoFlag(String todoFlag) {
		this.todoFlag = todoFlag;
	}

	public String getYobiOne() {
		return yobiOne;
	}

	public void setYobiOne(String yobiOne) {
		this.yobiOne = yobiOne;
	}

	public String getYobiTwo() {
		return yobiTwo;
	}

	public void setYobiTwo(String yobiTwo) {
		this.yobiTwo = yobiTwo;
	}

}
