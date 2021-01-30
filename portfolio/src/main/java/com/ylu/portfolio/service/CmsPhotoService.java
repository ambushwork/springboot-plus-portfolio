package com.ylu.portfolio.service;


import com.ylu.portfolio.dao.CmsPhotoDao;
import com.ylu.portfolio.entity.CmsPhoto;



import com.ibeetl.admin.core.service.CoreBaseService;
import com.ibeetl.admin.core.util.PlatformException;
import org.beetl.sql.core.engine.PageQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;






/**
 * CmsPhoto Service
 */

@Service
@Transactional
public class CmsPhotoService extends CoreBaseService<CmsPhoto>{

    @Autowired private CmsPhotoDao CmsPhotoDao;

    public PageQuery<CmsPhoto>queryByCondition(PageQuery query){
        PageQuery ret =  CmsPhotoDao.queryByCondition(query);
        queryListAfter(ret.getList());
        return ret;
    }

    public void batchDelCmsPhoto(List<Long> ids){
        try {
            CmsPhotoDao.batchDelCmsPhotoByIds(ids);
        } catch (Exception e) {
            throw new PlatformException("批量删除CmsPhoto失败", e);
        }
    }
}