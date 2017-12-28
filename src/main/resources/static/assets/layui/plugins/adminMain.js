var toggleFullScreen, $, element, form, laydate, adminCommon, adminLayer, adminPage;
layui.define(["element", "form", "laydate", "adminCommon", "adminLayer", "adminPage"],
function(a) {
    $ = layui.jquery,
    element = layui.element,
    form = layui.form,
    laydate = layui.laydate,
    adminCommon = layui.adminCommon,
    adminPage = layui.adminPage,
    adminLayer = layui.adminLayer,
   adminCommon.homePageTpl(),
    element.on("nav(navBar)",
    function(a) {
        adminCommon.initNavForTabUrlHash($(this), a)
    }),
    element.on("tab(tabMain)",
    function(a) {
        adminCommon.setHashByLayId()
    }),
    a("adminMain", {
        init: function() {
            adminCommon.initUrlHash(),
            toggleFullScreen = adminCommon.toggleFullScreen
        }
    })
});