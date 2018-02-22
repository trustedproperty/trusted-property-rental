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
//字符串转换数组
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
//获得网址参数
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
//获得网址参数-全部
function getParAll() {
    //获取当前URL
    var local_url = document.location.href;
    //console.log(local_url);
    //获取要取得的get参数位置
    var get = local_url.indexOf("?");
    //console.log(get);
    if (get == -1) {
        return false;
    }
    //截取字符串
    var get_par = local_url.slice(get + 1);
    //console.log(get_par);
    return get_par;
}
//
//
function isExist(item, arrayItem) {
    for (var i = 0; i < arrayItem.length; i++) {
        if (arrayItem[i] == item) return true;
    }
    return false;
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
    //console.log($(this).serializeJson());
})(jQuery);
//
//
//读取网页标题
function getPageName() {
    var strUrl = location.href;
    var arrUrl = strUrl.split("/");
    var strPage = arrUrl[arrUrl.length - 1];
    return strPage;
}
//读取cookie
function getCookie(name) {
    var arr, reg = new RegExp("(^| )" + name + "=([^;]*)(;|$)");
    var ret;
    if (arr = document.cookie.match(reg))
        return unescape(arr[2]);
    else
        return null;
}
//
//设置cookie
function setCookie(name, value) {
    var Days = 30;
    var exp = new Date();
    exp.setTime(exp.getTime() + Days * 24 * 60 * 60 * 1000);
    document.cookie = name + "=" + escape(value) + ";expires=" + exp.toGMTString();
}
//
//删除cookie
function delCookie(name) {
    var exp = new Date();
    exp.setTime(exp.getTime() - 1);
    var cval = getCookie(name);
    if (cval != null)
        document.cookie = name + "=" + cval + ";expires=" + exp.toGMTString();
    location.reload([true]);
}
//复选框转输入框
//转成字符串，逗号分隔
function Checkbox2Input(domForm, idParentParentNode, idInput) {
    var arr = new Array;
    for (var i = 0; i < domForm.length; i++) {
        if (domForm[i].type == 'checkbox' && domForm[i].parentNode.parentNode.id == idParentParentNode) {
            if (domForm[i].checked) {
                arr.length += 1;
                arr[arr.length - 1] = domForm[i].value;
            }
        }
    }
    if (arr.length > 0) document.getElementById(idInput).value = arr.join(",");
    if (arr.length == 0) document.getElementById(idInput).value = "";
}

function readAsDataURL(fileinputId, resultDivId, idInputSuccess) {
    console.log("readAsDataURL");

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
}
//页眉
/*$(document).ready(function() {
    //console.log("页眉");
    $.get("includes/navigation.html", function(data) {
        //console.log("页眉");
        $(".navigation").html(data);
        //console.log(data);
    });
});*/
//

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
    return returnResult;
}
//检测登录状态
$(document).ready(function() {
    //console.log(getCookie("managerId"));
    if (getCookie("managerId") == null && getPageName() != "index.html") {
        window.location.href = "index.html";
    }
});
//
function ajaxFormData(ajaxType, ajaxUrl, thisFormData, asyncType) {
    console.log("function ajaxFormData");
    console.log("ajaxType");
    console.log(ajaxType);
    console.log("ajaxUrl");
    console.log(ajaxUrl);
    console.log("thisFormData");
    console.log(thisFormData);
    console.log("asyncType");
    console.log(asyncType);
    var returnResult;
    $.ajax({
        type: ajaxType,
        url: ajaxUrl, //请求路径
        data: thisFormData,
        async: asyncType,
        processData: false, // 告诉jQuery不要去处理发送的数据
        contentType: false, // 告诉jQuery不要去设置Content-Type请求头
        success: function(data) {
            console.log("ajaxFormData success");
            console.log(data);
            returnResult = data;
        },
        error: function(data) {
            console.log("ajaxFormData error");
            console.log(data);
            returnResult = data;
        }
    });
    return returnResult;
}
//
//管理员登录
function loginAdmin() {
    //console.log($('#idLoginAdminForm').serialize());
    $.ajax({
        type: "get",
        url: "/dreamSpace/manager/isLogin.html", //请求路径
        data: $('#idLoginAdminForm').serialize(),
        dataType: "json",
        success: function(data) {
            console.log("success: function(data)");
            console.log(data.managerInfo.managerId);
            setCookie('managerId', data.managerInfo.managerId);
            setCookie('managerName', data.managerInfo.managerName);
            //设置权限组
            var tempManagerId = "managerName=" + data.managerInfo.managerName;
            $.ajax({
                type: "get",
                url: "/dreamSpace/manager/queryByName.html", //请求路径
                data: tempManagerId,
                dataType: "json",
                //数据加载完成后才继续执行
                success: function(data) {
                    console.log("success");
                    var tempRoleName = data.managerInfo.roleName;
                    console.log("tempRoleName");
                    console.log(tempRoleName);
                    setCookie('managerRoleName', tempRoleName);
                    //跳转主页
                    console.log(getCookie("managerId"));
                    if (data.managerInfo.managerId != null) window.location.href = "homepage.html";
                    //console.log(data.managerInfo.managerId);
                },
                error: function(data) {
                    console.log("error:ajaxFormJson");
                    //console.log(data.message);
                    //setCookie('userId', data.userInfo.userId);
                    //setCookie('userName', data.userInfo.userName);
                }
            });
        },
        error: function(data) {
            console.log("error: function(data)");
        }
    });
}
//
//管理员退出
function logoutAdmin() {
    delCookie("managerId");
    //setTimeout("location.reload();", 1000);
    window.location.href = "index.html";
}
//
function shenheSpace(spaceId) {
    var textSpacePostForm = "spaceId=" + spaceId;
    textSpacePostForm += '&visitId=' + getCookie("managerId");
    console.log(textSpacePostForm);
    $.ajax({
        type: "get",
        url: "/dreamSpace/spaceInfo/shenHeSpace.html", //请求路径
        data: textSpacePostForm,
        dataType: "json",
        success: function(data) {
            console.log("success");
            console.log(data);
            console.log(data.message);
            location.reload();
        },
        error: function(data) {}
    });
}
//
function bohuiSpace(spaceId) {
    var textSpacePostForm = "spaceId=" + spaceId;
    textSpacePostForm += '&visitId=' + getCookie("managerId");
    console.log(textSpacePostForm);
    $.ajax({
        type: "get",
        url: "/dreamSpace/spaceInfo/boHuiSpace.html", //请求路径
        data: textSpacePostForm,
        dataType: "json",
        success: function(data) {
            console.log("success");
            console.log(data.message);
            location.reload();
        },
        error: function(data) {}
    });
}
//
function updateSpaceStatus(idFormSharp) {
    var textSpacePostForm = $(idFormSharp).serialize();
    //console.log(textSpacePostForm);
    $.ajax({
        type: "get",
        url: "/dreamSpace/spaceInfo/updateStatus.html", //请求路径
        data: textSpacePostForm,
        dataType: "json",
        success: function(data) {
            //console.log("success");
            //console.log(data.message);
            //setCookie('userId', data.userInfo.userId);
            //setCookie('userName', data.userInfo.userName);
            location.reload();
        },
        error: function(data) {
            //console.log("error");
            //console.log(data.message);
            //setCookie('userId', data.userInfo.userId);
            //setCookie('userName', data.userInfo.userName);
        }
    });
}

function ajaxFormJson(ajaxType, idForm, textTail, ajaxUrl) {
    console.log("ajaxType:" + ajaxType);
    console.log("idForm:" + idForm);
    console.log("textTail:" + textTail);
    console.log("ajaxUrl:" + ajaxUrl);
    var textFormSerialize = $(idForm).serialize() + textTail;

    console.log("textFormSerialize:" + textFormSerialize);
    $.ajax({
        type: ajaxType,
        url: ajaxUrl, //请求路径
        data: textFormSerialize,
        dataType: "json",
        success: function(data) {
            console.log("success:ajaxFormJson:");
            console.log(data.message);
            return data.message;
            //setCookie('userId', data.userInfo.userId);
            //setCookie('userName', data.userInfo.userName);
        },
        error: function(data) {
            console.log("error:ajaxFormJson:");
            console.log(data.message);
            return data.message;
            //setCookie('userId', data.userInfo.userId);
            //setCookie('userName', data.userInfo.userName);
        }
    });
}
