package mfc.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.seasar.framework.util.StringUtil;

/**
 * 音楽出演者マスタ<br />
 * 
 * @author omote
 *
 */
@Entity
@Table(name="artist_mr")
public class ArtistMr extends AbstractEntity{

	@Id
	@Column(name = "artist_code")
	private String artistCode;
	@Column(name = "artist_name_1")
	private String artistName1;
	@Column(name = "artist_name_2")
	private String artistName2;
	@Column(name = "artist_name_3")
	private String artistName3;
	@Column(name = "artist_evaluate_value")
	private Long artistEvaluateValue;
	@Column(name = "artist_advice_value")
	private Long artistAdviceValue;
	@Column(name = "artist_office_code")
	private String artistOfficeCode;
	@Column(name = "artist_apeal")
	private String artistApeal;
	@Column(name = "artist_profile")
	private String artistProfile;
	@Column(name = "artist_home_url")
	private String artistHomeUrl;
	@Column(name = "artist_sub_url")
	private String artistSubUrl;
	@Column(name = "artist_other_url_one")
	private String artistOtherUrlOne;
	@Column(name = "artist_other_url_two")
	private String artistOtherUrlTwo;
	@Column(name = "artist_other_url_three")
	private String artistOtherUrlThree;
	@Column(name = "artist_image")
	private String artistImage;
	@Column(name = "count")
	private Long count;

	public String getArtistCode() {
		return artistCode;
	}

	public void setArtistCode(String artistCode) {
		this.artistCode = artistCode;
	}

	public String getArtistName1() {
		return artistName1;
	}

	public void setArtistName1(String artistName1) {
		this.artistName1 = artistName1;
	}

	public String getArtistName2() {
		return artistName2;
	}

	public void setArtistName2(String artistName2) {
		this.artistName2 = artistName2;
	}

	public String getArtistName3() {
		return artistName3;
	}

	public void setArtistName3(String artistName3) {
		this.artistName3 = artistName3;
	}

	public Long getArtistEvaluateValue() {
		return artistEvaluateValue;
	}

	public void setArtistEvaluateValue(Long artistEvaluateValue) {
		this.artistEvaluateValue = artistEvaluateValue;
	}

	public Long getArtistAdviceValue() {
		return artistAdviceValue;
	}

	public void setArtistAdviceValue(Long artistAdviceValue) {
		this.artistAdviceValue = artistAdviceValue;
	}

	public String getArtistOfficeCode() {
		return artistOfficeCode;
	}

	public void setArtistOfficeCode(String artistOfficeCode) {
		this.artistOfficeCode = artistOfficeCode;
	}

	public String getArtistApeal() {
		return artistApeal;
	}

	public void setArtistApeal(String artistApeal) {
		this.artistApeal = artistApeal;
	}

	public String getArtistProfile() {
		return artistProfile;
	}

	public void setArtistProfile(String artistProfile) {
		this.artistProfile = artistProfile;
	}

	public String getArtistHomeUrl() {
		if(StringUtil.isBlank(artistHomeUrl)){
			return null;
		}else{
			return artistHomeUrl;
		}
		
	}

	public void setArtistHomeUrl(String artistHomeUrl) {
		this.artistHomeUrl = artistHomeUrl;
	}

	public String getArtistSubUrl() {
		if(StringUtil.isBlank(artistSubUrl)){
			return null;
		}else{
			return artistSubUrl;
		}
		
	}

	public void setArtistSubUrl(String artistSubUrl) {
		this.artistSubUrl = artistSubUrl;
	}

	public String getArtistOtherUrlOne() {
		if(StringUtil.isBlank(artistOtherUrlOne)){
			return null;
		}else{
			return artistOtherUrlOne;	
		}
		
	}

	public void setArtistOtherUrlOne(String artistOtherUrlOne) {
		this.artistOtherUrlOne = artistOtherUrlOne;
	}

	public String getArtistOtherUrlTwo() {
		if(StringUtil.isBlank(artistOtherUrlTwo)){
			return null;
		}else{
			return artistOtherUrlTwo;
		}
	}

	public void setArtistOtherUrlTwo(String artistOtherUrlTwo) {
		this.artistOtherUrlTwo = artistOtherUrlTwo;
	}

	public String getArtistOtherUrlThree() {
		if(StringUtil.isBlank(artistOtherUrlThree)){
			return null;
		}else{
			return artistOtherUrlThree;
		}
		
	}

	public void setArtistOtherUrlThree(String artistOtherUrlThree) {
		this.artistOtherUrlThree = artistOtherUrlThree;
	}

	public String getArtistImage() {
		return artistImage;
	}

	public void setArtistImage(String artistImage) {
		this.artistImage = artistImage;
	}

	public Long getCount() {
		return count;
	}

	public void setCount(Long count) {
		this.count = count;
	}


}
