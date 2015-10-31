package mfc.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * お気に入りタイプを管理するテーブル<br />
 *
 * @author omote
 *
 */
@Entity
@Table(name="my_type")
public class MyType extends AbstractEntity{

	@Id
	@Column(name = "user_id")
	private String userId;
	@Id
	@Column(name = "music_type_code")
	private String musicTypeCode;

	public void setUserId(final String userId) {
		this.userId = userId;
	}

	public String getUserId() {
		return this.userId;
	}

	public void setMusicTypeCode(final String code){
		this.musicTypeCode = code;
	}

	public String getMusicTYpeCode() {
		return this.musicTypeCode;
	}

	@ManyToOne
	@JoinColumn(name="music_type_code", referencedColumnName="music_type_code") //<--結合カラムを指定
	public MusicTypeMr musicTYpeMr;

	/*@Column(name = "delete_flg")
	public String deleteFlg = "0";
	@Column(name = "update_user_id")
	public String updateUserId = "";
	@Column(name = "update_user_name")
	public String updateUserName;
	@Temporal(TemporalType.DATE)
	@Column(name = "update_timestamp")
	public Timestamp updateTimestamp = new Timestamp(System.currentTimeMillis());
	@Version
	public Long version = 0L;*/

}
