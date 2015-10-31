package mfc.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * ユーザ仮登録マスタ<br />
 * 
 * @author omote
 *
 */
@Entity
@Table(name="tmp_usr_mr")
public class TmpUsrMr extends AbstractEntity {

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
	@Column(name = "user_image_path")
	private String userImagePath;
	@Column(name = "password")
	private String password;
	@Column(name = "prefecture_code")
	private String prefectureCode;

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
	
	public String getPrefectureCode() {
		return prefectureCode;
	}
	
	public void setPrefectureCode(final String prefectureCode) {
		this.prefectureCode = prefectureCode; 
	}
	

}
