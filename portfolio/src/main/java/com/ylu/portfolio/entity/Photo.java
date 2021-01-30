package com.ylu.portfolio.entity;

import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

import org.beetl.sql.core.annotatoin.AutoID;
import org.beetl.sql.core.annotatoin.SeqID;

import com.ibeetl.admin.core.util.ValidateConfig;

import org.beetl.sql.core.TailBean;
import java.math.*;

import com.ibeetl.admin.core.annotation.Dict;
import com.ibeetl.admin.core.entity.BaseEntity;

import org.beetl.sql.core.annotatoin.InsertIgnore;
import org.beetl.sql.core.annotatoin.Version;
import org.beetl.sql.core.annotatoin.LogicDelete;


/* 
* 文件表
* gen by Spring Boot2 Admin 2021-01-27
*/
public class Photo extends BaseEntity{

    @NotNull(message = "ID不能为空", groups =ValidateConfig.UPDATE.class)
    @SeqID(name = ORACLE_CORE_SEQ_NAME)
    @AutoID	

    private Integer id ;
	
    //文件名称

    private String name ;
	
    //路径

    private String path ;
	
    //业务ID

    private String bizId ;
	
    //上传人id

    private Integer userId ;
	
    //创建时间

    private Date createTime ;
	

    private Integer orgId ;
	

    private String bizType ;
	

    private String fileBatchId ;
	
    public Photo(){
    }

    public Integer getId(){
        return  id;
    }
    public void setId(Integer id){
        this.id = id;
    }

    /**文件名称
    *@return 
    */
    public String getName(){
        return  name;
    }
    /**文件名称
    *@param  name
    */
    public void setName(String name){
        this.name = name;
    }

    /**路径
    *@return 
    */
    public String getPath(){
        return  path;
    }
    /**路径
    *@param  path
    */
    public void setPath(String path){
        this.path = path;
    }

    /**业务ID
    *@return 
    */
    public String getBizId(){
        return  bizId;
    }
    /**业务ID
    *@param  bizId
    */
    public void setBizId(String bizId){
        this.bizId = bizId;
    }

    /**上传人id
    *@return 
    */
    public Integer getUserId(){
        return  userId;
    }
    /**上传人id
    *@param  userId
    */
    public void setUserId(Integer userId){
        this.userId = userId;
    }

    /**创建时间
    *@return 
    */
    public Date getCreateTime(){
        return  createTime;
    }
    /**创建时间
    *@param  createTime
    */
    public void setCreateTime(Date createTime){
        this.createTime = createTime;
    }

    public Integer getOrgId(){
        return  orgId;
    }
    public void setOrgId(Integer orgId){
        this.orgId = orgId;
    }

    public String getBizType(){
        return  bizType;
    }
    public void setBizType(String bizType){
        this.bizType = bizType;
    }

    public String getFileBatchId(){
        return  fileBatchId;
    }
    public void setFileBatchId(String fileBatchId){
        this.fileBatchId = fileBatchId;
    }


}
