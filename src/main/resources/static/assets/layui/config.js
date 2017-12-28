layui.config({
    base: _CTX+"/ui/layui2/plugins/",
    version: (new Date).getTime()
});

layui.use('adminMain', function(){
  var  adminMain= layui.adminMain;
  adminMain.init();
});