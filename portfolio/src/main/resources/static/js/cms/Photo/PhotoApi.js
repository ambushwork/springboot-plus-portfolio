/*访问后台的代码*/
layui.define([], function(exports) {
    var api={
            updatePhoto:function(form,callback){
                Lib.submitForm("/cms/Photo/edit.json",form,{},callback)
            },
            addPhoto:function(form,callback){
                Lib.submitForm("/cms/Photo/add.json",form,{},callback)
            },
            del:function(ids,callback){
                Common.post("/cms/Photo/delete.json",{"ids":ids},function(){
                    callback();
                })
            }
            ,
            exportExcel:function(form,callback){
                var formPara = form.serializeJson();
                Common.post("/cms/Photo/excel/export.json", formPara, function(fileId) {
                    callback(fileId);
                })
            }
		
    };
    exports('PhotoApi',api);
});