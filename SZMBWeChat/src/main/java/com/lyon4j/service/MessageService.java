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
	 * �����ı���Ϣ
	 * @param inMsg
	 * @return
	 */
	public String processInTextMsg(InTextMsg inMsg);	
	/**
	 * ����λ����Ϣ
	 * @param inLocationMsg
	 * @return
	 */
	public String processInLocationMsg(InLocationMsg inLocationMsg);		
	/**
	 * ������Ƶ��Ϣ
	 * @param inVideoMsg
	 * @return
	 */
	public String processInVideoMsg(InVideoMsg inVideoMsg);		
	
	/**
	 * ����ͼƬ��Ϣ
	 * @param inImageMsg
	 * @return
	 */
	public String processInImageMsg(InImageMsg inImageMsg);
	/**
	 * ����������Ϣ
	 * @param inVoiceMsg
	 * @return
	 */
	public String processInVoiceMsg(InVoiceMsg inVoiceMsg);	
	/**
	 * ����С��Ƶ��Ϣ
	 * @param inShortVideoMsg
	 * @return
	 */
	public String processInShortVideoMsg(InShortVideoMsg inShortVideoMsg);	
	/**
	 * ������λ����Ϣ
	 * @param inLocationEvent
	 * @return
	 */
	public String processInLocationEvent(InLocationEvent inLocationEvent);	
	/**
	 * �����ĵ���˵���ť��Ϣ
	 * @param inMenuEvent
	 * @return
	 */
	public String processInMenuEvent(InMenuEvent inMenuEvent);	
	/**
	 * �û���ע��ע��
	 * @param inActionEvent
	 * @return
	 */
	public String processInActionEvent(InActionEvent inActionEvent);
	
}
