package com.ylu.portfolio.service;


import com.ylu.portfolio.dao.PhotoDao;
import com.ylu.portfolio.entity.Photo;



import com.ibeetl.admin.core.service.CoreBaseService;
import com.ibeetl.admin.core.util.PlatformException;
import org.beetl.sql.core.engine.PageQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;






/**
 * Photo Service
 */

@Service
@Transactional
public class PhotoService extends CoreBaseService<Photo>{

    @Autowired private PhotoDao PhotoDao;

    public PageQuery<Photo>queryByCondition(PageQuery query){
        PageQuery ret =  PhotoDao.queryByCondition(query);
        queryListAfter(ret.getList());
        return ret;
    }

    public void batchDelPhoto(List<Long> ids){
        try {
            PhotoDao.batchDelPhotoByIds(ids);
        } catch (Exception e) {
            throw new PlatformException("批量删除Photo失败", e);
        }
    }
}