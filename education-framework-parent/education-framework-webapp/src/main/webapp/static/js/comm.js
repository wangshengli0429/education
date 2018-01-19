//实现Ajax数据请求
var AjaxFunction = function (url,Data,SuccessFun,ErrorFun) {
    $.ajax({
        url: url,
        data: Data,
        type: 'post',
        dataType: 'json',
        error: function () { ErrorFun() },
        success: function (data) { SuccessFun(data) }
    })
};
function isDate_yyyyMMdd(str) {
    var reg = /^([0-9]{1,4})(-|\/)([0-9]{1,2})\2([0-9]{1,2})$/;
    var r = str.match(reg);
    if (r == null) return false;
    var d = new Date(r[1], r[3] - 1, r[4]);
    var newstr = d.getFullYear() + r[2] + (d.getMonth() + 1) + r[2] + d.getDate();
    var yyyy = parseInt(r[1], 10);
    var mm = parseInt(r[3], 10);
    var dd = parseInt(r[4], 10);
    var compstr = yyyy + r[2] + mm + r[2] + dd;
    return newstr == compstr;
}


function isDateTime_yyyyMMddhhmmss(str) {
    var reg = /^([0-9]{1,4})(-|\/)([0-9]{1,2})\2([0-9]{1,2}) ([0-9]{1,2}):([0-9]{1,2}):([0-9]{1,2})$/;
    var r = str.match(reg);
    if (r == null) { return false; }
    var d = new Date(r[1], r[3] - 1, r[4], r[5], r[6], r[7]);
    var newStr = d.getFullYear() + r[2] + (d.getMonth() + 1) + r[2] + d.getDate() + " " + d.getHours() + ":" + d.getMinutes() + ":" + d.getSeconds();
    var yyyy = parseInt(r[1], 10);
    var mm = parseInt(r[3], 10);
    var dd = parseInt(r[4], 10);
    var hh = parseInt(r[5], 10);
    var min = parseInt(r[6], 10);
    var ss = parseInt(r[7], 10);
    var compstr = yyyy + r[2] + mm + r[2] + dd + " " + hh + ":" + min + ":" + ss;
    alert(newStr == compstr);
    return newStr == str;
}

//格式化DataGrid中的日期格式
function FormatterDate(val, row) {
    if (val != null && val != "") {
        var date = new Date(parseFloat(val.replace("/Date(", "").replace(")/", "")));

        var strMonth = '0' + (date.getMonth() + 1);
        var strDay = '0' + date.getDate();
        var strHour = '0' + date.getHours();
        var strMinute = '0' + date.getMinutes();
        var strSecond = '0' + date.getSeconds();

        return date.getFullYear() + '-' + strMonth.substr(strMonth.length - 2)
            + '-' + strDay.substr(strDay.length - 2)
            + ' ' + strHour.substr(strHour.length - 2)
            + ':' + strMinute.substr(strMinute.length - 2)
            + ':' + strSecond.substr(strSecond.length - 2);
    }
    else return '';
}

function ConvertDate(val, row) {
    if (val != null && val != "") {
        var date = new Date(val);

        var strMonth = '0' + (date.getMonth() + 1);
        var strDay = '0' + date.getDate();
        var strHour = '0' + date.getHours();
        var strMinute = '0' + date.getMinutes();
        var strSecond = '0' + date.getSeconds();

        return date.getFullYear() + '-' + strMonth.substr(strMonth.length - 2)
            + '-' + strDay.substr(strDay.length - 2)
            + ' ' + strHour.substr(strHour.length - 2)
            + ':' + strMinute.substr(strMinute.length - 2)
            + ':' + strSecond.substr(strSecond.length - 2);
    }
    else return '';
}

//格式化DataGrid中的日期格式
function Convertyyyymmdd(val) {
    if (val != null && val != "") {
        var date = new Date(val);

        var strMonth = '0' + (date.getMonth() + 1);
        var strDay = '0' + date.getDate();

        return date.getFullYear() + '-' + strMonth.substr(strMonth.length - 2)
            + '-' + strDay.substr(strDay.length - 2);
    }
    else return '';
}

function Converthhmm(val) {
    if (val != null && val != "") {
        var date = new Date(val);

        var strHour = '0' + date.getHours();
        var strMinute = '0' + date.getMinutes();

        return strHour.substr(strHour.length - 2)
            + ':' + strMinute.substr(strMinute.length - 2);
    }
    else return '';
}

//格式化DataGrid中的日期格式
function FormatDate_yyyymmdd(val, row) {
    if (val != null && val != "") {
        var date = new Date(parseFloat(val.replace("/Date(", "").replace(")/", "")));

        var strMonth = '0' + (date.getMonth() + 1);
        var strDay = '0' + date.getDate();
        var strHour = '0' + date.getHours();
        var strMinute = '0' + date.getMinutes();
        var strSecond = '0' + date.getSeconds();

        return date.getFullYear() + '-' + strMonth.substr(strMonth.length - 2)
            + '-' + strDay.substr(strDay.length - 2);
    }
    else return '';
}
//格式化DataGrid中的日期格式
function yyyymmdd(val, row) {
    if (val != null && val != "") {
        var date = new Date(parseFloat(val.replace("/Date(", "").replace(")/", "")));

        var strMonth = '0' + (date.getMonth() + 1);
        var strDay = '0' + date.getDate();
        var strHour = '0' + date.getHours();
        var strMinute = '0' + date.getMinutes();
        var strSecond = '0' + date.getSeconds();

        return date.getFullYear() + '-' + strMonth.substr(strMonth.length - 2)
            + '-' + strDay.substr(strDay.length - 2);
    }
    else return '';
}

function hhmm(val, row) {
    if (val != null && val != "") {
        var date = new Date(parseFloat(val.replace("/Date(", "").replace(")/", "")));

        var strMonth = '0' + (date.getMonth() + 1);
        var strDay = '0' + date.getDate();
        var strHour = '0' + date.getHours();
        var strMinute = '0' + date.getMinutes();
        var strSecond = '0' + date.getSeconds();

        return strHour.substr(strHour.length - 2)
            + ':' + strMinute.substr(strMinute.length - 2);
    }
    else return '';
}

function yyyyMMddhhmm(val, row) {
    if (val != null && val != "") {
        var date = new Date(parseFloat(val.replace("/Date(", "").replace(")/", "")));

        var strMonth = '0' + (date.getMonth() + 1);
        var strDay = '0' + date.getDate();
        var strHour = '0' + date.getHours();
        var strMinute = '0' + date.getMinutes();
        var strSecond = '0' + date.getSeconds();

        return date.getFullYear() + '-' + strMonth.substr(strMonth.length - 2)
            + '-' + strDay.substr(strDay.length - 2)
            + ' ' + strHour.substr(strHour.length - 2)
            + ':' + strMinute.substr(strMinute.length - 2);
    }
    else return '';
}

function yyyymm(val, row) {
    if (val != null && val != "") {
        var date = new Date(parseFloat(val.replace("/Date(", "").replace(")/", "")));
        var strMonth = '0' + (date.getMonth() + 1);
        return date.getFullYear() + '-' + strMonth.substr(strMonth.length - 2);
    }
    else return '';
}

//格式化日期格式为2012-9-1类型
function FormatDate_yyyymd(val, row) {
    if (val != null && val != "") {
        var date = new Date(parseFloat(val.replace("/Date(", "").replace(")/", "")));

        var strMonth =date.getMonth() + 1;
        var strDay =  date.getDate();
        var strHour =  date.getHours();
        var strMinute =  date.getMinutes();
        var strSecond =  date.getSeconds();

        return date.getFullYear() + '-' + strMonth
            + '-' + strDay;
    }
    else return '';
}
//格式化日期格式为2012/9/1 11:14类型
function FormatDate_yyyymdhm(val, row) {
    if (val != null && val != "") {
        var date = new Date(parseFloat(val.replace("/Date(", "").replace(")/", "")));

        var strMonth = date.getMonth() + 1;
        var strDay = date.getDate();
        var strHour = '0' + date.getHours();
        var strMinute = '0' + date.getMinutes();
        var strSecond = '0' + date.getSeconds();

        return date.getFullYear() + '/' + strMonth
            + '/' + strDay + ' ' + strHour.substr(strHour.length - 2) + ':' + strMinute.substr(strMinute.length - 2);
    }
    else return '';
}

//格式化日期格式为2012-9-1 11:14:00类型
function formatDate_yyyymdhms(val) {
    if (val != null && val != "") {
//        var date = new Date(parseFloat(val.replace("/Date(", "").replace(")/", "")));
    	var date1 = new Date(val);
        var strMonth = date1.getMonth() + 1;
        var strDay = date1.getDate();
        var strHour = '0' + date1.getHours();
        var strMinute = '0' + date1.getMinutes();
        var strSecond = '0' + date1.getSeconds();
        return date1.getFullYear() + '-' + strMonth
            + '-' + strDay + ' ' + strHour.substr(strHour.length - 2) + ':' + strMinute.substr(strMinute.length - 2)
            + ':' + strSecond.substr(strSecond.length - 2);
    }
    else return '';
}

//格式化日期格式为2012-9-1类型
function myDate_yyyymd(val) {
    if (val != null && val != "") {
        var date = new Date(parseFloat(val.replace("/Date(", "").replace(")/", "")));

        var strMonth = date.getMonth() + 1;
        var strDay = date.getDate();
        var strHour = date.getHours();
        var strMinute = date.getMinutes();
        var strSecond = date.getSeconds();

        return date.getFullYear() + '-' + strMonth
            + '-' + strDay;
    }
    else return '';
}

function myDate_yyyymdhhssmm(val) {
    if (val != null && val != "") {
        // var date = new Date(parseFloat(val.replace("/Date(", "").replace(")/", "")));
    	var date = new Date(val);
        var strMonth = date.getMonth() + 1;
        var strDay = date.getDate();
        var strHour = date.getHours();
        var strMinute = date.getMinutes();
        var strSecond = date.getSeconds();
        return date.getFullYear() + '-' + strMonth
            + '-' + strDay + ' ' + strHour + ':' + strMinute + ':' + strSecond;
    }
    else return '';
}


function FormateRate(str) {

    var reg = /(^\d*.?\d*[0-9]+\d*$)|(^[0-9]+\d*.\d*$)/;
    var r = str.match(reg);
    if (r == null) { return false; }
    else
    {
        return true;
    }
}

function showInfo(mes) {
    $.messager.alert('提示信息', mes, 'info');
}

function formatValue(value) {
    if (value < 10) {
        return '0' + value;
    } else {
        return value.toString();
    }
}

function getMaxDayOfMonth(year, month) {
    var day = 30;
    switch (month) {
        case 1: case 3: case 5: case 7: case 8: case 10: case 12:
            day = 31;
            break;
        case 2:
            day = 28;
            if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
                day = 29;
            }
            break;
        default:
            break;
    }

    return day;
}

function getDefaultBeginDate() {
    var now = new Date();
    var year = now.getFullYear();
    var month = now.getMonth() + 1;
    var day = now.getDate();

    if (day == 1) {
        return year + '-' + formatValue(month - 1) + '-' + formatValue(day);
    } else {
        return year + '-' + formatValue(month) + '-01';
    }
}

function getDefaultEndDate() {
    var now = new Date();
    var year = now.getFullYear();
    var month = now.getMonth() + 1;
    var day = now.getDate();

    if (day == 1) {
        return year + '-' + formatValue((month - 1)) + '-' + getMaxDayOfMonth(year, month - 1);
    } else {
        return year + '-' + formatValue(month) + '-' + formatValue(day - 1);
    }
}
function getDefaultDate() {
    var now = new Date();
    var year = now.getFullYear();
    var month = now.getMonth() + 1;
    var day = now.getDate();
    return year + '-' + formatValue(month) + '-' + formatValue(day);
}
function GetDefaultDate_yyyyMM() {
    var now = new Date();
    var year = now.getFullYear();
    var month = now.getMonth() + 1;
    return year + '-' + formatValue(month);
}
function GetLastMonthBegin() {
    var now = new Date();
    if (now.getMonth() == 0) {
        return now.getFullYear() - 1 + '-12-01';
    } else {
        return now.getFullYear() + '-' + formatValue(now.getMonth()) + '-01';
    }
}

(function ($) {
    $.extend({
        formatNum: function (str, step, splitor) {
            str = str.toString();
            var cur = str.split(".");
            var float = "";
            if (cur.length > 1) {
                str = cur[0];
                float = "."+cur[1];
            }
            var len = str.length;

            if (len > step) {
                var l1 = len % step,
                        l2 = parseInt(len / step),
                        arr = [],
                          first = str.substr(0, l1);
                if (first != '') {
                    arr.push(first);
                };
                for (var i = 0; i < l2 ; i++) {
                    arr.push(str.substr(l1 + i * step, step));
                };
                str = arr.join(splitor);
            };
            return str + float;
        }
    });
})(jQuery);

function defaultFormartNumber(val, row) {
    if (val == undefined) {
        return '';
    }
    return accounting.formatNumber(val, 0, ",");
}
function defaultFormartWeight(val, row) {
    if (val == undefined) {
        return '';
    }
    return accounting.formatNumber(val, 3, ",");
}
function defaultFormartDecimal(val, row) {
    if (val == undefined) {
        return '';
    }
    return accounting.formatNumber(val, 2, ",");
}
function defaultFormartMoney(val, row, index) {
    if (val == undefined) {
        return '';
    }
    return accounting.formatMoney(val, '¥');
}
function defaultFormartRate(value, row, index) {
    if (value == undefined) {
        return '';
    }
    return (value * 100).toFixed(2) + '%';
}
function EnterReplace(val, row, index) {
    return val.replace(/char\S(13\S)/g, '\n');
}
function EnterReplaceChar(val, row, index) {
    return val.replace(/\n/g, "char(13)");
}
function CharReplaceBr(val, row, index) {
    if (val == null) {
        return " ";
     }
    return val.replace(/char\S(13\S)/g, '<br/>');
}
function ReplaceToHtml(val, row, index) {
    if (val == null) {
        return " ";
    }
    val.replace("&lt;", '<');
    val.replace("&gt;", '>');

    return val
 }
jQuery.extend({
    showTip: function (obj, txt1, txt2) {
        var a, b, c, d, e, f, g, tipTop, tipPlace, tipId, tipHtml;
        var t1, t2;
        tipPlace = 10; //弹出框偏离图片位置
        tipId = "pictip"; //弹出框ID
        a = $(obj).offset().left + 360;
        b = $(window).width();
        c = $(obj).offset().left;
        d = $(obj).width();
        e = c + d + tipPlace;
        f = b - c + tipPlace;
        e = "left:" + e + "px;";
        f = "right:" + f + "px;";
        g = a < b ? e : f;
        tipTop = $(obj).offset().top;
        tipTop = "top:" + tipTop + "px;";
        t1 = txt1; //参数不同时重复
        t2 = txt2;
        tipHtml = "<div id=\"" + tipId + "\" style=\"" + g + tipTop + "\">";
        tipHtml = tipHtml + "<p style=\"background-color: #eee;margin:0px;height:25px;\">&nbsp;&nbsp;" + t1 + "</p>";
        tipHtml = tipHtml + "<p style=\"margin-left:5px;margin-top:5px;\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + t2 + "</p>"; //参数不同时重复
        tipHtml = tipHtml + "</div>";
        $('body').append(tipHtml)
    },
    hideTip: function () {
        $("#pictip").remove()
    }
})

function getTips(title, content) {
    return '<img id="showHelp" name="showHelp" src="../../Images/tip_View.png" alt="说明" onmouseover="jQuery.showTip(this,\'' + title + '\',\'' + content + '\')" onmouseout="jQuery.hideTip()"/>';
}

function copyText(copy) {
    if (window.clipboardData) {
        window.clipboardData.setData("Text", copy);
    }
    else if (window.netscape) {
        netscape.security.PrivilegeManager.enablePrivilege('UniversalXPConnect');
        var clip = Components.classes['@mozilla.org/widget/clipboard;1'].createInstance(Components.interfaces.nsIClipboard);
        if (!clip) {
            return;
        }

        var trans = Components.classes['@mozilla.org/widget/transferable;1'].createInstance(Components.interfaces.nsITransferable);
        if (!trans) {
            return;
        }

        trans.addDataFlavor('text/unicode');
        var str = new Object();
        var len = new Object();
        var str = Components.classes["@mozilla.org/supports-string;1"].createInstance(Components.interfaces.nsISupportsString);
        var copytext = copy;
        str.data = copytext;
        trans.setTransferData("text/unicode", str, copytext.length * 2);
        var clipid = Components.interfaces.nsIClipboard;
        if (!clip) {
            return;
        }
        clip.setData(trans, null, clipid.kGlobalClipboard);
    }

    showInfo("成功复制到剪切板");
}
//遮罩层
function sAlert(str) {
    var msgw, msgh, bordercolor;
    msgw = 300;//提示窗口的宽度
    msgh = 200;//提示窗口的高度
    titleheight = 25 //提示窗口标题高度
    bordercolor = "#FF3C00";//提示窗口的边框颜色
    titlecolor = "#D2CECE";//提示窗口的标题颜色

    var sWidth, sHeight;
    //sWidth=document.body.offsetWidth; //得出当前屏幕的宽
    sWidth = document.body.clientWidth;//BODY对象宽度

    //sHeight=screen.height;//得到当前屏幕的高
    //sHeight=document.body.clientHeight;//BODY对象高度
    if (window.innerHeight && window.scrollMaxY) {
        sHeight = window.innerHeight + window.scrollMaxY;
    }
    else if (document.body.scrollHeight > document.body.offsetHeight) {
        sHeight = document.body.scrollHeight;
    }
    else {
        sHeight = document.body.offsetHeight;
    }//以上得到整个屏幕的高

    var bgObj = document.createElement("div");//创建一个div对象
    bgObj.setAttribute('id', 'bgDiv');//可以用bgObj.id="bgDiv"的方法，是为div指定属性值
    bgObj.style.position = "absolute";//把bgDiv这个div绝对定位
    bgObj.style.top = "0";//顶部为0
    bgObj.style.background = "#777";//背景颜色
    bgObj.style.filter = "progid:DXImageTransform.Microsoft.Alpha(style=3,opacity=25,finishOpacity=75)";//ie浏览器透明度设置
    bgObj.style.opacity = "0.6";//透明度(火狐浏览器中)
    bgObj.style.left = "0";//左边为0
    bgObj.style.width = sWidth + "px";//宽(上面得到的屏幕宽度)
    bgObj.style.height = sHeight + "px";//高(上面得到的屏幕高度)
    bgObj.style.zIndex = "100";//层的z轴位置
    document.body.appendChild(bgObj);

    var msgObj = document.createElement("div")//创建一个div对象
    msgObj.setAttribute("id", "msgDiv");//可以用bgObj.id="msgDiv"的方法，是为div指定属性值
    msgObj.setAttribute("align", "center");//为div的align赋值
    msgObj.style.background = "white";//背景颜色为白色
    msgObj.style.border = "1px solid " + bordercolor;//边框属性，颜色在上面已经赋值
    msgObj.style.position = "absolute";//绝对定位
    msgObj.style.left = "35%";//从左侧开始位置
    msgObj.style.top = "30%";//从上部开始位置
    msgObj.style.font = "12px/1.6em Verdana, Geneva, Arial, Helvetica, sans-serif";//字体属性

    msgObj.style.width = msgw + "px";//提示框的宽(上面定义过)
    msgObj.style.height = msgh + "px";//提示框的高(上面定义过)
    msgObj.style.textAlign = "center";//文本位置属性，居中。
    msgObj.style.lineHeight = "25px";//行间距
    msgObj.style.zIndex = "101";//层的z轴位置

    var title = document.createElement("h4");//创建一个h4对象
    title.setAttribute("id", "msgTitle");//为h4对象填加标题
    title.setAttribute("align", "right");//文字对齐方式
    title.style.margin = "0";//浮动
    title.style.padding = "3px";//浮动
    title.style.background = titlecolor;//背景颜色
    title.style.filter = "progid:DXImageTransform.Microsoft.Alpha(startX=20, startY=20, finishX=100, finishY=100,style=1,opacity=75,finishOpacity=100);";
    title.style.opacity = "0.75";//透明
    //title.style.border="1px solid " + bordercolor;//边框
    title.style.height = "25px";//高度
    title.style.font = "12px Verdana, Geneva, Arial, Helvetica, sans-serif";//字体属性
    title.style.color = "white";//文字颜色
    title.style.cursor = "pointer";//鼠标样式
    title.innerHTML = "<a href=\"#\">关闭</a>";//显示的文字
    title.onclick = function () {
        document.body.removeChild(bgObj);//移除遮罩层
        document.getElementById("msgDiv").removeChild(title);//在提示框中移除标题
        document.body.removeChild(msgObj);//移除提示框
    }
    document.body.appendChild(msgObj);//在body中画出提示框层
    document.getElementById("msgDiv").appendChild(title);//在提示框中增加标题
    var txt = document.createElement("p");
    txt.style.margin = "1em 0";//文本浮动
    txt.setAttribute("id", "msgTxt");//为p属性增加id属性
    txt.innerHTML = str;//把传进来的值赋给p属性
    document.getElementById("msgDiv").appendChild(txt);//把p属性增加到提示框里
}
function closeCoverDiv() {
    document.body.removeChild(document.getElementById("bgDiv"));//移除遮罩层
    document.getElementById("msgDiv").removeChild(document.getElementById("msgTitle"));//在提示框中移除标题
    document.body.removeChild(document.getElementById("msgDiv"));//移除提示框
}

//将对象中jQuery EasyUI日期属性（如/Date(631123200000)/）格式化为yyyy-MM-dd形式
function objDateFormat(obj) {
    for (var p in obj) {
        if (typeof (obj[p]) == "string") {
            if (obj[p].indexOf("/Date(") != -1) {
                obj[p] = yyyymmdd(obj[p]);
            }
        }
    }
}
//escape解码格式化
function unescapeFormart(val, row, index) {
    if (val != "undefined") {
        return unescape(val);
    }
}

function FormatSex(val, row, index) {
    if (val != "undefined") {
        return val == "0" ? "女" : val == "1" ? "男" : "－";
    }
}
function FormatMarital(val, row, index) {
    if (val != "undefined") {
        return val == "0" ? "未婚" : val == "1" ? "已婚" : "－";
    }
}

function getURLVar(paras) {
    var url = location.href;
    var paraString = url.substring(url.indexOf("?") + 1, url.length).split("&");
    var paraObj = {}
    for (i = 0; j = paraString[i]; i++) {
        paraObj[j.substring(0, j.indexOf("=")).toLowerCase()] = j.substring(j.indexOf("=") + 1, j.length);
    }
    var returnValue = paraObj[paras.toLowerCase()];
    if (typeof (returnValue) == "undefined") {
        return "";
    } else {
        return returnValue;
    }
}

function openTab(plugin, title) {
    //if ($('#tt').tabs('exists', title)) {
    //    $('#tt').tabs('select', title);
    //} else {
	alert(222222);
    if (title == '首页') {
        window.parent.$('#tabs').tabs('select', '首页');
        return;
    }
    var content = '<iframe scrolling="auto" frameborder="0"  src="'
                            + plugin + '" style="width:100%;height:99.2%;"></iframe>';
    window.parent.$('#tabs').tabs('add', {
        title: title,
        content: content,
        closable: true,
        iconCls: 'icon-page'
    });
    //}
}

function closeTab() {
    var dv = window.parent.$('#tt');
    var title = dv.tabs('getSelected').panel('options').tab.text();
    dv.tabs('close', title);
}

//关闭当前页
function closeCurrent() {
    var pp = window.parent.$('#tt').tabs('getSelected');
    var current = pp.panel('options').tab.text();
    window.parent.$("#tt").tabs("close", current);
}
//关闭指的Title页面
function closeTitle(title) {
    window.parent.$("#tt").tabs("close", title);
}
//附件显示格式化
function AttachFormart(val, row, index) {
    if (val != "undefined") {
        var str = "";
        $(val).each(function (index, data) {
            var fileUrl = data.ATTACH_PATH;
            var oldFileName="";
            var newFileName="";
            if (data.ATTACH_PATH.indexOf('/') >= 0) {
                newFileName = data.ATTACH_PATH.substr(data.ATTACH_PATH.lastIndexOf('/') + 1, data.ATTACH_PATH.length - 1);
                if (newFileName.indexOf('$') >= 0) {
                    oldFileName = newFileName.split('$')[1];
                }
                else {
                    oldFileName = newFileName
                }
            }
            str += "<a href='" + Files.Url + data.ATTACH_PATH + "' target='_blank' style='display:block;'>" + oldFileName + "</a>"
        })
        return str;
    }
}
//多个表格一起提交
function GetFormDataMost(TableName) {
    var arrAy = TableName.split(",");
    var TableData = "[{";
    for (var num = 0; num < arrAy.length; num++) {
        var Table = document.getElementById(arrAy[num]);
        if (Table != undefined && Table.rows.length > 0) {
            for (var i = 0; i < Table.rows.length; i++) {
                if (i == 0) {
                    TableData += GetRowData(Table.rows[i], i);
                }
                else {
                    TableData += GetRowData(Table.rows[i], i);
                }
            }
        }
        TableData += ","
    }
    TableData = (TableData.substr(0, TableData.length - 1)) + "}]";
    return TableData;
}

function GetFormData(TableName) {
    var TableData = "[{";
    var Table = document.getElementById(TableName);
    if (Table != undefined && Table.rows.length > 0) {
        for (var i = 0; i < Table.rows.length; i++) {
            if (i == 0) {
                TableData += GetRowData(Table.rows[i], i);
            }
            else {
                TableData += GetRowData(Table.rows[i], i);
            }
        }
    }
    TableData += "}]";
    return TableData;
}

function GetRowData(Row, num) {
    var RowData = "";
    for (var i = 0; i < Row.cells.length; i++) {
        if (i % 2 == 1) {
            var obj = Row.cells[i];
            var $obj = $(obj).children();
            if (num == 0 && RowData == "") {
                if ($obj.attr("ET") == null) {
                    RowData += "\"" + $obj.attr("id") + "\":\"" + $obj.val() + "\"";
                } else {
                    if ($obj.attr("ET") == "ComboBox") {
                        RowData += "\"" + $obj.attr("id") + "\":\"" + $obj.combobox('getValue') + "\"";
                    }
                }
            }
            else {
                if ($obj.attr("ET") == null) {
                    RowData += ",\"" + $obj.attr("id") + "\":\"" + $obj.val() + "\"";
                } else {
                    if ($obj.attr("ET") == "ComboBox") {
                        RowData += ",\"" + $obj.attr("id") + "\":\"" + $obj.combobox('getValue') + "\"";
                    }
                }
            }
        }
    }
    return RowData;
}
function resetContent(formId) {
    var clearForm = document.getElementById(formId);
    if (null != clearForm && typeof (clearForm) != "undefined") {
        clearForm.reset();
    }
}

//将序列化成json格式后日期(毫秒数)转成日期格式
function ChangeDateFormat(cellval, type) {
    if (cellval != null) {
        var date = date;
        if (cellval.indexOf("/Date(") == -1)
            date = new Date(cellval);
        else
            date = new Date(parseInt(cellval.replace("/Date(", "").replace(")/", ""), 10));
        var monthDate = date.getMonth() + 1 < 10 ? "0" + (date.getMonth() + 1) : date.getMonth() + 1;
        var dayDate = date.getDate() < 10 ? "0" + date.getDate() : date.getDate();

        var hoursDate = date.getHours() < 10 ? "0" + date.getHours() : date.getHours();
        var mnuteDate = date.getMinutes() < 10 ? "0" + date.getMinutes() : date.getMinutes();
        var secondsDate = date.getSeconds() < 10 ? "0" + date.getSeconds() : date.getSeconds();

        var strDate = "";
        switch (type) {
            case "yyyy-MM-dd": strDate = date.getFullYear() + "-" + monthDate + "-" + dayDate;
                break;
            case "yyyy-MM-dd HH:mm": strDate = date.getFullYear() + "-" + monthDate + "-" + dayDate + " " + hoursDate + ":" + mnuteDate;
                break;
            case "yyyy-MM": strDate = date.getFullYear() + "-" + monthDate;
                break;
            case "MM-dd": strDate = monthDate + "." + dayDate;
                break;
            case "HH:mm:ss": strDate = hoursDate + ":" + mnuteDate + ":" + secondsDate;
                break;
            case "HH:mm": strDate = hoursDate + ":" + mnuteDate;
                break;
            case "yyyy/MM/dd HH:mm": strDate = date.getFullYear() + "/" + monthDate + "/" + dayDate + " " + hoursDate + ":" + mnuteDate;
                break;
            case "yyyyMMddHHmm": strDate = date.getFullYear() + "-" + monthDate + "-" + dayDate + " " + hoursDate + ":" + mnuteDate;
                break;
            default: strDate = date.getFullYear() + "-" + monthDate + "-" + dayDate + " " + hoursDate + ":" + mnuteDate + ":" + secondsDate;
        }
        return strDate;
    }
}

function DateFormat(varDate, type) {
    var DateTime = new Date(varDate);
    var year = DateTime.getFullYear();  
   // alert(year);//年
    var month = DateTime.getMonth() + 1;     //月
    var day = DateTime.getDate();            //日
    var hh = DateTime.getHours();            //时
    var mm = DateTime.getMinutes();          //分
    var ss = DateTime.getSeconds();
    if (month < 10) month = "0" + month;
    if (day < 10) day = "0" + day;
    if (hh < 10) hh = "0" + hh;
    if (mm < 10) mm = "0" + mm;
    if (ss < 10) ss = "0" + ss;
    var strDate = "";
    switch (type) {
        case "yyyy-MM-dd": strDate = year + "-" + month + "-" + day;
            break;
        case "yyyy-MM": strDate = year + "-" + month;
            break;
        case "MM-dd": strDate = monthDate + "." + dayDate;
            break;
        case "HH:mm:ss": strDate = hh + ":" + mm + ":" + ss;
            break;
        case "HH:mm": strDate = hh + ":" + mm;
            break;
        case "yyyyMMddHHmm": strDate = year + "-" + month + "-" + day + " " + hh + ":" + mm;
            break;
        default: strDate = year + "-" + month + "-" + day + " " + hh + ":" + mm + ":" + ss;
    }
    return strDate;
}

//DataGrid可编辑行扩展控件
/*$.extend($.fn.datagrid.defaults.editors, {
    datetimebox_97: {
        init: function (container, options) {
            var editor = $('<input class="Wdate" onclick="WdatePicker({dateFmt:\'yyyy-MM-dd HH:mm\',readOnly:true});"  />').appendTo(container);
            return editor;
        },
        getValue: function (target) {
            return $(target).val();
        },
        setValue: function (target, value) {
            $(target).val(ChangeDateFormat(value, "yyyyMMddHHmm"));
        },
        resize: function (target, width) {
            var input = $(target);
            if ($.boxModel == true) {
                input.width(width - (input.outerWidth() - input.width()) - 10);
            } else {
                input.width(width - 10);
            }
        }
    }, datetimebox_98: {
        init: function (container, options) {
            var editor = $('<input class="Wdate" onclick="WdatePicker({dateFmt:\'yyyy-MM-dd\',readOnly:false});"  />').appendTo(container);
            return editor;
        },
        getValue: function (target) {
            return $(target).val();
        },
        setValue: function (target, value) {
            $(target).val(ChangeDateFormat(value, "yyyy-MM-dd"));
        },
        resize: function (target, width) {
            var input = $(target);
            if ($.boxModel == true) {
                input.width(width - (input.outerWidth() - input.width()) - 10);
            } else {
                input.width(width - 10);
            }
        }
    }, datetimebox_99: {
        init: function (container, options) {
            var editor = $('<input class="input-small-gray" onclick="WdatePicker({dateFmt:\'HH:mm\',readOnly:false});"  />').appendTo(container);
            return editor;
        },
        getValue: function (target) {
            return $(target).val();
        },
        setValue: function (target, value) {
            $(target).val(ChangeDateFormat(value, "HH:mm"));
        },
        resize: function (target, width) {
            var input = $(target);
            if ($.boxModel == true) {
                input.width(width - (input.outerWidth() - input.width()) - 10);
            } else {
                input.width(width - 10);
            }
        }
    }
});*/

//函数说明：合并指定表格（表格id为_w_table_id）指定列（列数为_w_table_colnum）的相同文本的相邻单元格  
//参数说明：_w_table_id 为需要进行合并单元格的表格的id。如在HTMl中指定表格 id="data" ，此参数应为 #data   
//参数说明：_w_table_colnum 为需要合并单元格的所在列。为数字，从最左边第一列为1开始算起。  
function _w_table_rowspan(_w_table_id, _w_table_colnum) {
    _w_table_firsttd = "";
    _w_table_currenttd = "";
    _w_table_SpanNum = 0;
    _w_table_Obj = $(_w_table_id + " tr td:nth-child(" + _w_table_colnum + ")");
    _w_table_Obj.each(function (i) {
        if (i == 0) {
            _w_table_firsttd = $(this);
            _w_table_SpanNum = 1;
        } else {
            _w_table_currenttd = $(this);
            if (_w_table_firsttd.text() == _w_table_currenttd.text()) {
                _w_table_SpanNum++;
                _w_table_currenttd.hide(); //remove();  
                _w_table_firsttd.attr("rowSpan", _w_table_SpanNum);
            } else {
                _w_table_firsttd = $(this);
                _w_table_SpanNum = 1;
            }
        }
    });
}
//函数说明：合并指定表格（表格id为_w_table_id）指定行（行数为_w_table_rownum）的相同文本的相邻单元格  
//参数说明：_w_table_id 为需要进行合并单元格的表格id。如在HTMl中指定表格 id="data" ，此参数应为 #data   
//参数说明：_w_table_rownum 为需要合并单元格的所在行。其参数形式请参考jQuery中nth-child的参数。  
//          如果为数字，则从最左边第一行为1开始算起。  
//          "even" 表示偶数行  
//          "odd" 表示奇数行  
//          "3n+1" 表示的行数为1、4、7、10.......  
//参数说明：_w_table_maxcolnum 为指定行中单元格对应的最大列数，列数大于这个数值的单元格将不进行比较合并。  
//          此参数可以为空，为空则指定行的所有单元格要进行比较合并。  
function _w_table_colspan(_w_table_id, _w_table_rownum, _w_table_maxcolnum) {
    if (_w_table_maxcolnum == void 0) { _w_table_maxcolnum = 0; }
    _w_table_firsttd = "";
    _w_table_currenttd = "";
    _w_table_SpanNum = 0;
    $(_w_table_id + " tr:nth-child(" + _w_table_rownum + ")").each(function (i) {
        _w_table_Obj = $(this).children();
        _w_table_Obj.each(function (i) {
            if (i == 0) {
                _w_table_firsttd = $(this);
                _w_table_SpanNum = 1;
            } else if ((_w_table_maxcolnum > 0) && (i > _w_table_maxcolnum)) {
                return "";
            } else {
                _w_table_currenttd = $(this);
                if (_w_table_firsttd.text() == _w_table_currenttd.text()) {
                    _w_table_SpanNum++;
                    _w_table_currenttd.hide(); //remove();  
                    _w_table_firsttd.attr("colSpan", _w_table_SpanNum);
                } else {
                    _w_table_firsttd = $(this);
                    _w_table_SpanNum = 1;
                }
            }
        });
    });
}
//函数说明：EasyUI表格合并指定表格（表格id为_w_table_id）指定行（行数为_w_table_rownum）的相同文本的相邻单元格
function mergeCellsByField(tableId, colList) {
    var colArray = colList.split(",");
    var tTable = $("#" + tableId);
    var tableRowCnts = tTable.datagrid("getRows").length;
    var tmpA;
    var tmpB;
    var perTxt = "";
    var curTxt = "";
    for (var j = colArray.length - 1; j >= 0; j--) {
        perTxt = "";
        tmpA = 1;
        tmpB = 0;

        for (var i = 0; i <= tableRowCnts; i++) {
            if (i == tableRowCnts) {
                curTxt = "";
            }
            else {
                curTxt = tTable.datagrid("getRows")[i][colArray[j]];
            }
            if (perTxt == curTxt) {
                tmpA += 1;
            }
            else {
                tmpB += tmpA;

                tTable.datagrid("mergeCells", {
                    index: i - tmpA,
                    field: colArray[j],//合并字段
                    rowspan: tmpA,
                    colspan: null
                });
                tTable.datagrid("mergeCells", { //根据ColArray[j]进行合并
                    index: i - tmpA,
                    field: "Ideparture",
                    rowspan: tmpA,
                    colspan: null
                });

                tmpA = 1;
            }
            perTxt = curTxt;
        }
    }
}

///全角空格为12288，半角空格为32
    ///其他字符半角(33-126)与全角(65281-65374)的对应关系是：均相差65248
    //半角转换为全角函数
    function ToFull(obj) {
        var txtstring = obj.value;
        var tmp = "";
        for (var i = 0; i < txtstring.length; i++) {
            if (txtstring.charCodeAt(i) == 32) {
                tmp = tmp + String.fromCharCode(12288);
            }
            else if (txtstring.charCodeAt(i) < 127) {
                tmp = tmp + String.fromCharCode(txtstring.charCodeAt(i) + 65248);
            }
            else
                tmp = tmp + String.fromCharCode(txtstring.charCodeAt(i));
        }
        obj.value = tmp;
    }
    //全角转换为半角函数
    function ToHalf(obj) {
        var str = obj.value;
        var tmp = "";
        for (var i = 0; i < str.length; i++) {
            if (str.charCodeAt(i) > 65280 && str.charCodeAt(i) < 65375) {
                tmp += String.fromCharCode(str.charCodeAt(i) - 65248);
            }
            else if (str.charCodeAt(i) == 12288) {
                tmp += String.fromCharCode(32);
            }
            else {
                tmp += String.fromCharCode(str.charCodeAt(i));
            }
        }
        obj.value = tmp;
    }
    
  