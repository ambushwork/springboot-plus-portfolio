package com.ylu.portfolio.dao;

import java.util.List;

import org.beetl.sql.core.annotatoin.SqlResource;
import org.beetl.sql.core.mapper.BaseMapper;
import org.beetl.sql.core.engine.PageQuery;

import  com.ylu.portfolio.entity.*;

/**
 * CmsPhoto Dao
 */
@SqlResource("cms.CmsPhoto")
public interface CmsPhotoDao extends BaseMapper<CmsPhoto>{
    public PageQuery<CmsPhoto> queryByCondition(PageQuery query);
    public void batchDelCmsPhotoByIds( List<Long> ids);
}