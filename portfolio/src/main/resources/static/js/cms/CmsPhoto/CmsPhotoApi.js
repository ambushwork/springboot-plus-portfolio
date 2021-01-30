/*访问后台的代码*/
layui.define([], function(exports) {
    var api={
            updateCmsPhoto:function(form,callback){
                Lib.submitForm("/cms/CmsPhoto/edit.json",form,{},callback)
            },
            addCmsPhoto:function(form,callback){
                Lib.submitForm("/cms/CmsPhoto/add.json",form,{},callback)
            },
            del:function(ids,callback){
                Common.post("/cms/CmsPhoto/delete.json",{"ids":ids},function(){
                    callback();
                })
            }
            ,
            exportExcel:function(form,callback){
                var formPara = form.serializeJson();
                Common.post("/cms/CmsPhoto/excel/export.json", formPara, function(fileId) {
                    callback(fileId);
                })
            }
		
    };
    exports('CmsPhotoApi',api);
});