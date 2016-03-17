package com.lyon4j.tools;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.ByteBuffer;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

public class Network {
	
	private Network(){
		
	}
	
	/**
	 * 测试获取上传视频
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		byte[] by = Network.httpsGetData("https://api.weixin.qq.com/cgi-bin/media/get?access_token=1i1oa1gXZXNll-KKvKROfEx7bez_h3-oFC9VYSl_kNskRYx1MXLLsa8YeBApPA_IfQ7kbKI73jGlpuJpOgnm82s9j9XDXcVGNolCD4mqIew&media_id=EkZBBSO2m6wYukprOf20x6IrJjEejUhmqXe-dJj4dSSd0ELaNlvjBWlT-oXlnHs_", "GET", null, 3000, 3000);
		SecureRandom random = new SecureRandom();
		long next = Math.abs(random.nextLong());
		FileOutputStream out = new FileOutputStream(new File("F://"+next+".mp4"));
		out.write(by);
		out.flush();
		out.close();
	}
		
	public static byte[] httpsGetData(String reqUrl,String method,String param,int connectTimeOut,int readTimeOut){		
		try {
			URL url = new URL(reqUrl);
			HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();
			conn.setSSLSocketFactory(getSSLScoketFacotry());
			conn.setRequestMethod(method);
			conn.setDoInput(true);
			conn.setDoOutput(true);
			conn.setReadTimeout(readTimeOut);
			conn.setConnectTimeout(connectTimeOut);
			conn.connect();
			if(param!=null){
				OutputStream out = conn.getOutputStream();
				out.write(param.getBytes());
				out.flush();
				out.close();
			}
			int size = conn.getContentLength();
			byte[] data = new byte[size];
			ByteBuffer byteBuffer = ByteBuffer.allocate(size);
			byte[] tmp = new byte[1024];
			InputStream in = conn.getInputStream();
			while((size = in.read(tmp))!=-1){
				byteBuffer.put(tmp, 0, size);
			}
			in.close();
			conn.disconnect();
			data = byteBuffer.array();
			return data;
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static byte[] httpGetData(String reqUrl,String method,String param,int connectTimeOut,int readTimeOut){
		
		return null;
	}
	
	/**
	 * https 请求
	 * @param reqUrl
	 * @param method
	 * @param param
	 * @param connectTimeOut ms
	 * @param readTimeOut ms
	 * @return
	 */
	public static String httpsLoaderParam(String reqUrl,String method,String param,int connectTimeOut,int readTimeOut){
		try {
			URL url = new URL(reqUrl);
			HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();
			conn.setSSLSocketFactory(getSSLScoketFacotry());
			conn.setRequestMethod(method);
			conn.setDoInput(true);
			conn.setDoOutput(true);
			conn.setReadTimeout(readTimeOut);
			conn.setConnectTimeout(connectTimeOut);
			conn.connect();
			if(param!=null){
				OutputStream out = conn.getOutputStream();
				out.write(param.getBytes());
				out.flush();
				out.close();
			}			
			BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			String tmp = null;
			while((tmp = reader.readLine())!=null){
				System.out.println(tmp);
			}
			reader.close();
			conn.disconnect();
		} catch(Exception e){
			
		}	
		return null;
	}
	
	
	public static String httpLoaderParam(String reqUrl,String method,String param,int connectTimeOut,int readTimeOut){
		try {
			URL url = new URL(reqUrl);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setDoInput(true);
			conn.setDoOutput(true);
			conn.setRequestMethod(method);
			conn.setReadTimeout(readTimeOut);
			conn.setConnectTimeout(connectTimeOut);
			conn.connect();
			if(param!=null){
				OutputStream out = conn.getOutputStream();
				out.write(param.getBytes());
				out.flush();
				out.close();
			}
			BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			String tmp = null;
			while((tmp = reader.readLine())!=null){
				System.out.println(tmp);
			}
			reader.close();
			conn.disconnect();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}	
		return null;
	}
	
	private static SSLSocketFactory getSSLScoketFacotry(){
		TrustManager[] truest = {new X509TrustManager() {			
			public X509Certificate[] getAcceptedIssuers() {
				return null;
			}			
			public void checkServerTrusted(X509Certificate[] chain, String authType)
					throws CertificateException {		
			}			
			public void checkClientTrusted(X509Certificate[] chain, String authType)
					throws CertificateException {				
			}
		}};
		try {			
			SSLContext sslContext = SSLContext.getInstance("TLSv1", "SunJSSE");
			sslContext.init(null, truest, new SecureRandom());
			SSLSocketFactory sf = sslContext.getSocketFactory();
			return sf;
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (NoSuchProviderException e) {
			e.printStackTrace();
		} catch (KeyManagementException e) {
			e.printStackTrace();
		}
		return null;
	}	
}
