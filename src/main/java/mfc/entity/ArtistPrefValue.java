package mfc.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="artist_pref_value")
public class ArtistPrefValue extends AbstractEntity{

	@Id
	@Column(name = "artist_code")
	private String artistCode;
	@Id
	@Column(name = "prefecture_code")
	private String prefectureCode;
	@Column(name = "sum_value")
	private Long sumValue;
	@Column(name = "ave_value")
	private String aveValue;
	@Column(name = "count")
	private Long count;

	public String getArtistCode() {
		return artistCode;
	}

	public void setArtistCode(String artistCode) {
		this.artistCode = artistCode;
	}

	public String getPrefectureCode() {
		return prefectureCode;
	}

	public void setPrefectureCode(String prefectureCode) {
		this.prefectureCode = prefectureCode;
	}

	public Long getSumValue() {
		return sumValue;
	}

	public void setSumValue(Long sumValue) {
		this.sumValue = sumValue;
	}

	public String getAveValue() {
		return aveValue;
	}

	public void setAveValue(String aveValue) {
		this.aveValue = aveValue;
	}

	public Long getCount() {
		return count;
	}

	public void setCount(Long count) {
		this.count = count;
	}

}
