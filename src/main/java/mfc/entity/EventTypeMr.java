package mfc.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * 音楽タイプマスタ<br />
 * 結合条件定義による名前重複を避けてイベントタイプとしている<br />
 * 
 * @author omote
 *
 */
@Entity
@Table(name="music_type_mr")
public class EventTypeMr extends AbstractEntity{

	@Id
	@Column(name = "music_type_code")
	private String musicTypeCode;
	@Column(name = "music_type_name")
	private String musicTypeName;
	@Column(name = "music_type_kana_name")
	private String musicTypeKanaName;

	public String getMusicTypeCode() {
		return musicTypeCode;
	}

	public void setMusicTypeCode(String musicTypeCode) {
		this.musicTypeCode = musicTypeCode;
	}

	public String getMusicTypeName() {
		return musicTypeName;
	}

	public void setMusicTypeName(String musicTypeName) {
		this.musicTypeName = musicTypeName;
	}

	public String getMusicTypeKanaName() {
		return musicTypeKanaName;
	}

	public void setMusicTypeKanaName(String musicTypeKanaName) {
		this.musicTypeKanaName = musicTypeKanaName;
	}
	
	// 結合条件
	@OneToOne(mappedBy = "child")
	public EventTypeList eventTypeList;

}
