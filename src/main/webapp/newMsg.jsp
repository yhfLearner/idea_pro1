<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
    <title>海文 在线短信平台</title>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/sms.css"/>
</head>
<body>
<form action="${pageContext.request.contextPath}/msg.do/sendMsg" method="post">
    <div id="main">
        <div class="mainbox">
            <%@ include file="include.jsp" %>
            <div class="content">
                <div class="message">
                    <div class="tmenu">
                        <ul class="clearfix">
                            <li>发送给： <select name="toUser">
                                <c:forEach items="${users}" var="user">
                                    <c:choose>
                                        <c:when test="${not empty sendid and sendid==user.id}">
                                            <option value="${user.id}" selected="selected">${user.name}</option>
                                        </c:when>
                                        <c:otherwise>
                                            <option value="${user.id}">${user.name}</option>
                                        </c:otherwise>
                                    </c:choose>

                                </c:forEach>
                            </select>
                            </li>
                            <li>标题：<input type="text" name="title" id="title"/></li>
                        </ul>
                    </div>
                    <div class="view">
                        <textarea name="content" id="content"></textarea>
                        <div class="send">
                            <input type="submit" name="submit" value=" "/>
                        </div>
                    </div>

                </div>
            </div>
        </div>
    </div>
</form>
</body>
</html>
