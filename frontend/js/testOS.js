var os = (function() {
    var UserAgent = navigator.userAgent.toLowerCase();
    return {
        isIpad: /ipad/.test(UserAgent),
        isIphone: /iphone os/.test(UserAgent),
        isAndroid: /android/.test(UserAgent),
        isWindowsCe: /windows ce/.test(UserAgent),
        isWindowsMobile: /windows mobile/.test(UserAgent),
        isWin2K: /windows nt 5.0/.test(UserAgent),
        isXP: /windows nt 5.1/.test(UserAgent),
        isVista: /windows nt 6.0/.test(UserAgent),
        isWin7: /windows nt 6.1/.test(UserAgent),
        isWin8: /windows nt 6.2/.test(UserAgent),
        isWin81: /windows nt 6.3/.test(UserAgent)
    };
}());

var browser = (function() {
    var UserAgent = navigator.userAgent.toLowerCase();
    return {
        isUc: /ucweb/.test(UserAgent), // UC浏览器
        isChrome: /chrome/.test(UserAgent), // Chrome浏览器//原来.substr(-33, 6)
        //isChrome = window.google && window.chrome;
        isFirefox: /firefox/.test(UserAgent), // 火狐浏览器
        isOpera: /opera/.test(UserAgent), // Opera浏览器
        isSafire: /safari/.test(UserAgent) && !/chrome/.test(UserAgent), // safire浏览器
        is360: /360se/.test(UserAgent), // 360浏览器
        isBaidu: /baidubrowser/.test(UserAgent), // 百度浏览器
        isSougou: /metasr/.test(UserAgent), // 搜狗浏览器
        isIE6: /msie 6.0/.test(UserAgent), // IE6
        isIE7: /msie 7.0/.test(UserAgent), // IE7
        isIE8: /msie 8.0/.test(UserAgent), // IE8
        isIE9: /msie 9.0/.test(UserAgent), // IE9
        isIE10: /msie 10.0/.test(UserAgent), // IE10
        isIE11: /msie 11.0/.test(UserAgent), // IE11
        isLB: /lbbrowser/.test(UserAgent), // 猎豹浏览器
        isWX: /micromessenger/.test(UserAgent), // 微信内置浏览器
        isQQ: /qqbrowser/.test(UserAgent) // QQ浏览器
    };
}());

(function() {
    //检测操作系统
    if (os.isIpad) {
        alert("os.isIpad");
        window.location.href = "/developing.html";
    } else if (os.isIphone) {
        alert("os.isIphone");
        window.location.href = "/developing.html";
    } else if (os.isAndroid) {
        alert("os.isAndroid");
        window.location.href = "/developing.html";
    } else if (os.isWindowsCe) {
        alert("os.isWindowsCe");
        window.location.href = "/developing.html";
    } else if (os.isWindowsMobile) {
        alert("os.isWindowsMobile");
        window.location.href = "/developing.html";
    } else if (os.isWin2K) {
        alert("os.isWin2K");
        window.location.href = "/developing.html";
    } else if (os.isXP) {
        console.log("os.isXP");
    } else if (os.isVista) {
        console.log("os.isVista");
    } else if (os.isWin7) {
        console.log("os.isWin7");
    } else if (os.isWin8) {
        console.log("os.isWin8");
    } else if (os.isWin81) {
        console.log("os.isWin81");
    } else {
        console.log("os.unknown");
        //window.location.href = "/developing.html";
    }
    //检测浏览器

    if (browser.isUc) {
        alert("browser.isUc");
        window.location.href = "/developing.html";
    } else if (browser.isFirefox) {
        alert("browser.isFirefox");
        window.location.href = "/developing.html";
    } else if (browser.isOpera) {
        console.log("browser.isOpera");
    } else if (browser.isSafire) {
        console.log("browser.isSafire");
    } else if (browser.is360) {
        console.log("browser.is360");
    } else if (browser.isBaidu) {
        console.log("browser.isBaidu");
    } else if (browser.isSougou) {
        console.log("browser.isSougou");
    } else if (browser.isIE6) {
        alert("browser.isIE6");
        window.location.href = "/developing.html";
    } else if (browser.isIE7) {
        alert("browser.isIE7");
        window.location.href = "/developing.html";
    } else if (browser.isIE8) {
        alert("browser.isIE8");
        window.location.href = "/developing.html";
    } else if (browser.isIE9) {
        //console.log("browser.isIE9");
        alert("browser.isIE9");
        window.location.href = "/developing.html";
    } else if (browser.isIE10) {
        console.log("browser.isIE10");
    } else if (browser.isIE11) {
        console.log("browser.isIE11");
    } else if (browser.isLB) {
        console.log("browser.isLB");
    } else if (browser.isWX) {
        console.log("browser.isWX");
    } else if (browser.isQQ) {
        console.log("browser.isQQ");
    } else if (browser.isChrome) {
        console.log("browser.isChrome");
    } else {
        console.log("browser.unknown");
        //window.location.href = "/developing.html";
    }
}());
