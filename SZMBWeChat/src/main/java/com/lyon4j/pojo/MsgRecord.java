package com.lyon4j.pojo;

import java.util.Date;

/**
 * 消息记录实体对象
 * @author Lyon
 */
public class MsgRecord {
	private int mrid;
	private String openid;
	private Date createTime;
	private String msgType;
	private String msgContent;
	
	public int getMrid() {
		return mrid;
	}
	
	public void setMrid(int mrid) {
		this.mrid = mrid;
	}
	public String getOpenid() {
		return openid;
	}
	public void setOpenid(String openid) {
		this.openid = openid;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public String getMsgType() {
		return msgType;
	}
	public void setMsgType(String msgType) {
		this.msgType = msgType;
	}
	public String getMsgContent() {
		return msgContent;
	}
	public void setMsgContent(String msgContent) {
		this.msgContent = msgContent;
	}
	
}
