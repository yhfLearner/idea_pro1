<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>海文 在线短信平台</title>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/sms.css"/>
    <script type="text/javascript" src="${pageContext.request.contextPath}/scripts/jquery.js"></script>
    <script>
        var $name, $pwd, $affirm, $email;
        var info = "";
        $(function () {
            $name = $(".name");
            $pwd = $(".pwd");
            $affirm = $(".affirm");
            $email = $(".email");
            $("#register").click(function () {
                var bool = validate();
                if (bool) {
                    //提交
                    alert("success");
                } else {
                    $("#error").html(info);
                }
            })

        })

        function validate() {
            if ($name.val() == "") {
                info = "用户名不能为空";
                return false;
            }
            if ($pwd.val() == "") {
                info = "密码不能为空";
                return false;
            }
            if ($affirm.val() == "") {
                info = "确认密码不能为空";
                return false;
            }
            if ($pwd.val() != $affirm.val()) {
                info = "两次密码不一致";
                return false;
            }
            if ($email.val() == "") {
                info = "email不能为空";
                return false;
            }
            var reg = /^\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/;
            if (reg.test($email.val()) == false) {
                info = "email格式不正确";
                return false;
            }
            return true;
        }
    </script>
</head>

<body>
<div id="regTitle" class="png"></div>
<div id="regForm" class="userForm png">

    <form action="#" method="post">
        <dl>
            <div id="error"></div>
            <dt>用 户 名：</dt>
            <dd>
                <input type="text" name="name" class="name"/>
            </dd>
            <dt>密 码：</dt>
            <dd>
                <input type="password" name="pwd" class="pwd"/>
            </dd>
            <dt>确认密码：</dt>
            <dd>
                <input type="password" name="affirm" class="affirm"/>
            </dd>
            <dt>邮 箱：</dt>
            <dd>
                <input type="text" name="email" class="email"/>
            </dd>
        </dl>
        <div class="buttons">
            <input class="btn-reg png" type="button" name="register" value=" " id="register"/><input
                class="btn-reset png" type="reset" name="reset" value=" "/>
        </div>
        <div class="goback">
            <a href="index.jsp" class="png">返回登录页</a>
        </div>
    </form>
</div>
</body>
</html>
