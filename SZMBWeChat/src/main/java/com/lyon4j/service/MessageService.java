package com.lyon4j.service;
import com.alibaba.in.InImageMsg;
import com.alibaba.in.InLocationMsg;
import com.alibaba.in.InShortVideoMsg;
import com.alibaba.in.InTextMsg;
import com.alibaba.in.InVideoMsg;
import com.alibaba.in.InVoiceMsg;
import com.alibaba.in.event.InActionEvent;
import com.alibaba.in.event.InLocationEvent;
import com.alibaba.in.event.InMenuEvent;

/**
 * 
 * @author Administrator
 *
 */
public interface MessageService {
	/**
	 * 处理文本消息
	 * @param inMsg
	 * @return
	 */
	public String processInTextMsg(InTextMsg inMsg);	
	/**
	 * 处理位置消息
	 * @param inLocationMsg
	 * @return
	 */
	public String processInLocationMsg(InLocationMsg inLocationMsg);		
	/**
	 * 处理视频消息
	 * @param inVideoMsg
	 * @return
	 */
	public String processInVideoMsg(InVideoMsg inVideoMsg);		
	
	/**
	 * 处理图片消息
	 * @param inImageMsg
	 * @return
	 */
	public String processInImageMsg(InImageMsg inImageMsg);
	/**
	 * 处理语音信息
	 * @param inVoiceMsg
	 * @return
	 */
	public String processInVoiceMsg(InVoiceMsg inVoiceMsg);	
	/**
	 * 处理小视频消息
	 * @param inShortVideoMsg
	 * @return
	 */
	public String processInShortVideoMsg(InShortVideoMsg inShortVideoMsg);	
	/**
	 * 触发的位置信息
	 * @param inLocationEvent
	 * @return
	 */
	public String processInLocationEvent(InLocationEvent inLocationEvent);	
	/**
	 * 触发的点击菜单按钮消息
	 * @param inMenuEvent
	 * @return
	 */
	public String processInMenuEvent(InMenuEvent inMenuEvent);	
	/**
	 * 用户关注与注销
	 * @param inActionEvent
	 * @return
	 */
	public String processInActionEvent(InActionEvent inActionEvent);
	
}
