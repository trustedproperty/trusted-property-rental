//基础函数
function getPar(par) {
    //获取当前URL
    var local_url = document.location.href;
    //alert(local_url);
    //获取要取得的get参数位置
    var get = local_url.indexOf(par + "=");
    //alert(get);
    if (get == -1) {
        return false;
    }
    //截取字符串
    var get_par = local_url.slice(par.length + get + 1);
    //判断截取后的字符串是否还有其他get参数
    var nextPar = get_par.indexOf("&");
    if (nextPar != -1) {
        get_par = get_par.slice(0, nextPar);
    }
    return get_par;
}
//
function getParAll() {
    //获取当前URL
    var local_url = document.location.href;
    //alert(local_url);
    //获取要取得的get参数位置
    var get = local_url.indexOf("?");
    //alert(get);
    if (get == -1) {
        return false;
    }
    //截取字符串
    var get_par = local_url.slice(get + 1);
    //alert(get_par);
    return get_par;
}
//
//
//
//cookie函数
//原生：读取cookie
function getCookie(name) {
    var arr, reg = new RegExp("(^| )" + name + "=([^;]*)(;|$)");
    var ret;
    if (arr = document.cookie.match(reg))
        return unescape(arr[2]);
    else
        return null;
}
//
//原生：设置cookie
function setCookie(name, value) {
    var Days = 30;
    var exp = new Date();
    exp.setTime(exp.getTime() + Days * 24 * 60 * 60 * 1000);
    document.cookie = name + "=" + escape(value) + ";expires=" + exp.toGMTString();
}
//
//原生：删除cookie
function delCookie(name) {
    var exp = new Date();
    exp.setTime(exp.getTime() - 1);
    var cval = getCookie(name);
    if (cval != null)
        document.cookie = name + "=" + cval + ";expires=" + exp.toGMTString();
    location.reload([true]);
}
//
//
//
//登录函数
//原生：登录by手机
function loginPhone() {
    //var temp = "first";
    //alert("login();");
    //var temp=$('#idLoginPhoneForm').serialize();
    //alert(temp);
    $.ajax({
        type: "get",
        url: "dreamSpace/homePage/login.html", //请求路径
        data: $('#idLoginPhoneForm').serialize(),
        dataType: "json",
        success: function(data) {
            //alert("success: function(data)");
            setCookie('userId', data.userInfo.userId);
            setCookie('userName', data.userInfo.userName);
        }
    });
    setTimeout("location.reload();", 1000);
}
//
//原生：登录by账号
function loginAccount() {
    $.ajax({
        type: "get",
        url: "dreamSpace/homePage/login.html", //请求路径
        data: $('#idLoginAccountForm').serialize(),
        dataType: "json",
        success: function(data) {
            //alert("success: function(data)");
            setCookie('userId', data.userInfo.userId);
            setCookie('userName', data.userInfo.userName);
        }
    });
    setTimeout("location.reload();", 1000);

}
//
function logout() {
    delCookie("userId");
}
//
//发布需求
function insertDemand() {
    $.ajax({
        type: "post",
        url: "dreamSpace/space/insertDemand.html", //请求路径
        data: $('#idRequireForm').serialize(),
        dataType: "json",
        success: function(data) {
        }
    });

}
//发布场地
function addSpace() {
    //alert("addSpace()");
    var textSpacePostForm = $('#idSpacePostForm').serialize();
    var strPriceList = "&priceList=";
    for (var i = 0; i < 7; i++) {
        var strI = i.toString();
        var id = "idDateType" + strI;
        var strAdd = document.getElementById(id).value;
        //alert(strAdd);
        if (strAdd != "") {
            strPriceList += strAdd;
            if (i < 6) strPriceList += ",";
        }
    }
    textSpacePostForm += strPriceList;
    alert(textSpacePostForm);

    $.ajax({
        type: "get",
        url: "dreamSpace/space/addSpaceFacility.html", //请求路径
        data: textSpacePostForm,
        dataType: "json",
        success: function(data) {
            alert("success");
        }
    });
}
//
//
//
//表单有序化
(function($) {
    $.fn.serializeJson = function() {
        var serializeObj = {};
        var array = this.serializeArray();
        var str = this.serialize();
        $(array).each(function() {
            if (serializeObj[this.name]) {
                if ($.isArray(serializeObj[this.name])) {
                    serializeObj[this.name].push(this.value);
                } else {
                    serializeObj[this.name] = [serializeObj[this.name], this.value];
                }
            } else {
                serializeObj[this.name] = this.value;
            }
        });
        return serializeObj;
    };
    //console.log($(this).serializeJson());
})(jQuery);
//
//
//
//时间选择器控件
$(document).ready(function() {
    $('.form_datetime').datetimepicker({
        language: 'zh-CN',
        weekStart: 1,
        todayBtn: 1,
        autoclose: 1,
        todayHighlight: 1,
        startView: 2,
        forceParse: 0,
        showMeridian: 0
    });
    $('.form_date').datetimepicker({
        language: 'zh-CN',
        weekStart: 1,
        todayBtn: 1,
        autoclose: 1,
        todayHighlight: 1,
        startView: 2,
        minView: 2,
        forceParse: 0
    });
    $('.form_time').datetimepicker({
        language: 'zh-CN',
        weekStart: 1,
        todayBtn: 1,
        autoclose: 1,
        todayHighlight: 1,
        startView: 1,
        minView: 0,
        maxView: 1,
        forceParse: 0
    });
});

//form2json
$.fn.serializeObject = function() {
    var o = {};
    var a = this.serializeArray();
    $.each(a, function() {
        if (o[this.name]) {
            if (!o[this.name].push) {
                o[this.name] = [o[this.name]];
            }
            o[this.name].push(this.value || '');
        } else {
            o[this.name] = this.value || '';
        }
    });
    return o;
};
//
//
//
//form2json
function onClik() {
    //var data = $("#form1").serializeArray(); //自动将form表单封装成json  
    //alert(JSON.stringify(data));  
    var form2json = $('#form2json').serializeObject();
    //alert(JSON.stringify(form2json));
}
//ajax结束
//
//
//
//复选框转输入框（字符串，逗号分隔）
function Checkbox2Input(domForm, idParentNode, idInput) {
    var arr = new Array;
    for (var i = 0; i < domForm.length; i++) {
        if (domForm[i].type == 'checkbox' && domForm[i].parentNode.parentNode.id == idParentNode) {
            if (domForm[i].checked) {
                arr.length += 1;
                arr[arr.length - 1] = domForm[i].value;
            }
        }
    }
    if (arr.length > 0) document.getElementById(idInput).value = arr.join(",");
}
//
//
//
//页面样式
//页眉页脚
$(document).ready(function() {
    //页眉
    var temp = getCookie("userId");
    //alert(temp);
    if (temp == null) {
        $.get("includes/loggin.html", function(data) {
            $(".header").html(data);
        });
    } else {
        //alert(temp);
        $.get("includes/logged.html", function(data) {
            $(".header").html(data);
        });
    }
});
//
//
//
//函数模板
//立即执行函数
(function() {
    //alert("onload"); //firebug输出1234，使用（）运算符function getCookie(name)
}());
