package com.ylu.portfolio.web.query;

import org.apache.commons.lang3.StringUtils;
import com.ibeetl.admin.core.annotation.Query;
import com.ibeetl.admin.core.util.Tool;
import com.ibeetl.admin.core.util.enums.CoreDictType;
import com.ibeetl.admin.core.web.query.PageParam;
import java.util.Date;
/**
 *Photo查询
 */
public class PhotoQuery extends PageParam {
    @Query(name = "id", display = true)
    private Integer id;
    @Query(name = "文件名称", display = true)
    private String name;
    public Integer getId(){
        return  id;
    }
    public void setId(Integer id ){
        this.id = id;
    }
    public String getName(){
        return  name;
    }
    public void setName(String name ){
        this.name = name;
    }
 
}
