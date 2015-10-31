package mfc.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * 音楽タイプマスタ<br />
 *
 * @author omote
 *
 */
@Entity
@Table(name="music_type_mr")
public class MusicTypeMr extends AbstractEntity{

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

	@OneToMany(mappedBy="musicTypeMr")
	public List<MyType> myTypeList;

}
