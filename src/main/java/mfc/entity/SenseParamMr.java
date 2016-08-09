package mfc.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="sense_param_mr")
public class SenseParamMr extends AbstractEntity {


    @Id
    @Column(name = "param_key")
    private String paramKey;

    @Id
    @Column(name = "sub_key")
    private String subKey;

    @Column(name = "param_name")
    private String paramName;

    public String getParamKey() {
        return paramKey;
    }

    public void setParamKey(String paramKey) {
        this.paramKey = paramKey;
    }

    public String getSubKey() {
        return subKey;
    }

    public void setSubKey(String subKey) {
        this.subKey = subKey;
    }

    public String getParamName() {
        return paramName;
    }

    public void setParamName(String paramName) {
        this.paramName = paramName;
    }

}
