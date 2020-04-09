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
    //在玩当加载完成后执行
    window.onload = function () {
        var btn = document.getElementById("btn");
        //给btn的click时间注册监听
        btn.onclick = function () {
            //按钮点击后执行
            //获取h1元素对应的dom对象
            var h1 = document.getElementById("h1");
            //给h1添加内容
            h1.innerHTML="Hello Js！"
        }
    }

    function createXMLHttpRequest() {
        try {
            return new XMLHttpRequest();
        }catch(e){
            try {
                return new ActiveXObject("Msxm12.XMLHTTP");
            }catch (e) {
                try {
                    return new ActiveXObject("Microsoft.XMLHTTP")
                }catch (e) {
                    alert("您不是合适的浏览器")
                    throw  e;
                }
            }
        }

    }
</script>
<body>
<button id="btn">点击这里</button>
<h1 id="h1"></h1>
</body>
</html>
