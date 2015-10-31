package mfc.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * イベントに出演するアーティストのリスト<br />
 * 
 * @author omote
 *
 */
@Entity
@Table(name="event_artist_list")
public class EventArtistList extends AbstractEntity{

	@Id
	@Column(name = "event_id")
	private String eventId;
	@Id
	@Column(name = "artist_code")
	private String artistCode;
	@Column(name = "artist_name_1")
	private String artistName1;
	@Column(name = "artist_name_2")
	private String artistName2;
	@Column(name = "artist_name_3")
	private String artistName3;
	@Column(name = "artist_home_url")
	private String artistHomeUrl;
	@Column(name = "artist_sub_url")
	private String artistSubUrl;
	@Column(name = "artist_apeal")
	private String artistAppeal;
	@Column(name = "eval_value")
	private Long evalValue;
	
	
	public String getEventId() {
		return eventId;
	}

	public void setEventId(String eventId) {
		this.eventId = eventId;
	}

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

	public String getArtistHomeUrl() {
		return artistHomeUrl;
	}

	public void setArtistHomeUrl(String artistHomeUrl) {
		this.artistHomeUrl = artistHomeUrl;
	}
	
	public void setArtistSubUrl(final String url){
		this.artistSubUrl = url;
	}
	
	public String getArtistSubUrl() {
		return this.artistSubUrl;
	}
	
	public void setArtistAppeal(final String appeal){
		this.artistAppeal = appeal;
	}
	
	public String getArtistAppeal() {
		return this.artistAppeal;
	}
	
	public void setEvalValue(final Long evalValue){
		this.evalValue = evalValue;
	}
	
	public Long getEvalValue() {
		return this.evalValue;
	}

}
