package mfc.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * ユニークキー生成時に重複がないかをチェックするためのテーブル<br />
 * 
 * @author omote
 *
 */
@Entity
@Table(name="used_kes")
public class UsedKey extends AbstractEntity{

	@Id
	@Column(name = "used_uniq_key")
	private String usedUniqKey;

	public String getUsedUniqKey() {
		return usedUniqKey;
	}

	public void setUsedUniqKey(String usedUniqKey) {
		this.usedUniqKey = usedUniqKey;
	}

}
