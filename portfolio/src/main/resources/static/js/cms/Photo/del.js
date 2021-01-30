layui.define(['table', 'PhotoApi'], function(exports) {
    var PhotoApi = layui.PhotoApi;
    var table=layui.table;
    var view = {
        init:function(){
        },
        delBatch:function(){
            var data = Common.getMoreDataFromTable(table,"PhotoTable");
            if(data==null){
                return ;
            }
            Common.openConfirm("确认要删除这些Photo?",function(){
            var ids =Common.concatBatchId(data,"id");
            PhotoApi.del(ids,function(){
                Common.info("删除成功");
                    dataReload();
                })
            })
        }
    }
    exports('del',view);
	
});