<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<div class="menu">
    <span>当前用户：<a href="${pageContext.request.contextPath}/main.jsp">${user.name}</a></span> <span><a
        href="${pageContext.request.contextPath}/user.do/queryAllUsers/${user.id}">发短消息</a></span> <span><a
        href="${pageContext.request.contextPath}/user.do/logout">退出</a></span>
</div>

<script>
    //跳转到指定的页码
    function go(pageNo, pageSize) {
        //发送给Servlet,Servlet要从数据库中查询相关的数据,并封装到PageEntity中,再转发到main.jsp来输出内容
        window.location = "${pageContext.request.contextPath}/msg.do/showMsgs/" + pageNo + "/" + pageSize;
        return false;
    }
</script>
