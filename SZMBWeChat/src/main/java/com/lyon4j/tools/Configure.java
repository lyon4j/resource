package com.lyon4j.tools;
import javax.annotation.Resource;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
import com.lyon4j.support.Quartz;

@Component
public class Configure {
	public Logger logger = Logger.getLogger(Configure.class);
	
	private String accessToken;
	
	private String imageRealPath;
	
	private String videoRealPath;
	@Resource
	private Quartz quartz;

	public String getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	public String getImageRealPath() {
		return imageRealPath;
	}

	public void setImageRealPath(String imageRealPath) {
		this.imageRealPath = imageRealPath;
	}

	public String getVideoRealPath() {
		return videoRealPath;
	}

	public void setVideoRealPath(String videoRealPath) {
		this.videoRealPath = videoRealPath;
	}	
}
