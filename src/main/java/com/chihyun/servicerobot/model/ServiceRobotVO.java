package com.chihyun.servicerobot.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ServiceRobot")
public class ServiceRobotVO {
	@Id
    @Column(name = "keywordNo")
	private Integer keywordNo;
    @Column(name = "keywordName")
    private String keywordName;
    @Column(name = "responseContent")
    private String responseContent;

    public Integer getKeywordNo() {
        return keywordNo;
    }

    public void setKeywordNo(Integer keywordNo) {
        this.keywordNo = keywordNo;
    }

    public String getKeywordName() {
        return keywordName;
    }

    public void setKeywordName(String keywordName) {
        this.keywordName = keywordName;
    }

    public String getResponseContent() {
        return responseContent;
    }

    public void setResponseContent(String responseContent) {
        this.responseContent = responseContent;
    }
}
