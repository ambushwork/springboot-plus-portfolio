layui.define([ 'form', 'laydate', 'table' ], function(exports) {
    var form = layui.form;
    var laydate = layui.laydate;
    var table = layui.table;
    var PhotoTable = null;
    var view ={
        init:function(){
            this.initTable();
            this.initSearchForm();
            this.initToolBar();
            window.dataReload = function(){
                Lib.doSearchForm($("#searchForm"),PhotoTable)
            }
        },
        initTable:function(){
            PhotoTable = table.render({
                elem : '#PhotoTable',
                height : Lib.getTableHeight(1),
                cellMinWidth: 100,
                method : 'post',
                url : Common.ctxPath + '/cms/Photo/list.json' // 数据接口
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

                    field : 'name', 
                        title : '文件名称',
                },
                {

                    field : 'path', 
                        title : '路径',
                },
                {

                    field : 'bizId', 
                        title : '业务ID',
                },
                {

                    field : 'userId', 
                        title : '上传人id',
                },
                {

                    field : 'createTime', 
                        title : '创建时间',
                },
                {

                    field : 'orgId', 
                        title : 'orgId',
                },
                {

                    field : 'bizType', 
                        title : 'bizType',
                },
                {

                    field : 'fileBatchId', 
                        title : 'fileBatchId',
                }

        ] ]

        });

            table.on('checkbox(PhotoTable)', function(obj){
                var Photo = obj.data;
                if(obj.checked){
                    //按钮逻辑Lib.buttonEnable()
                }else{

                }
            })
        },

        initSearchForm:function(){
            Lib.initSearchForm( $("#searchForm"),PhotoTable,form);
        },
        initToolBar:function(){
            toolbar = {
                add : function() { // 获取选中数据
                    var url = "/cms/Photo/add.do";
                    Common.openDlg(url,"Photo管理>新增");
                },
                edit : function() { // 获取选中数目
                    var data = Common.getOneFromTable(table,"PhotoTable");
                    if(data==null){
                        return ;
                    }
                    var url = "/cms/Photo/edit.do?id="+data.id;
                    Common.openDlg(url,"Photo管理>"+data.id+">编辑");
                },
                del : function() {
                    layui.use(['del'], function(){
                        var delView = layui.del
                        delView.delBatch();
                    });
                }
            ,
                exportDocument : function() {
                    layui.use([ 'PhotoApi' ], function() {
                        var PhotoApi = layui.PhotoApi
                        Common.openConfirm("确认要导出这些Photo数据?", function() {
                            PhotoApi.exportExcel($("#searchForm"), function(fileId) {
                                Lib.download(fileId);
                            })
                        })
                    });
                },
                importDocument:function(){
                    var uploadUrl = Common.ctxPath+"/cms/Photo/excel/import.do";
                    //模板,
                    var templatePath= "/cms/Photo/Photo_upload_template.xls";
                    //公共的简单上传文件处理
                    var url = "/core/file/simpleUpload.do?uploadUrl="+uploadUrl+"&templatePath="+templatePath;
                    Common.openDlg(url, "Photo管理>上传");
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