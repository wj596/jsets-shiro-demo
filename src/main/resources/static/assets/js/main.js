layui.use([ 'form', 'element', 'layer' ], function() {
	var form = layui.form, layer = layui.layer, element = layui.element;
});

function ajaxPost(url, data, handler) {
	$.post(url, data, handler).error(function(xhr, textStatus, errorThrown) {
		if (xhr.status == 401) {
			alert(xhr.responseText)
		} else if (xhr.status == 403) {
			alert(xhr.responseText)
		} else {
			alert(xhr.responseText)
		}
	});
}

function ajaxJson(url, data, handler) {
	$.ajax({
		url : url,
		type : "POST",
		data : data,
		dataType : 'json',
		contentType : 'application/json;charset=UTF-8',
		success : handler,
		error : function(xhr, textStatus, errorThrown) {
			if (xhr.status == 401) {
				alert(xhr.responseText)
			} else if (xhr.status == 403) {
				alert(xhr.responseText)
			} else {
				alert(xhr.responseText)
			}
		}
	});
}

function formToJson(formId) {
	var json = {};
	var data = $("#" + formId).serializeArray();
	$.each(data, function() {
		json[this.name] = this.value;
	});
	return json;
}
function unrealized() {
	layer.alert('只是个演示的demo，未实现该功能。。。', {
		icon : 6,
		title : '提示'
	});
}