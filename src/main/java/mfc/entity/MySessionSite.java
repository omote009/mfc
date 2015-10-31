package mfc.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * お気に入りイベント開催場所<br />
 * 
 * @author omote
 *
 */
@Entity
@Table(name="my_session_site")
public class MySessionSite extends AbstractEntity {

	@Id
	@Column(name = "user_id")
	private String userId;
	@Id
	@Column(name = "event_site_code")
	private String eventSiteCode;
	
	public void setUserId(final String id){
		this.userId = id;
	}
	
	public String getUserId() {
		return this.userId;
	}
	
	public void setEventSiteCode(final String code) {
		this.eventSiteCode = code;
	}
	
	public String getEventSiteCode() {
		return this.eventSiteCode;
	}


}
