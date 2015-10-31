package mfc.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 都道府県マスタ<br />
 * 
 * @author omote
 *
 */
@Entity
@Table(name="minicipality_mr")
public class MinicipalityMr extends AbstractEntity{

	@Id
	@Column(name = "prefecture_code")
	private String prefectureCode;
	@Id
	@Column(name = "minicipality_code")
	private String minicipalityCode;
	@Column(name = "minicipality_name")
	private String minicipalityName;
	@Column(name = "minicipality_kana_name")
	private String minicipalityKanaName;

	public String getPrefectureCode() {
		return prefectureCode;
	}

	public void setPrefectureCode(String prefectureCode) {
		this.prefectureCode = prefectureCode;
	}

	public String getMinicipalityCode() {
		return minicipalityCode;
	}

	public void setMinicipalityCode(String minicipalityCode) {
		this.minicipalityCode = minicipalityCode;
	}

	public String getMinicipalityName() {
		return minicipalityName;
	}

	public void setMinicipalityName(String minicipalityName) {
		this.minicipalityName = minicipalityName;
	}

	public String getMinicipalityKanaName() {
		return minicipalityKanaName;
	}

	public void setMinicipalityKanaName(String minicipalityKanaName) {
		this.minicipalityKanaName = minicipalityKanaName;
	}
}
