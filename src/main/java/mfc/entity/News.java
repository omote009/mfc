package mfc.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * ニュースマスタ<br />
 *
 * @author omote
 *
 */
@Entity
@Table(name="news")
public class News extends AbstractEntity{

	@Id
	@Column(name = "news_id")
	private String newsId;
	@Temporal(TemporalType.DATE)
	@Column(name = "news_date")
	private Date newsDate;
	@Column(name = "news_title")
	private String newsTitle;
	@Column(name = "news_body")
	private String newsBody;
	@Column(name = "user_id")
	private String userId;
	@Column(name = "news_url")
	private String newsUrl;

	public String getNewsId() {
		return newsId;
	}

	public void setNewsId(String newsId) {
		this.newsId = newsId;
	}

	public Date getNewsDate() {
		return newsDate;
	}

	public void setNewsDate(Date newsDate) {
		this.newsDate = newsDate;
	}

	public String getNewsTitle() {
		return newsTitle;
	}

	public void setNewsTitle(String newsTitle) {
		this.newsTitle = newsTitle;
	}

	public String getNewsBody() {
		return newsBody;
	}

	public void setNewsBody(String newsBody) {
		this.newsBody = newsBody;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getNewsUrl() {
		return newsUrl;
	}

	public void setNewsUrl(String newsUrl) {
		this.newsUrl = newsUrl;
	}
}
