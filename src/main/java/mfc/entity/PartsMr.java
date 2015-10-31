package mfc.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="parts_mr")
public class PartsMr extends AbstractEntity{

	@Id
	@Column(name = "parts_code")
	private String partsCode;
	@Column(name = "parts_name")
	private String partsName;
	@Column(name = "parts_kana_name")
	private String partsKanaName;

	public String getPartsCode() {
		return partsCode;
	}

	public void setPartsCode(String partsCode) {
		this.partsCode = partsCode;
	}

	public String getPartsName() {
		return partsName;
	}

	public void setPartsName(String partsName) {
		this.partsName = partsName;
	}

	public String getPartsKanaName() {
		return partsKanaName;
	}

	public void setPartsKanaName(String partsKanaName) {
		this.partsKanaName = partsKanaName;
	}

}
