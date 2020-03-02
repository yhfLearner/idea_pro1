<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>404页面</title>
    <!-- Bootstrap core CSS -->
    <link href="${pageContext.request.contextPath}/css/bootstrap.css" rel="stylesheet">
    <!-- FONT AWESOME CSS -->
    <link href="${pageContext.request.contextPath}/css/font-awesome.min.css" rel="stylesheet"/>
    <!--GOOGLE FONT -->
    <link href='http://fonts.googleapis.com/css?family=Nova+Flat' rel='stylesheet' type='text/css'>
    <!-- custom CSS here -->
    <link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet"/>
</head>
<body>


<div class="container">

    <div class="row pad-top text-center">
        <div class="col-md-6 col-md-offset-3 text-center">
            <h1> ${test} </h1>
            <h5> ${name}</h5>
            <span id="error-link"></span>
            <h2>! ${message} !</h2>
        </div>
    </div>

    <div class="row text-center">
        <div class="col-md-8 col-md-offset-2">

            <h3><i class="fa fa-lightbulb-o fa-5x"></i></h3>
            <a href="${pageContext.request.contextPath}/index.jsp" class="btn btn-primary">返回首页</a>
        </div>
    </div>

</div>
<!-- /.container -->


<!--Core JavaScript file  -->
<script src="${pageContext.request.contextPath}/scripts/jquery.js"></script>
<!--bootstrap JavaScript file  -->
<script src="${pageContext.request.contextPath}/scripts/bootstrap.js"></script>
<!--Count Number JavaScript file  -->
<script src="${pageContext.request.contextPath}/scripts/countUp.js"></script>
<!--Custom JavaScript file  -->
<script src="${pageContext.request.contextPath}/scripts/custom.js"></script>
</body>
</html>
