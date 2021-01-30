layui.define(['table', 'CmsPhotoApi'], function(exports) {
    var CmsPhotoApi = layui.CmsPhotoApi;
    var table=layui.table;
    var view = {
        init:function(){
        },
        delBatch:function(){
            var data = Common.getMoreDataFromTable(table,"CmsPhotoTable");
            if(data==null){
                return ;
            }
            Common.openConfirm("确认要删除这些CmsPhoto?",function(){
            var ids =Common.concatBatchId(data,"id");
            CmsPhotoApi.del(ids,function(){
                Common.info("删除成功");
                    dataReload();
                })
            })
        }
    }
    exports('del',view);
	
});