layui.define(["laypage",'layer'],
function(e) {
     var laypage = layui.laypage
      ,layer = layui.layer;
    e("adminPage", {
        page: function(a, n) {

         //完整功能
          laypage.render({
            elem: a
            ,count: n
             ,limit: 20
            ,layout: ['count', 'prev', 'page', 'next', 'limit', 'skip']
            ,jump: function(obj){
              console.log(obj)
            }
          })
        }
    })
});