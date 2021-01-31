package com.ibeetl.admin.core.service;

import java.io.File;
import java.io.InputStream;

import org.json.JSONException;

import com.qiniu.api.auth.AuthException;

public interface IQiniuService {

	String uploadFile(File file, String fileName) throws Exception;
	
	String uploadFile(InputStream inputStream, String fileName) throws Exception;
	 
	String delete(String key) throws Exception;
	
	String getUploadToken() throws AuthException, JSONException;

}
