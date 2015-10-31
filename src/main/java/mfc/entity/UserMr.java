package mfc.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="user_mr")
public class UserMr extends AbstractEntity{

	@Id
	@Column(name = "user_id")
	private String userId;
	@Column(name = "user_name")
	private String userName;
	@Column(name = "user_mail_addr")
	private String userMailAddr;
	@Column(name = "user_sex")
	private String userSex;
	@Column(name = "user_birth_year")
	private String userBirthYear;
	@Column(name = "user_type")
	private String userType;
	@Column(name = "comment_count")
	private Long commentCount;
	@Column(name = "promoter_value")
	private Long promoterValue;
	@Column(name = "user_image_path")
	private String userImagePath;
	private String password;
	private Long count;
	@Column(name = "prefecture_code")
	private String prefectureCode;
	@Column(name = "promoter_ave_value")
	private String promoterAveValue;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserMailAddr() {
		return userMailAddr;
	}

	public void setUserMailAddr(String userMailAddr) {
		this.userMailAddr = userMailAddr;
	}

	public String getUserSex() {
		return userSex;
	}

	public void setUserSex(String userSex) {
		this.userSex = userSex;
	}

	public String getUserBirthYear() {
		return userBirthYear;
	}

	public void setUserBirthYear(String userBirthYear) {
		this.userBirthYear = userBirthYear;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public Long getCommentCount() {
		return commentCount;
	}

	public void setCommentCount(Long commentCount) {
		this.commentCount = commentCount;
	}

	public Long getPromoterValue() {
		return promoterValue;
	}

	public void setPromoterValue(Long promoterValue) {
		this.promoterValue = promoterValue;
	}

	public String getUserImagePath() {
		return userImagePath;
	}

	public void setUserImagePath(String userImagePath) {
		this.userImagePath = userImagePath;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Long getCount() {
		return count;
	}

	public void setCount(Long count) {
		this.count = count;
	}

	public String getPrefectureCode() {
		return prefectureCode;
	}

	public void setPrefectureCode(String prefectureCode) {
		this.prefectureCode = prefectureCode;
	}

	public String getPromoterAveValue() {
		return this.promoterAveValue;
	}

	public void setPromoterAveValue(String ave) {
		this.promoterAveValue = ave;
	}

}
