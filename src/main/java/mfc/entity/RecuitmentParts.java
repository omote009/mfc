package mfc.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="recuitment_parts")
public class RecuitmentParts extends AbstractEntity {

	@Id
	@Column(name = "event_id")
	private String eventId;

	@Id
	@Column(name = "parts_code")
	private String partsCode;
	
	@Column(name = "fixed_number")
	private Long fixedNumber;
	
	@Column(name = "result_number")
	private Long resultNumber;
	
	@Column(name = "recruit_flag")
	private String recruitFlag;
	
	@Column(name = "waiting_number")
	private Long waitingNumber;
	
	public String getEventId() {
		return eventId;
	}

	public void setEventId(String eventId) {
		this.eventId = eventId;
	}

	public String getPartsCode() {
		return partsCode;
	}

	public void setPartsCode(String partsCode) {
		this.partsCode = partsCode;
	}

	public Long getFixedNumber() {
		return fixedNumber;
	}

	public void setFixedNumber(Long fixedNumber) {
		this.fixedNumber = fixedNumber;
	}

	public Long getResultNumber() {
		return resultNumber;
	}

	public void setResultNumber(Long resultNumber) {
		this.resultNumber = resultNumber;
	}

	public String getRecruitFlag() {
		return recruitFlag;
	}

	public void setRecruitFlag(String recruitFlag) {
		this.recruitFlag = recruitFlag;
	}

	public Long getWaitingNumber() {
		return waitingNumber;
	}

	public void setWaitingNumber(Long waitingNumber) {
		this.waitingNumber = waitingNumber;
	}

}
