package mfc.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="event_data")
public class EventData extends AbstractEntity {

	@Id
	@Column(name = "event_id")
	private String eventId;
	@Column(name = "event_title")
	private String eventTitle;
	@Temporal(TemporalType.DATE)
	@Column(name = "activity_date")
	private Date activityDate;
	@Column(name = "open_time")
	private String openTime;
	@Column(name = "start_time")
	private String startTime;
	@Column(name = "event_site_code")
	private String eventSiteCode;
	@Column(name = "event_site_name")
	private String eventSiteName;
	@Column(name = "event_pay")
	private Long eventPay;
	@Column(name = "event_booking_rate")
	private Long eventBookingRate;
	@Column(name = "event_assumption")
	private String eventAssumption;
	@Column(name = "event_how_to_buy")
	private String eventHowToBuy;
	@Column(name = "event_appeal")
	private String eventAppeal;
	@Column(name = "event_evaluate_value")
	private Long eventEvaluateValue;
	@Column(name = "event_value")
	private Long eventValue;
	@Column(name = "prefecture_code")
	private String prefectureCode;
	@Column(name = "minicipality_code")
	private String minicipalityCode;
	@Column(name = "event_image_path")
	private String eventImagePath;
	@Column(name = "event_promoter_id")
	private String eventPromoterId;
	@Column(name = "event_type_code")
	private String eventTypeCode;
	@Column(name = "count")
	private Long count;
	@Column(name = "friends_only_flag")
	private String friendsOnlyFlag;
	@Column(name = "participant_use_flag")
	private String participantUseFlag;
	@Column(name = "participant_fixed_number")
	private Long participantFixedNumber;
	@Column(name = "participant_count")
	private Long participantCount;
	@Column(name = "participant_level")
	private String participantLevel;
	@Column(name = "participant_sex")
	private String participantSex;
	@Column(name = "event_eval_ave_value")
	private String eventEvalAveValue;

	public String getEventId() {
		return eventId;
	}

	public void setEventId(String eventId) {
		this.eventId = eventId;
	}

	public String getEventTitle() {
		return eventTitle;
	}

	public void setEventTitle(String eventTitle) {
		this.eventTitle = eventTitle;
	}

	public Date getActivityDate() {
		return activityDate;
	}

	public void setActivityDate(Date activityDate) {
		this.activityDate = activityDate;
	}

	public String getOpenTime() {
		return openTime;
	}

	public void setOpenTime(String openTime) {
		this.openTime = openTime;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

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

	public Long getEventPay() {
		return eventPay;
	}

	public void setEventPay(Long eventPay) {
		this.eventPay = eventPay;
	}

	public Long getEventBookingRate() {
		return eventBookingRate;
	}

	public void setEventBookingRate(Long eventBookingRate) {
		this.eventBookingRate = eventBookingRate;
	}

	public String getEventAssumption() {
		return eventAssumption;
	}

	public void setEventAssumption(String eventAssumption) {
		this.eventAssumption = eventAssumption;
	}

	public String getEventHowToBuy() {
		return eventHowToBuy;
	}

	public void setEventHowToBuy(String eventHowToBuy) {
		this.eventHowToBuy = eventHowToBuy;
	}

	public String getEventAppeal() {
		return eventAppeal;
	}

	public void setEventAppeal(String eventAppeal) {
		this.eventAppeal = eventAppeal;
	}

	public Long getEventEvaluateValue() {
		return eventEvaluateValue;
	}

	public void setEventEvaluateValue(Long eventEvaluateValue) {
		this.eventEvaluateValue = eventEvaluateValue;
	}

	public Long getEventValue() {
		return eventValue;
	}

	public void setEventValue(Long eventValue) {
		this.eventValue = eventValue;
	}

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

	public String getEventImagePath() {
		return eventImagePath;
	}

	public void setEventImagePath(String eventImagePath) {
		this.eventImagePath = eventImagePath;
	}

	public String getEventPromoterId() {
		return eventPromoterId;
	}

	public void setEventPromoterId(String eventPromoterId) {
		this.eventPromoterId = eventPromoterId;
	}

	public String getEventTypeCode() {
		return eventTypeCode;
	}

	public void setEventTypeCode(String eventTypeCode) {
		this.eventTypeCode = eventTypeCode;
	}

	public Long getCount() {
		return count;
	}

	public void setCount(Long count) {
		this.count = count;
	}

	public String getFriendsOnlyFlag() {
		return friendsOnlyFlag;
	}

	public void setFriendsOnlyFlag(String friendsOnlyFlag) {
		this.friendsOnlyFlag = friendsOnlyFlag;
	}

	public String getParticipantUseFlag() {
		return participantUseFlag;
	}

	public void setParticipantUseFlag(String participantUseFlag) {
		this.participantUseFlag = participantUseFlag;
	}

	public Long getParticipantFixedNumber() {
		return participantFixedNumber;
	}

	public void setParticipantFixedNumber(Long participantFixedNumber) {
		this.participantFixedNumber = participantFixedNumber;
	}

	public Long getParticipantCount() {
		return participantCount;
	}

	public void setParticipantCount(Long participantCount) {
		this.participantCount = participantCount;
	}

	public String getParticipantLevel() {
		return participantLevel;
	}

	public void setParticipantLevel(String participantLevel) {
		this.participantLevel = participantLevel;
	}

	public String getParticipantSex() {
		return participantSex;
	}

	public void setParticipantSex(String participantSex) {
		this.participantSex = participantSex;
	}

	public String getEventEvalAveValue() {
		return eventEvalAveValue;
	}

	public void setEventEvalAveValue(String ave) {
		this.eventEvalAveValue = ave;
	}

}
