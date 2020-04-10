<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/4/10
  Time: 13:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript">
        function creaeteXMLHttpRequest() {
            try {
                return new XMLHttpRequest();
            } catch (e) {
                try {
                    return ActiveXObject("Msxm12.XMLHTTP");
                } catch (e) {
                    try {
                        return ActiveXObject("Microsoft.XMLHTTP");
                    } catch (e) {
                        return ("使用的浏览器版本过低！");
                        throw  e;
                    }
                }
            }
        }

        window.onload = function () {
            //获取文本框，给他的失去焦点事件注册监听
            var usernameId = document.getElementById("usernameId");
            usernameId.onblur = function () {
                var xmlHttp = creaeteXMLHttpRequest();
                //打开连接
                xmlHttp.open("POST", "${pageContext.request.contextPath}/ValidateUserNameServlet", true);
                //设置请求头
                xmlHttp.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
                //发送请求
                xmlHttp.send("username=" + usernameId.value);
                //给xmlHttp的onreadystatechange事件
                xmlHttp.onreadystatechange = function () {
                    if (xmlHttp.readyState == 4 && xmlHttp.status == 200) {
                        //获取服务器的响应判断是否为1
                        //是：获取span，天机内同”用户名已被注册"
                        var text = xmlHttp.responseText;
                        if (text == "1") {
                            //得到span 元素
                            var span = document.getElementById("errorSpan");
                            span.innerHTML = "用户名已经存在";
                        }
                    }
                }
            }
        }
    </script>
</head>
<body>
<h1>演示用户名是否被注册</h1>
<form action="" method="post">
    用户名：<input type="text" name="username" id="usernameId"/><span id="errorSpan"></span><br/>
    密码：<input type="password" name="password" id="passwordId"/><br/>
    <input type="submit" value="注册"/>
</form>
</body>
</html>
