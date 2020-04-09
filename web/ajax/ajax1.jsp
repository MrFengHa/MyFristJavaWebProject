<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 冯根源
  Date: 2020/4/9
  Time: 21:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<script type="text/javascript">
    //创建异步对象
    function createXMLHttpRequest() {
        try {
            return new XMLHttpRequest();
        } catch (e) {
            try {
                return new ActiveXObject("Msxm12.XMLHTTP");
            } catch (e) {
                try {
                    return new ActiveXObject("Microsoft.XMLHTTP")
                } catch (e) {
                    alert("您不是合适的浏览器")
                    throw  e;
                }
            }
        }

    }

    function btnClick() {
        //得到异步对象
        var xmlHttp = createXMLHttpRequest();
        /**打开与服务器连接
         * 指定请求的方式
         * 指定请求的url
         * 是都指定为异步请求
         */
        xmlHttp.open("GET","<c:url value='/AjaxDemoServlet'/> ",true);
        /**
         * 发送请求
         */
        xmlHttp.send(null);//get请求没有请求体，但也要给出null，不然FireFox可能会不发出
        /**
         * 给异步对象onreadystatechange时间注册监听器
         */
        xmlHttp.onreadystatechange = function () {
            //双重判断：xmlHttp的状态为4（服务器端响应结束），以及服务器响应状态结束码为200（响应成功）
            if (xmlHttp.readyState==4&&xmlHttp.status == 200){
                //获取服务器的响应结果
                var text = xmlHttp.responseText;
                //获取h1元素
                h1.innerHTML = text;
            }
        }
    }

</script>
<body>
<button id="btn" onclick="btnClick();">点击这里</button>
<h1 id="h1"></h1>
</body>
</html>
