package com.lyon4j.controller;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.Arrays;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.alibaba.handle.InMsgHandle;
import com.alibaba.in.InMsg;
import com.lyon4j.service.MessageService;
import com.lyon4j.service.UserService;

@Controller
public class ServerAction {
	@Resource
	private UserService userServiceImpl;
	@Resource
	private MessageService messageServiceImpl;
	/**
	 * 注入验证token
	 */
	private String token;
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}

	/**
	 * 消息认证模块
	 * @param signature
	 * @param timestamp
	 * @param nonce
	 * @param echostr
	 * @return
	 */
	@RequestMapping(value="/service",method=RequestMethod.GET,produces="text/html;charset=utf-8")
	@ResponseBody
	public String process(@RequestParam("signature") String signature,@RequestParam("timestamp") String timestamp,@RequestParam("nonce") String nonce,@RequestParam("echostr") String echostr){
		if(signature!=null && timestamp!=null && nonce!=null && echostr!=null){
			String[] strArr = new String[]{token,timestamp,nonce};
			Arrays.sort(strArr);
			if(strArr!=null && strArr.length>0){
				Arrays.sort(strArr);
				StringBuffer strBuff = new StringBuffer(strArr[0] + strArr[1] + strArr[2]);
				String code = DigestUtils.sha1Hex(strBuff.toString());
				if(code.equals(signature)){
					return echostr;
				}
			}
		}
		return "success";
	}
	
	/**
	 * 接受消息处理
	 * @param content
	 * @return
	 * @throws  
	 */
	@RequestMapping(value="service",method=RequestMethod.POST,produces="applicatoin/xml;charset=utf-8")
	@ResponseBody
	public String process(HttpServletRequest request) {
		try {
			InputStream in = request.getInputStream();
			if(in!=null){
				InMsg inMsg = InMsgHandle.parse(in);
				Method method = messageServiceImpl.getClass().getMethod("process"+inMsg.getClass().getSimpleName(),inMsg.getClass());
				method.invoke(messageServiceImpl, inMsg);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@RequestMapping(value="test",method=RequestMethod.GET)
	@ResponseBody
	public String test(){
		
		return null;
	}
}
