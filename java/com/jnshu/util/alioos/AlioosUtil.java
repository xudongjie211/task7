package com.jnshu.util.alioos;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;

import java.io.FileWriter;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.aliyun.oss.OSSClient;
import com.aliyun.oss.model.GetObjectRequest;
import com.aliyun.oss.model.OSSObject;

@Component
public class AlioosUtil {
	@Autowired
	private OosBean ob;
	
	//传字符串
	public void uploadString(String sub,String cont){
		// Endpoint以杭州为例，其它Region请按实际情况填写。
		String endpoint = ob.getEndpoint();
		// 阿里云主账号AccessKey拥有所有API的访问权限，风险很高。强烈建议您创建并使用RAM账号进行API访问或日常运维，请登录 https://ram.console.aliyun.com 创建RAM账号。
		String accessKeyId = ob.getAccessKeyId();
		String accessKeySecret = ob.getAccessKeySecret();
		String bucketName = ob.getBucketName();
		String objectName = sub;

		// 创建OSSClient实例。
		OSSClient ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);

		// 上传内容到指定的存储空间（bucketName）并保存为指定的文件名称（objectName）。
		//String content = cont;
		ossClient.putObject(bucketName, objectName, new ByteArrayInputStream(cont.getBytes()));

		// 关闭OSSClient。
		ossClient.shutdown();
		
	}
	//传文件
	public void uploadFile(String sub,String filename) throws Exception{
		// Endpoint以杭州为例，其它Region请按实际情况填写。
		String endpoint = ob.getEndpoint();
		// 云账号AccessKey有所有API访问权限，建议遵循阿里云安全最佳实践，创建并使用RAM子账号进行API访问或日常运维，请登录 https://ram.console.aliyun.com 创建。
		String accessKeyId = ob.getAccessKeyId();
		String accessKeySecret = ob.getAccessKeySecret();

		// 创建OSSClient实例。
		OSSClient ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);

		// 上传文件流。
		InputStream inputStream = new FileInputStream(filename);
		ossClient.putObject(ob.getBucketName(), sub, inputStream);

		// 关闭OSSClient。
		ossClient.shutdown();		
	}
	//MultipartFile表单上传文件
	public String springuploadFile(String sub,MultipartFile file) throws Exception{
		// Endpoint以杭州为例，其它Region请按实际情况填写。
		String endpoint = ob.getEndpoint();
		// 云账号AccessKey有所有API访问权限，建议遵循阿里云安全最佳实践，创建并使用RAM子账号进行API访问或日常运维，请登录 https://ram.console.aliyun.com 创建。
		String accessKeyId = ob.getAccessKeyId();
		String accessKeySecret = ob.getAccessKeySecret();

		// 创建OSSClient实例。
		OSSClient ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);	
		// 上传文件流。
		ossClient.putObject(ob.getBucketName(), sub,new ByteArrayInputStream(file.getBytes()));
		// 关闭OSSClient。
		ossClient.shutdown();
		
		Date expiration = new Date(new Date().getTime() + 3600l * 1000 * 24 * 365 * 10);
		String url = ossClient.generatePresignedUrl(ob.getBucketName(), sub, expiration).toString();
		return url;
		
	}
	
	
	
	
	
	//普通下载
	public void downloadfile( String objname,String filename){
		// Endpoint以杭州为例，其它Region请按实际情况填写。
		String endpoint = ob.getEndpoint();
		// 阿里云主账号AccessKey拥有所有API的访问权限，风险很高。强烈建议您创建并使用RAM账号进行API访问或日常运维，请登录 https://ram.console.aliyun.com 创建RAM账号。
		String accessKeyId = ob.getAccessKeyId();
		String accessKeySecret = ob.getAccessKeySecret();
		String bucketName = ob.getBucketName();
		//String objectName = "<yourObjectName>";

		// 创建OSSClient实例。
		OSSClient ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);

		// 下载OSS文件到本地文件。如果指定的本地文件存在会覆盖，不存在则新建。
		ossClient.getObject(new GetObjectRequest(bucketName, objname), new File(filename));

		// 关闭OSSClient。
		ossClient.shutdown();
		
	}
	//流式下载
	public void rateDownload(String objname,String filename) throws Exception{
		// Endpoint以杭州为例，其它Region请按实际情况填写。
		String endpoint = ob.getEndpoint();
		// 阿里云主账号AccessKey拥有所有API的访问权限，风险很高。强烈建议您创建并使用RAM账号进行API访问或日常运维，请登录 https://ram.console.aliyun.com 创建RAM账号。
		String accessKeyId = ob.getAccessKeyId();
		String accessKeySecret = ob.getAccessKeySecret();
		String bucketName = ob.getBucketName();
		String objectName = objname;

		// 创建OSSClient实例。
		OSSClient ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);

		// ossObject包含文件所在的存储空间名称、文件名称、文件元信息以及一个输入流。
		OSSObject ossObject = ossClient.getObject(bucketName, objectName);

		// 读取文件内容。
		System.out.println("Object content:");
		BufferedReader reader = new BufferedReader(new InputStreamReader(ossObject.getObjectContent()));
		//输出到文件
		FileWriter fw=new FileWriter(new File(filename));
		BufferedWriter bw = new BufferedWriter(fw);
		while (true) {
		    String line = reader.readLine();
		    if (line == null) break;

		    bw.write(line+"\n");
		    System.out.println("\n" + line);
		}
		bw.close();
		// 数据读取完成后，获取的流必须关闭，否则会造成连接泄漏，导致请求无连接可用，程序无法正常工作。
		reader.close();

		// 关闭OSSClient。
		ossClient.shutdown();	
		ossObject.close();

	}
	
	
	
}
