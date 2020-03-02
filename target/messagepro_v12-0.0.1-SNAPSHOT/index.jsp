<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>短消息平台</title>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/sms.css"/>
    <style>
        .error {
            color: red;
            font-weight: bold;
            font-size: 14px;
        }
    </style>
    <script type="text/javascript" src="${pageContext.request.contextPath}/scripts/jquery.js"></script>
    <script>
        var $name, $pwd, $code, $btnLogin;
        $(function () {
            $name = $(".name");
            $pwd = $(".pwd");
            $code = $(".code");
            $btnLogin = $("#btnLogin");
            $btnLogin.click(function () {
                $.get("${pageContext.request.contextPath}/login", {
                    "name": $name.val(),
                    "pwd": $pwd.val(),
                    "code": $code.val()
                }, function (data) {
                    if (data.success != true) {
                        $("#error").removeClass().addClass("error").html(data.info);
                        imgCode.src = "${pageContext.request.contextPath}/validateCode?timestame=" + new Date().getTime();
                    } else {
                        //window.location="${pageContext.request.contextPath}/msg.do?param=showMsgs&pageNo=1&pageSize=3";//修改浏览器地址
                        window.location = "${pageContext.request.contextPath}/main.jsp";
                    }

                });
            })

        })
    </script>
    <script>
        var imgCode, refresh;
        window.onload = function (ev) {
            imgCode = document.querySelector("#imgCode");
            refresh = document.querySelector("#refresh");
            refresh.onclick = function () {
                imgCode.src = "${pageContext.request.contextPath}/validateCode?timestame=" + new Date().getTime();
                return false;
            }
        }
    </script>
</head>
<body>
<div id="loginTitle" class="png"></div>
<div id="loginForm" class="userForm png">
    <%-- <form action="${pageContext.request.contextPath}/lr" method="post">--%>
    <dl>
        <div id="error"></div>
        <dt>用户名：</dt>
        <dd>
            <input type="text" name="name" class="name"/>
        </dd>
        <dt>密 码：</dt>
        <dd>
            <input type="password" name="pwd" class="pwd"/>
        </dd>
        <dt>验证码：</dt>
        <dd>
            <input type="text" name="code" class="code"/>
        </dd>
        <dt><img src="${pageContext.request.contextPath}/validateCode" id="imgCode"><a href="#" id="refresh">换一张</a>
        </dt>
        <dd></dd>
    </dl>
    <div class="buttons">
        <input class="btn-login png" type="button" value=" " id="btnLogin"/>
        <a href="${pageContext.request.contextPath}/register.jsp"><input class="btn-reg png" type="button"
                                                                         name="register" value=" "/></a>
    </div>
    <%-- </form>--%>
</div>


</body>
</html>








