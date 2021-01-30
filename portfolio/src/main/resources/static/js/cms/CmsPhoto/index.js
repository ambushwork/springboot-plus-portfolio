layui.define([ 'form', 'laydate', 'table' ], function(exports) {
    var form = layui.form;
    var laydate = layui.laydate;
    var table = layui.table;
    var CmsPhotoTable = null;
    var view ={
        init:function(){
            this.initTable();
            this.initSearchForm();
            this.initToolBar();
            window.dataReload = function(){
                Lib.doSearchForm($("#searchForm"),CmsPhotoTable)
            }
        },
        initTable:function(){
            CmsPhotoTable = table.render({
                elem : '#CmsPhotoTable',
                height : Lib.getTableHeight(1),
                cellMinWidth: 100,
                method : 'post',
                url : Common.ctxPath + '/cms/CmsPhoto/list.json' // 数据接口
                ,page : Lib.tablePage // 开启分页
                ,limit : 10,
                cols : [ [ // 表头
                    {
                        type : 'checkbox',
                        fixed:'left',
                    },
                {

                    field : 'id', 
                        title : 'id',
                    fixed:'left',
                        width : 60,
                },
                {

                    field : 'title', 
                        title : 'title',
                },
                {

                    field : 'content', 
                        title : 'content',
                },
                {

                    field : 'createTime', 
                        title : 'createTime',
                },
                {

                    field : 'createUserId', 
                        title : 'createUserId',
                },
                {

                    field : 'type', 
                        title : 'type',
                }

        ] ]

        });

            table.on('checkbox(CmsPhotoTable)', function(obj){
                var CmsPhoto = obj.data;
                if(obj.checked){
                    //按钮逻辑Lib.buttonEnable()
                }else{

                }
            })
        },

        initSearchForm:function(){
            Lib.initSearchForm( $("#searchForm"),CmsPhotoTable,form);
        },
        initToolBar:function(){
            toolbar = {
                add : function() { // 获取选中数据
                    var url = "/cms/CmsPhoto/add.do";
                    Common.openDlg(url,"CmsPhoto管理>新增");
                },
                edit : function() { // 获取选中数目
                    var data = Common.getOneFromTable(table,"CmsPhotoTable");
                    if(data==null){
                        return ;
                    }
                    var url = "/cms/CmsPhoto/edit.do?id="+data.id;
                    Common.openDlg(url,"CmsPhoto管理>"+data.id+">编辑");
                },
                del : function() {
                    layui.use(['del'], function(){
                        var delView = layui.del
                        delView.delBatch();
                    });
                }
            ,
                exportDocument : function() {
                    layui.use([ 'CmsPhotoApi' ], function() {
                        var CmsPhotoApi = layui.CmsPhotoApi
                        Common.openConfirm("确认要导出这些CmsPhoto数据?", function() {
                            CmsPhotoApi.exportExcel($("#searchForm"), function(fileId) {
                                Lib.download(fileId);
                            })
                        })
                    });
                },
                importDocument:function(){
                    var uploadUrl = Common.ctxPath+"/cms/CmsPhoto/excel/import.do";
                    //模板,
                    var templatePath= "/cms/CmsPhoto/CmsPhoto_upload_template.xls";
                    //公共的简单上传文件处理
                    var url = "/core/file/simpleUpload.do?uploadUrl="+uploadUrl+"&templatePath="+templatePath;
                    Common.openDlg(url, "CmsPhoto管理>上传");
                }
        };
            $('.ext-toolbar').on('click', function() {
                var type = $(this).data('type');
                toolbar[type] ? toolbar[type].call(this) : '';
            });
        }
    }
    exports('index',view);

});