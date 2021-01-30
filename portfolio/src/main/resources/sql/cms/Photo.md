queryByCondition
===


    select 
    @pageTag(){
    t.*
    @}
    from core_file t
    where 1=1  
    @//数据权限，该sql语句功能点,如果不考虑数据权限，可以删除此行  
    and #function("Photo.query")#
    @if(!isEmpty(id)){
        and  t.ID =#id#
    @}
    @if(!isEmpty(name)){
        and  t.NAME =#name#
    @}
    
    
    

batchDelPhotoByIds
===

* 批量逻辑删除

    update core_file set 1 = 1 where ID  in( #join(ids)#)
    
