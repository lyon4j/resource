package com.lyon4j.service.impl;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.security.SecureRandom;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.annotation.Resource;
import org.apache.commons.DictionaryUtil;
import org.springframework.stereotype.Service;
import com.alibaba.in.InImageMsg;
import com.alibaba.in.InLocationMsg;
import com.alibaba.in.InShortVideoMsg;
import com.alibaba.in.InTextMsg;
import com.alibaba.in.InVideoMsg;
import com.alibaba.in.InVoiceMsg;
import com.alibaba.in.event.InActionEvent;
import com.alibaba.in.event.InLocationEvent;
import com.alibaba.in.event.InMenuEvent;
import com.lyon4j.service.MessageService;
import com.lyon4j.tools.Configure;
import com.lyon4j.tools.Network;

@Service
public class MessageServiceImpl implements MessageService{
	@Resource
	Configure configure;
	
	public String processInTextMsg(InTextMsg inMsg) {
		String msgContent = inMsg.getContent();				//获得消息内容
		String regexNum = "^[0-9]+$";						//权重最高
		String regexEN = "(.*?)([a-zA-Z]+)(.*?)";			//2号权重
		String regexCN = "(.*?)([\u4e00-\u9fa5]+)(.*?)";	//3号权重		
		if(msgContent.matches(regexNum)){		//包含数字处理
			return queryNumTextMsg(msgContent);
		}else if(msgContent.matches(regexCN)){	//包含中文处理
			return queryCNTextMsg(msgContent);
		}else if(msgContent.matches(regexEN)){	//包含英文处理
			return null;
		}
		return null;
	}
	/**
	 * 查询中文文本消息
	 * @return
	 */
	private String queryCNTextMsg(String msgContent){
		List<String> message = DictionaryUtil.parse(msgContent);
		//根据分词处理的键查询
		for(String key : message){
			
		}
		return null;
	}
	/**
	 * 查询数字文本消息
	 * @return
	 */
	private String queryNumTextMsg(String msgContent){
		int num = Integer.parseInt(msgContent);
		//根据消息ID查询
		return null;
	}

	public String processInLocationMsg(InLocationMsg inLocationMsg) {
		System.out.println("location");
		return null;
	}

	public String processInVideoMsg(InVideoMsg inVideoMsg) {
		System.out.println("video");
		return null;
	}

	public String processInVoiceMsg(InVoiceMsg inVoiceMsg) {
		System.out.println("voice");
		//语音消息解密
		return null;
	}

	public String processInLocationEvent(InLocationEvent inLocationEvent) {
		System.out.println("location event");
		return null;
	}

	public String processInMenuEvent(InMenuEvent inMenuEvent) {
		System.out.println("menu event");
		return null;
	}

	public String processInActionEvent(InActionEvent inActionEvent) {
		System.out.println("action event");
		return null;
	}

	public String processInShortVideoMsg(InShortVideoMsg inShortVideoMsg) {
		try {
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
			String mediaId = inShortVideoMsg.getMediaId();
			byte[] data = Network.httpsGetData("https://api.weixin.qq.com/cgi-bin/media/get?access_token="+configure.getAccessToken()+"&media_id="+mediaId, "GET", null, 3000, 3000);
			//创建视频路径		
			File targetPath = new File(configure.getVideoRealPath()+File.separator+dateFormat.format(System.currentTimeMillis()));
			if(!targetPath.exists()){
				targetPath.mkdirs();
			}
			targetPath = new File(targetPath.getPath()+File.separator+Math.abs(new SecureRandom().nextLong())+".mp4");
			OutputStream out = new FileOutputStream(targetPath);
			out.write(data);
			out.flush();
			out.close();
		} catch (Exception e) {
			configure.logger.error("下载用户上传微视频数据失败."+e.getMessage());
		}
		return null;
	}
	
	public String processInImageMsg(InImageMsg inImageMsg) {
		try {
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
			String mediaId = inImageMsg.getMediaId();
			byte[] data = Network.httpsGetData("https://api.weixin.qq.com/cgi-bin/media/get?access_token="+configure.getAccessToken()+"&media_id="+mediaId, "GET", null, 3000, 3000);
			//创建图片路径		
			File targetPath = new File(configure.getImageRealPath()+File.separator+dateFormat.format(System.currentTimeMillis()));
			if(!targetPath.exists()){
				targetPath.mkdirs();
			}
			targetPath = new File(targetPath.getPath()+File.separator+Math.abs(new SecureRandom().nextLong())+".png");
			OutputStream out = new FileOutputStream(targetPath);
			out.write(data);
			out.flush();
			out.close();
		} catch (Exception e) {
			configure.logger.error("下载用户上传图片数据失败."+e.getLocalizedMessage());
		}
		return null;
	}
}
