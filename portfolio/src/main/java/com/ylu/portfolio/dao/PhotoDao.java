package com.ylu.portfolio.dao;

import java.util.List;

import org.beetl.sql.core.annotatoin.SqlResource;
import org.beetl.sql.core.mapper.BaseMapper;
import org.beetl.sql.core.engine.PageQuery;

import  com.ylu.portfolio.entity.*;

/**
 * Photo Dao
 */
@SqlResource("cms.Photo")
public interface PhotoDao extends BaseMapper<Photo>{
    public PageQuery<Photo> queryByCondition(PageQuery query);
    public void batchDelPhotoByIds( List<Long> ids);
}