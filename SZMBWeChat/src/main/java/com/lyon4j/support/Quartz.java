package com.lyon4j.support;
import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
import com.lyon4j.entity.Token;
import com.lyon4j.tools.Configure;
import com.lyon4j.tools.Network;

/**
 * �������
 * @author Administrator
 */
@Component
public class Quartz {
	
	@Resource
	Configure configure;
	
	public Quartz() {
		
	}
	
	private String appsecret;

	private String appid;
	
	public String getAppsecret() {
		return appsecret;
	}
	public void setAppsecret(String appsecret) {
		this.appsecret = appsecret;
	}
	public String getAppid() {
		return appid;
	}
	public void setAppid(String appid) {
		this.appid = appid;
	}
	/**
	 * ��ȡtoken
	 * 0 0 0/2 * * ? *
	 */
	public void execute(){	
		//���������ļ��е�token����
		String result = Network.httpsLoaderParam("https://api.weixin.qq.com/cgi-bin/token", "POST", "grant_type=client_credential&appid="+getAppid()+"&secret="+getAppsecret(), 3000, 3000);
		Token token= JSON.parseObject(result, Token.class);
		configure.setAccessToken(token.getAccess_token());
	}	
}
