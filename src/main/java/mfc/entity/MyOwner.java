package mfc.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="my_owner")
public class MyOwner extends AbstractEntity{

	@Id
	@Column(name = "user_id")
	private String userId;
	@Id
	@Column(name = "owner_user_id")
	private String ownerUserId;
	
	public void setUserId(final String id) {
		this.userId = id;
	}
	
	public String getUserId() {
		return this.userId;
	}
	
	public void setOwnerUserId(final String id) {
		this.ownerUserId = id;
	}
	
	public String getOwnerUserId() {
		return this.ownerUserId;
	}

	
}
