<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
    <title>读短消息</title>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/sms.css"/>

</head>
<body>
<div id="main">
    <div class="mainbox">
        <div class="title readMessage png"></div>
        <%@ include file="include.jsp" %>
        <div class="content">
            <div class="message">
                <div class="tmenu">
                    <ul class="clearfix">
                        <li>题目：${msg.title}</li>
                        <li>来自：${msg.sendUser.name}</li>
                        <li>时间:${msg.msgCreateDate}</li>
                    </ul>
                </div>
                <div class="view">
                    <p>${msg.msgcontent}</p>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
