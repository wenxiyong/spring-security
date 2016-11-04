<%--
  Created by IntelliJ IDEA.
  User: kobe
  Date: 2016/11/3
  Time: 17:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>用户自定义登陆</title>

    <meta name="description" content="login page">

    <link href="/resources/bootstrap-3.3.7-dist/css/bootstrap.min.css" rel="stylesheet">

    <style>
        .col-center-block {
            float: none;
            display: block;
            margin-left: auto;
            margin-right: auto;
        }
    </style>
</head>
<body>

<div class="container " >
    <c:if test="${not empty error}">
        <div class="alert alert-danger">${error}</div>
    </c:if>
    <c:if test="${not empty msg}">
        <div class="alert alert-info">${msg}</div>
    </c:if>

    <div class="row">
        <div class="col-xs-6 col-md-6 col-center-block">
            <form class="form-horizontal" role="form" name='loginForm'
                  action="<c:url value='j_spring_security_check' />" method='POST'>
                <div class="form-group">

                    <label for="inputEmail3" class="col-sm-2 control-label">
                        Account
                    </label>
                    <div class="col-sm-5">
                        <input name="username" type="text" class="form-control" id="inputEmail3" />
                    </div>
                </div>
                <div class="form-group">

                    <label for="inputPassword3" class="col-sm-2 control-label">
                        Password
                    </label>
                    <div class="col-sm-5">
                        <input name="password" type="password" class="form-control" id="inputPassword3" />
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-sm-offset-2 col-sm-5">
                        <div class="checkbox">

                            <label>
                                <input type="checkbox" /> Remember me
                            </label>
                        </div>
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-sm-offset-2 col-sm-5">

                        <button type="submit" class="btn btn-default">
                            Sign in
                        </button>
                    </div>
                </div>
                <input type="hidden" name="${_csrf.parameterName}"
                       value="${_csrf.token}" />
            </form>
        </div>
    </div>
</div>

<script src="/resources/js/jquery-3.1.1.min.js"></script>
<script src="/resources/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
</body>
</html>
