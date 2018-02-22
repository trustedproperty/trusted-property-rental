//查询类
function hasClass(elements, cName) {
    return !!elements.className.match(new RegExp("(\\s|^)" + cName + "(\\s|$)")); // ( \\s|^ ) 判断前面是否有空格 （\\s | $ ）判断后面是否有空格 两个感叹号为转换为布尔值 以方便做判断
};
//添加类
function addClass(elements, cName) {
    if (!hasClass(elements, cName)) {
        elements.className += " " + cName;
    };
};
//删除类
function removeClass(elements, cName) {
    if (hasClass(elements, cName)) {
        elements.className = elements.className.replace(new RegExp("(\\s|^)" + cName + "(\\s|$)"), " "); 
        // replace方法是替换 
    };
}; 
//取当前页面名称(不带后缀名)
function pageName() {
    var a = location.href;
    var b = a.split("/");
    var c = b.slice(b.length - 1, b.length).toString(String).split(".");
    return c.slice(0, 1);
}
//取当前页面名称(带后缀名)
function pageName() {
    var strUrl = location.href;
    var arrUrl = strUrl.split("/");
    var strPage = arrUrl[arrUrl.length - 1];
    return strPage;
}
//数字函数
//随机数
function intRandom(n) {
    return Math.floor(Math.random() * n + 1)
}
//http函数
//获得参数
function getPar(par) {
    //获取当前URL
    var local_url = document.location.href;
    console.log(local_url);
    //获取要取得的get参数位置
    var get = local_url.indexOf(par + "=");
    console.log(get);
    if (get == -1) {
        return "";
    }
    //截取字符串
    var get_par = local_url.slice(par.length + get + 1);
    //判断截取后的字符串是否还有其他get参数
    var nextPar = get_par.indexOf("&");
    if (nextPar == -1) {
        nextPar = get_par.length;
    }
    var nextParSharp = get_par.indexOf("#");
    if (nextParSharp == -1) {
        nextParSharp = get_par.length;
    }
    if (nextPar > nextParSharp) {
        nextPar = nextParSharp;
    }
    if (nextPar != -1) {
        get_par = get_par.slice(0, nextPar);
    }
    return get_par;
}
//获得全部参数
function getParAll() {
    //获取当前URL
    var local_url = document.location.href;
    console.log(local_url);
    //获取要取得的get参数位置
    var get = local_url.indexOf("?");
    console.log(get);
    if (get == -1) {
        return "";
    }
    //截取字符串
    var get_par = local_url.slice(get + 1);
    console.log(get_par);
    return get_par;
}
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
//原生：设置cookie
function setCookie(name, value) {
    var Days = 1; //cookie有效的天数
    var exp = new Date();
    exp.setTime(exp.getTime() + Days * 24 * 60 * 60 * 1000); //24小时*60分钟*60秒*1000毫秒
    document.cookie = name + "=" + escape(value) + ";expires=" + exp.toGMTString();
}
//原生：删除cookie
function delCookie(name) {
    var exp = new Date();
    exp.setTime(exp.getTime() - 1);
    var cval = getCookie(name);
    if (cval != null)
        document.cookie = name + "=" + cval + ";expires=" + exp.toGMTString();
    location.reload([true]);
}
//登录函数
//原生：登录by手机
function loginPhone() {
    document.getElementById("loginReturnPhone").innerHTML = "正在登录...";
    //console
    $.ajax({
        type: "get",
        url: "dreamSpace/userInfo/codeLogin.html", //请求路径
        data: $('#idLoginPhoneForm').serialize(),
        dataType: "json",
        success: function(data) {
            console.log("success data");
            console.log(data);
            if (data.userInfo.userId != undefined && data.userInfo != false) {
                console.log("setCookie");
                setCookie('userId', data.userInfo.userId);
                setCookie('userName', data.userInfo.userName);
                if (data.userInfo.userName.slice(0, 5) == 'user_') {
                    var strLocation = 'window.location.href = "/user-setting.html?userId=' + data.userInfo.userId + '";';
                    console.log("strLocation");
                    console.log(strLocation);
                    setTimeout(strLocation, 500);
                } else {
                    setTimeout('window.location.href = "/index.html";', 500);
                }
                return true;
            } else {
                setTimeout('document.getElementById("loginReturnPhone").innerHTML = "登录失败!";', 1500);
                return false;
            }
        },
        error: function(data) {
            console.log("error data");
            console.log(data);
            setTimeout('document.getElementById("loginReturnPhone").innerHTML = "登录失败!";', 1500);
        }
    });
    setTimeout('document.getElementById("loginReturnPhone").innerHTML = "登录失败!";', 1500);
}
//
//原生：登录by账号
function loginAccount() {
    document.getElementById("loginReturnAccount").innerHTML = "正在登录...";
    $.ajax({
        type: "get",
        url: "dreamSpace/userInfo/login.html", //请求路径
        data: $('#idLoginAccountForm').serialize(),
        dataType: "json",
        success: function(data) {
            console.log("success");
            console.log(data);
            if (data.userInfo.userId != undefined && data.userInfo != false) {
                console.log("setCookie");
                setCookie('userId', data.userInfo.userId);
                setCookie('userName', data.userInfo.userName);
                if (data.userInfo.userName.slice(0, 5) == "user_") {
                    var strLocation = 'window.location.href = "/user-setting.html?userId=' + data.userInfo.userId + '";';
                    console.log("strLocation");
                    console.log(strLocation);
                    setTimeout(strLocation, 1000);
                } else {
                    setTimeout('window.location.href = "/index.html";', 1000);
                }
                return true;
            } else {
                setTimeout('document.getElementById("loginReturnAccount").innerHTML = "登录失败!";', 1500);
                return false;
            }
        },
        error: function(data) {
            console.log("error data");
            console.log(data);
            setTimeout('document.getElementById("loginReturnAccount").innerHTML = "登录失败!";', 1500);
        }
    });
    setTimeout('document.getElementById("loginReturnAccount").innerHTML = "登录失败!";', 1500);
}
//
function logout() {
    delCookie("userId");
    delCookie("userName");
}
//发布需求
function insertDemand() {
    console.log("insertDemand");
    //var temp = "first";
    console.log("dreamSpace/space/insertDemand.html");
    console.log($('#idRequireForm').serialize());
    $.ajax({
        type: "post",
        url: "dreamSpace/space/insertDemand.html", //请求路径
        data: $('#idRequireForm').serialize(),
        async: false, //同步（不是异步）
        dataType: "json",
        success: function(data) {
            console.log("success");
            console.log("data");
            console.log(data);
            if (data.data == "success") {
                setTimeout('window.location.href = "/success.html?type=require";', 1000);
            }
            /* else if (data.error == "验证码不正确") {
                            console.log('return "error-inputCheck";');
                            return "error-inputCheck";
                        }*/
        },
        error: function(data) {
            console.log("error");
            return data;
            //setCookie('userId', data.userInfo.userId);
            //setCookie('userName', data.userInfo.userName);
        }
    });
}
//发布场地
function addSpace() {
    console.log("addSpace");
    //获得价格列表
    var textSpacePostForm = $('#idSpacePostForm').serialize();
    var strPriceList = "&priceList=";
    for (var i = 0; i < 7; i++) {
        var strI = i.toString();
        var id = "idDateType" + strI;
        var strAdd = document.getElementById(id).value;
        console.log(strAdd);
        if (strAdd != "") {
            strPriceList += strAdd;
            if (i < 6) strPriceList += ",";
        }
    }
    textSpacePostForm += strPriceList;
    console.log(textSpacePostForm);

    $.ajax({
        type: "post",
        url: "dreamSpace/space/addSpaceFacility.html", //请求路径
        data: textSpacePostForm,
        dataType: "json",
        success: function(data) {
            console.log("success：" + data.data);
            console.log(data);
            console.log(data.data);
            document.getElementById("inputSpaceId").value = data.data;
            return data.data; //返回参数：上传场地Id
        }
    });
}
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
    console.log($(this).serializeJson());
})(jQuery);
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
        minView: 1, //最深为小时
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
//form2json
function onClik() {
    //var data = $("#form1").serializeArray(); //自动将form表单封装成json
    console.log(JSON.stringify(data));
    var form2json = $('#form2json').serializeObject();
    console.log(JSON.stringify(form2json));
}
//ajax结束
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
    if (arr.length == 0) document.getElementById(idInput).value = "";
    $("#" + idInput).trigger('input');
}
//页眉
$(document).ready(function() {
    console.log("页眉");
    var temp = getCookie("userId");
    console.log("userId=");
    console.log(temp);
    if (temp == null) {
        $.get("includes/logout.html", function(data) {
            $(".header").html(data);
        });
    } else {
        console.log(temp);
        $.get("includes/login.html", function(data) {
            $(".header").html(data);
        });
    }
});
//函数模板
//立即执行函数
/*(function() {
    console.log("onload"); //firebug输出1234，使用（）运算符function getCookie(name)
}());*/
//
function string2array(str, sign) {
    var arr = new Array();
    console.log(str);
    console.log(sign);
    var begin = 0;
    var thisStr = "";
    for (var i = 0; i < str.length; i++) {
        if (str[i] != sign) {
            thisStr += str[i];
        } else {
            begin = i;
            if (thisStr != "") arr.push(thisStr);
            thisStr = "";
        }
    }
    if (thisStr != "") arr.push(thisStr);
    console.log("string2array return：{" + arr + "}");
    return arr;
}
//
function ajaxFormJson(ajaxUrl, ajaxType, idForm, textTail) {
    console.log(ajaxUrl);
    console.log(ajaxType);
    console.log(idForm);
    console.log(textTail);
    var textFormSerialize = $(idForm).serialize() + textTail;
    console.log(textFormSerialize);
    $.ajax({
        type: ajaxType,
        url: ajaxUrl, //请求路径
        data: textFormSerialize,
        dataType: "json",
        success: function(data) {
            console.log("success:ajaxFormJson");
            console.log(data.message);
            //setCookie('userId', data.userInfo.userId);
            //setCookie('userName', data.userInfo.userName);
            //location.reload();
        },
        error: function(data) {
            console.log("error:ajaxFormJson");
            console.log(data.message);
            //setCookie('userId', data.userInfo.userId);
            //setCookie('userName', data.userInfo.userName);
        }
    });
}
//提交
function ajaxPar(ajaxUrl, ajaxType, strPar, asyncType) {
    console.log(ajaxUrl);
    console.log(ajaxType);
    console.log(strPar);
    var returnResult;
    $.ajax({
        type: ajaxType,
        url: ajaxUrl, //请求路径
        data: strPar,
        dataType: "json",
        async: asyncType,
        success: function(data) {
            console.log("success:ajaxPar");
            console.log(data);
            returnResult = data;
        },
        error: function(data) {
            console.log("error:ajaxPar");
            console.log(data);
            returnResult = data;
        }
    });
    console.log("ajaxPar - returnResult：");
    console.log(returnResult);
    return returnResult;
}
//
function ajaxFormData(ajaxType, ajaxUrl, thisFormData, asyncType) {
    console.log("function ajaxFormData：" + ajaxType + "," + ajaxUrl + "," + thisFormData + "," + asyncType);
    var returnResult;
    $.ajax({
        type: ajaxType,
        url: ajaxUrl, //请求路径
        data: thisFormData,
        async: asyncType,
        processData: false, // 告诉jQuery不要去处理发送的数据
        contentType: false, // 告诉jQuery不要去设置Content-Type请求头
        success: function(data) {
            console.log("ajaxFormData success：");
            console.log(data);
            returnResult = data;
        },
        error: function(data) {
            console.log("ajaxFormData error：");
            console.log(data);
            returnResult = data;
        }
    });
    return returnResult;
}
/*
function publishSpace123(inputFileId, inputFileName, spaceId, type) {
    //进入函数与必备参数
    console.log("uploadPhoto");
    var arrName = "";
    //判断选中图片数量
    var fileLength = document.getElementById(inputFileId).files.length;
    if (fileLength == 0) {
        console.log("没有选中图片");
        return false;
    } else if (fileLength > 30) {
        console.log("一次上传不得超过30张图片");
        return false;
    }
    //获得图片名称列表
    var str = document.getElementById(inputFileName).value;
    console.log("album");
    var arr = new Array();
    arr = string2array(str, '\n');
    console.log("{" + arr + "}");
    //存封面图片并获得返回路径值
    var thisFormData = new FormData(); //创建新表单对象
    thisFormData.append("file", document.getElementById(inputFileId).files[0]); //插入第一个元素为file
    if (arr[0] != "") {
        thisFormData.append("newFile", arr[0]); //不为空
    } else {
        thisFormData.append("newFile", "图片"); //为空时
    }
    //上传封面图片
    ajaxFormData("post", "/dreamSpace/space/sendPhoto.html", thisFormData);
    if (type == "single") {} else if (type == "album") {
        console.log("album");
        var arr = new Array();
        arr = string2array(str, '\n');
        console.log("{" + arr + "}");
        var file;
        //遍历图片列表
        //取得FileList取得的file集合 
        for (var i = 0; i < fileLength; i++) {
            //file对象为用户选择的某一个文件 
            file = document.getElementById(inputFileId).files[i];
            //此时取出这个文件进行处理，这里只是显示文件名
            console.log(file.name);
            //准备参数
            var thisFormData = new FormData();
            //图片参数
            thisFormData.append("file", document.getElementById(inputFileId).files[i]);
            //图片标题参数
            if (arr[i] != "") {
                thisFormData.append("photoName", arr[i]);
            } else {
                thisFormData.append("photoName", "图片");
            }
            //场地ID参数
            thisFormData.append("spaceId", document.getElementById("inputSpaceId").value);
            //上传图片
            $.ajax({
                type: "post",
                url: "/dreamSpace/space/uploadPhoto.html", //请求路径
                data: thisFormData,
                processData: false, // 告诉jQuery不要去处理发送的数据
                contentType: false, // 告诉jQuery不要去设置Content-Type请求头
                success: function(data) {
                    console.log("success");
                    console.log(data);
                    console.log(data.data);
                    console.log(data.message);
                },
                error: function(data) {
                    console.log("error");
                    console.log(data);
                    console.log(data.message);
                }
            });
        }
    }
}
*/
function readAsDataURL(fileinputId, resultDivId, idInputSuccess) {
    console.log("readAsDataURL");
    //判断选中图片数量
    var fileLength = document.getElementById(fileinputId).files.length;
    if (fileLength == 0) {
        console.log("没有选中图片");
        return false;
    }

    var file;
    for (var i = 0; i < fileLength; i++) {

        //file对象为用户选择的某一个文件 
        file = document.getElementById(fileinputId).files[i];
        if (!/image\/\w+/.test(file.type)) {
            console.log("请确认图片格式！");
            return false;
        }
        var times = 0;
        var reader = new FileReader();
        //将文件以Data URL形式读入页面
        reader.readAsDataURL(file);
        reader.onload = function(e) {
            var result = document.getElementById(resultDivId);
            var strOutput = '<div style="margin-bottom: 60px;">' + (times + 1) + ' .<img src="' + this.result + '" alt="" style="height:100%;width:100%;"/>';
            strOutput += '<input class="col-sm-12" id="inputPhotoTitle' + times + '" type="text" placeholder="照片标题" /></div>';
            times++;
            result.innerHTML += strOutput;
            if (times == fileLength) { //成功输出内容
                document.getElementById(idInputSuccess).value = "100"; //成功100分
                $("#" + idInputSuccess).trigger('input');
            }
        }
    }
    return true;
}
//获得图片预览的HTML
function inputFile2HTML(fileinputId) {
    console.log("inputFile2HTML");
    var strReturnHtml = "";

    //判断选中图片数量
    var fileLength = document.getElementById(fileinputId).files.length;
    if (fileLength == 0) {
        console.log("没有选中图片");
        return false;
    } else if (fileLength > 30) {
        console.log("一次上传不得超过30张图片");
        return false;
    }

    var file;
    for (var i = 0; i < fileLength; i++) {

        //file对象为用户选择的某一个文件 
        file = document.getElementById(fileinputId).files[i];
        if (!/image\/\w+/.test(file.type)) {
            console.log("请确认图片格式！");
            return false;
        }
        var times = 0;
        var reader = new FileReader();
        //将文件以Data URL形式读入页面  
        reader.readAsDataURL(file);
        reader.onload = function(e) {
            var strFileHtml = '<div style="margin-top:15px;">' + (++times) + ' .<img src="' + this.result + '" alt="" style="height:100%;width:100%;"/></div>';
            console.log('<div style="margin-top:15px;">');
            strReturnHtml += strFileHtml;
        }
    }
    return strReturnHtml;
}
/*
$('input[name="photoMultiselect"]').bind('input propertychange', function() {
    readAsDataURL();
});*/
//鼠标悬浮事件
$(document).ready(function() {
    $("#控件id").on("mouseover mouseout", function(event) {
        console.log("鼠标悬浮");
        if (event.type == "mouseover") {
            //鼠标悬浮
            console.log("鼠标悬浮");
        } else if (event.type == "mouseout") {
            //鼠标离开
            console.log("鼠标离开");
        }
    });
});


//检查cookie
(function() {
    var thisPageName_global_js = pageName();
    if (thisPageName_global_js == "user-setting.html" || thisPageName_global_js == "account.html" || thisPageName_global_js == "reset-password.html" || thisPageName_global_js == "userPhoneUpdate.html" || thisPageName_global_js == "spaces-publish.html") {
        var cookieUserId = getCookie("userId");
        if (cookieUserId == undefined || cookieUserId == null || cookieUserId == "") {
            window.location.href = "index.html";
        }
    }
}());

//(function() { alert("1"); }());
