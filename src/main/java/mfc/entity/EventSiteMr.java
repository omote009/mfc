package mfc.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="event_site_mr")
public class EventSiteMr extends AbstractEntity {

	@Id
	@Column(name = "event_site_code")
	private String eventSiteCode;
	@Column(name = "event_site_name")
	private String eventSiteName;
	@Column(name = "event_site_kana_name")
	private String eventSiteKanaName;
	@Column(name = "event_site_zip_code")
	private String eventSiteZipCode;
	@Column(name = "event_site_address")
	private String eventSiteAddress;
	@Column(name = "event_site_telno")
	private String eventSiteTelno;
	@Column(name = "event_site_mailaddr")
	private String eventSiteMailaddr;
	@Column(name = "event_site_url")
	private String eventSiteUrl;
	@Column(name = "business_hours")
	private String businessHours;
	@Column(name = "meal_right_flg")
	private String mealRightFlg;
	@Column(name = "locker_exist_flg")
	private String lockerExistFlg;
	@Column(name = "seats_capacity")
	private Long seatsCapacity;
	@Column(name = "site_evaluate_value")
	private Long siteEvaluateValue;
	@Column(name = "site_advice_value")
	private Long siteAdviceValue;
	@Column(name = "promoter_name")
	private String promoterName;
	@Column(name = "user_id")
	private String userId;
	private Long count;
	@Column(name = "site_type_code")
	private String siteTypeCode;
	@Column(name = "site_eval_ave_value")
	private String siteEvalAveValue;
	@Column(name = "prefecture_code")
	private String prefectureCode;
	@Column(name = "url_ok")
	private String urlOk;

	public String getEventSiteCode() {
		return eventSiteCode;
	}

	public void setEventSiteCode(String eventSiteCode) {
		this.eventSiteCode = eventSiteCode;
	}

	public String getEventSiteName() {
		return eventSiteName;
	}

	public void setEventSiteName(String eventSiteName) {
		this.eventSiteName = eventSiteName;
	}

	public String getEventSiteKanaName() {
		return eventSiteKanaName;
	}

	public void setEventSiteKanaName(String eventSiteKanaName) {
		this.eventSiteKanaName = eventSiteKanaName;
	}

	public String getEventSiteZipCode() {
		return eventSiteZipCode;
	}

	public void setEventSiteZipCode(String eventSiteZipCode) {
		this.eventSiteZipCode = eventSiteZipCode;
	}

	public String getEventSiteAddress() {
		return eventSiteAddress;
	}

	public void setEventSiteAddress(String eventSiteAddress) {
		this.eventSiteAddress = eventSiteAddress;
	}

	public String getEventSiteTelno() {
		return eventSiteTelno;
	}

	public void setEventSiteTelno(String eventSiteTelno) {
		this.eventSiteTelno = eventSiteTelno;
	}

	public String getEventSiteMailaddr() {
		return eventSiteMailaddr;
	}

	public void setEventSiteMailaddr(String eventSiteMailaddr) {
		this.eventSiteMailaddr = eventSiteMailaddr;
	}

	public String getEventSiteUrl() {
		return eventSiteUrl;
	}

	public void setEventSiteUrl(String eventSiteUrl) {
		this.eventSiteUrl = eventSiteUrl;
	}

	public String getBusinessHours() {
		return businessHours;
	}

	public void setBusinessHours(String businessHours) {
		this.businessHours = businessHours;
	}

	public String getMealRightFlg() {
		return mealRightFlg;
	}

	public void setMealRightFlg(String mealRightFlg) {
		this.mealRightFlg = mealRightFlg;
	}

	public String getLockerExistFlg() {
		return lockerExistFlg;
	}

	public void setLockerExistFlg(String lockerExistFlg) {
		this.lockerExistFlg = lockerExistFlg;
	}

	public Long getSeatsCapacity() {
		return seatsCapacity;
	}

	public void setSeatsCapacity(Long seatsCapacity) {
		this.seatsCapacity = seatsCapacity;
	}

	public Long getSiteEvaluateValue() {
		return siteEvaluateValue;
	}

	public void setSiteEvaluateValue(Long siteEvaluateValue) {
		this.siteEvaluateValue = siteEvaluateValue;
	}

	public Long getSiteAdviceValue() {
		return siteAdviceValue;
	}

	public void setSiteAdviceValue(Long siteAdviceValue) {
		this.siteAdviceValue = siteAdviceValue;
	}

	public String getPromoterName() {
		return promoterName;
	}

	public void setPromoterName(String promoterName) {
		this.promoterName = promoterName;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Long getCount() {
		return count;
	}

	public void setCount(Long count) {
		this.count = count;
	}

	public String getSiteTypeCode() {
		return siteTypeCode;
	}

	public void setSiteTypeCode(String siteTypeCode) {
		this.siteTypeCode = siteTypeCode;
	}

	public String getSiteEvalAveValue() {
		return siteEvalAveValue;
	}

	public void setSiteEvalAveValue(String siteEvalAveValue) {
		this.siteEvalAveValue = siteEvalAveValue;
	}

	public String getPrefectureCode() {
		return prefectureCode;
	}

	public void setPrefectureCode(String prefectureCode) {
		this.prefectureCode = prefectureCode;
	}

	public String getUrlOk() {
		return urlOk;
	}

	public void setUrlOk(String urlOk) {
		this.urlOk = urlOk;
	}

}
