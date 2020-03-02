<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
    <title>海文在线短信平台</title>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/sms.css"/>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/alertify.css"/>
    <script type="text/javascript" src="${pageContext.request.contextPath}/scripts/jquery.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/scripts/alertify.js"></script>
    <script>
        $(function () {
            showMsgs(1, 3);//当页面加载完毕好以后显示第一页的数据

        });

        //查询当前短消息
        function showMsgById(id) {
            window.location = "${pageContext.request.contextPath}/msg.do/queryMsgById/" + id;
        }

        //分页查询短信
        function showMsgs(pageNo, pageSize) {
            $.get("${pageContext.request.contextPath}/msg.do/showMsgs/" + pageNo + "/" + pageSize,


                function (data) {
                    // alert(JSON.stringify(data));//把json对象转换成字符串
                    //局部刷新,进行页面的拼接
                    var $ul = $(".messageList>ul");
                    $ul.empty();//清空其子元素
                    for (var i = 0; i < data.list.length; i++) {
                        var msg = data.list[i];
                        var $li = "";
                        if (msg.state == 1) {
                            $li = $("<li class='unReaded'></li>");//创建li元素
                        } else {
                            $li = $("<li></li>");
                        }
                        var $em1 = $("<em>" + msg.msgCreateDate + "</em>");
                        var $em2 = $("<em><a href='#'>回信</a></em>");
                        var $em3 = $("<em><a href='#' class='del' id='" + msg.id + "'>删除</a></em>");
                        var $p = $("<p></p>");//创建一个p标签
                        var $strong = $("<strong>" + msg.title + "</strong>");
                        var $a = "";
                        if (msg.msgcontent.length > 8) {
                            $a = $("<a href=" + "javascript:showMsgById('" + msg.id + "')>" + msg.msgcontent.substring(0, 8) + "......</a>");
                        } else {
                            $a = $("<a href=" + "javascript:showMsgById('" + msg.id + "')>" + msg.msgcontent + "</a>");
                        }
                        $p.append($strong);
                        $p.append($a);
                        $li.append($em1);
                        $li.append($em2);
                        $li.append($em3);
                        $li.append($p);
                        $ul.append($li);
                        /*---------------------------------------------------------------------*/
                    }


                    $a = $("#btn>a");
                    $a.eq(0).attr("href", "javascript:showMsgs('" + 1 + "','" + pageSize + "')");// showMsgs('1','5')
                    $a.eq(1).attr("href", "javascript:showMsgs('" + data.prePage + "','" + pageSize + "')");
                    $a.eq(2).attr("href", "javascript:showMsgs('" + data.nextPage + "','" + pageSize + "')");
                    $a.eq(3).attr("href", "javascript:showMsgs('" + data.pages + "','" + pageSize + "')");
                    $span = $("#btn>span");
                    $span.eq(0).html(data.pageNum);
                    $span.eq(1).html(data.pages);

                    $(".del").click(function () {
                        var id = this.id;
                        alertify.confirm("否确定要删除此条短信?",
                            function () {
                                alertify.success('确定');
                                window.location = "${pageContext.request.contextPath}/msg.do/del/" + id;
                            },
                            function () {
                                alertify.error('取消');
                            });
                    });
                },
                "json"
            );
        }

    </script>
</head>
<body>
<div id="main">
    <div class="mainbox">
        <div class="title myMessage png"></div>
        <%@ include file="include.jsp" %>
        <!--错误信息  -->
        <div id="error"></div>
        <!--短消息列表  -->
        <div class="content messageList">
            <ul>
                <%--<c:forEach items="${data.list}" var="msg">

                    <li class="${msg.state==1?'unReaded':''}">
                        <em>${msg.msgCreateDate}</em>
                        <em><a href="${pageContext.request.contextPath}/user.do?param=queryAllUsers&sendid=${msg.sendid}">回信</a></em>
                        <em><a href="#" class="del" id="${msg.id}">删除</a></em>

                        <p>
                            <strong>${msg.title}</strong>
                            <a href="${pageContext.request.contextPath}/msg.do?param=queryMsgById&id=${msg.id}"><c:choose>
                                <c:when test="${fn:length(msg.msgcontent)>8}">
                                    ${fn:substring(msg.msgcontent,0 , 8)}...
                                </c:when>
                                <c:otherwise>
                                    ${msg.msgcontent}
                                </c:otherwise>
                            </c:choose></a>
                        </p>

                    </li>
                </c:forEach>--%>
            </ul>
        </div>
        <!--分页栏 -->
        <div align="center" style="margin-top:10px" id="btn">
            <%-- <a href="javascript:go('1','${data.pageSize}')">首页</a>&nbsp;&nbsp;&nbsp;
             <a href="javascript:go('${data.prePage}','${data.pageSize}')">上一页</a>&nbsp;&nbsp;
             <a href="javascript:go('${data.nextPage}','${data.pageSize}')">下一页</a>&nbsp;&nbsp;
             ${data.pageNo}/${data.totalPages}&nbsp;&nbsp;
             <a href="javascript:go('${data.totalPages}','${data.pageSize}')">最后一页</a>--%>
            <a href="#">首页</a>&nbsp;&nbsp;&nbsp;
            <a href="#">上一页</a>&nbsp;&nbsp;
            <a href="#">下一页</a>&nbsp;&nbsp;
            <span></span>/<span></span>&nbsp;&nbsp;
            <a href="#">最后一页</a>
        </div>
    </div>
</div>
</body>
</html>
