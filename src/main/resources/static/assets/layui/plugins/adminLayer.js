layui.define(["layer"],
function(n) {
    var a = layui.jquery,
    i = layui.layer;
    n("adminLayer", {
        openClickLayerPage: function(n, t, e, o) {
            var r = e ? e + "px": "auto",
            u = o ? o + "px": "auto";
            a("#tpl").load(n,
            function(n) {
                i.open({
                    type: 1,
                    anim: 4,
                    maxmin: !0,
                    area: [r, u],
                    title: t,
                    content: n
                })
            })
        },
        confirmInfoLayer: function(n, a) {
            i.confirm(a, {
                title: n,
                btn: ["确认", "取消"],
                btn1: function() {
                    i.msg("点击了确定")
                },
                btn2: function() {
                    i.msg("取消选择")
                }
            })
        },
        openClickLayerTabs: function(n, a, t) {
            var e = n ? n + "px": "auto",
            o = a ? a + "px": "auto";
            i.tab({
                area: [e, o],
                tab: t
            })
        },
        newOrderTips: function() {
            i.open({
                type: 1,
                anim: 2,
                skin: "layui-layer-rim",
                area: ["300px", "200px"],
                offset: "rb",
                content: '<div style="text-align:center; margin-top: 60px;"><i class="layui-icon">&#xe60b;</i> 您有新的订单</div>',
                shade: 0
            })
        }
    })
});