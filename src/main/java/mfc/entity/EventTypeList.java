package mfc.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * イベントに関連づいた音楽タイプのリスト<br />
 * 
 * @author omote
 *
 */
@Entity
@Table(name="event_type_list")
public class EventTypeList extends AbstractEntity {

	@Id
	@Column(name = "event_id")
	private String eventId;
	@Id
	@Column(name = "music_type_code")
	private String musicTypeCode;

	public String getEventId() {
		return eventId;
	}

	public void setEventId(String eventId) {
		this.eventId = eventId;
	}

	public String getMusicTypeCode() {
		return musicTypeCode;
	}

	public void setMusicTypeCode(String musicTypeCode) {
		this.musicTypeCode = musicTypeCode;
	}

	// 結合定義
	@OneToOne
	@JoinColumn(name = "music_type_code")
	public EventTypeMr child;

}
