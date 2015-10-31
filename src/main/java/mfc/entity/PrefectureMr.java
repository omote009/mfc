package mfc.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 市レベルマスタ<br />
 * 
 * @author omote
 *
 */
@Entity
@Table(name="prefecture_mr")
public class PrefectureMr extends AbstractEntity{

	@Id
	@Column(name = "prefecture_code")
	private String prefectureCode;
	@Column(name = "prefecture_name")
	private String prefectureName;
	@Column(name = "prefecture_kana_name")
	private String prefectureKanaName;

	public String getPrefectureCode() {
		return prefectureCode;
	}

	public void setPrefectureCode(String prefectureCode) {
		this.prefectureCode = prefectureCode;
	}

	public String getPrefectureName() {
		return prefectureName;
	}

	public void setPrefectureName(String prefectureName) {
		this.prefectureName = prefectureName;
	}

	public String getPrefectureKanaName() {
		return prefectureKanaName;
	}

	public void setPrefectureKanaName(String prefectureKanaName) {
		this.prefectureKanaName = prefectureKanaName;
	}
}
