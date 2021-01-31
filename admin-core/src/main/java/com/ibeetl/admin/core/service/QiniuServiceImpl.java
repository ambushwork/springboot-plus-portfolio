package com.ibeetl.admin.core.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.qiniu.api.auth.AuthException;
import com.qiniu.api.auth.digest.Mac;
import com.qiniu.api.config.Config;
import com.qiniu.api.io.IoApi;
import com.qiniu.api.io.PutExtra;
import com.qiniu.api.io.PutRet;
import com.qiniu.api.rs.PutPolicy;

@Service
@Transactional
public class QiniuServiceImpl implements IQiniuService, InitializingBean{
	
	private final Log log = LogFactory.getLog(this.getClass());
	
	    @Override
	    public String uploadFile(File file, String fileName) throws Exception {
	    	return uploadFile(new FileInputStream(file), fileName);
	    }

	    /**
	     * 获取上传凭证
	     * @throws JSONException 
	     * @throws AuthException 
	     */
	    public String getUploadToken() throws AuthException, JSONException {
	        Config.ACCESS_KEY = QiniuConstants.AK;
	        Config.SECRET_KEY = QiniuConstants.SK;
	        Mac mac = new Mac(Config.ACCESS_KEY, Config.SECRET_KEY);
			String bucketName = QiniuConstants.BUCKET_NAME;
			PutPolicy putPolicy = new PutPolicy(bucketName);
			String uptoken = putPolicy.token(mac);
			return uptoken;
	    }

		@Override
		public String uploadFile(InputStream inputStream, String fileName) throws Exception {
			PutExtra extra = new PutExtra();
			String key = null;
			PutRet ret = IoApi.Put(getUploadToken(), key, inputStream, extra);
			
			log.warn(ret.statusCode + ":" + ret.response);
			//{"hash":"Fsi4bh2VN4hM9PD8qox6ibbPi9aW","key":"Fsi4bh2VN4hM9PD8qox6ibbPi9aW"}
			JSONObject obj = new JSONObject(ret.response);
			String respKey = obj.getString("key");
			return respKey;
		}

		@Override
		public void afterPropertiesSet() throws Exception {
			// TODO Auto-generated method stub
			
		}

		@Override
		public String delete(String key) throws Exception {
			// TODO Auto-generated method stub
			return null;
		}

}
