<%--
  Created by IntelliJ IDEA.
  User: Andrey
  Date: 06.06.2017
  Time: 11:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.servletContext.contextPath}/css/index.css" />
    <script type="text/javascript" src="${pageContext.servletContext.contextPath}/js/jquery-3.2.1.min.js"></script>
    <script type="text/javascript">
        function toggleLog() {
            var obj = $('#log');
            if(obj.css("visibility") == "collapse") {
                obj.css("visibility", "visible");
            } else {
                obj.css("visibility", "collapse");
            }
        }
    </script>
</head>
<body>
    <c:if test="${type == 'admin'}">
    <header id="header">
        <a href="${pageContext.servletContext.contextPath}/" class="h_menu">
            <div>Главная</div>
        </a>
        <a href="${pageContext.servletContext.contextPath}/user/view" class="h_menu">
            <div>Записаться на приём</div>
        </a>
        <a href="" class="h_menu">
            <div>Цены</div>
        </a>
        <a href="" class="h_menu">
            <div>Панель управления</div>
        </a>
    </header>
    </c:if>

    <c:if test="${type == 'guest'}">
        <header id="header">
            <div class ="menu"><a href="${pageContext.servletContext.contextPath}/" class="h_menu">
                <span>Главная</span>
            </a> </div>
            <div class ="menu"><a href="${pageContext.servletContext.contextPath}/user/view" class="h_menu">
                <span>Записаться</span>
            </a> </div>
            <div class ="menu"><a href="" class="h_menu">
                <span>Цены</span>
            </a> </div>
            <div class ="menu">
                <span onclick="toggleLog()">Вход</span>
            <div id="log">
                <form action="${pageContext.servletContext.contextPath}/user/login" method="post">
                    <table>
                        <tr>
                            <td><span>Email: </span></td>
                            <td><input type="email" name="email" > </td>
                        </tr>
                        <tr>
                            <td><span>Password: </span></td>
                            <td><input type="password" name="password" ></td>
                        </tr>
                        <tr>
                            <td><input type="submit" align="center" value="Login"/></td>
                            <td><a href="${pageContext.servletContext.contextPath}/views/user/RegisterUser.jsp" class="h_menu"><input type="button" align="center" value="Register" /></a></td>
                        </tr>
                    </table>
                </form>
            </div>
            </div>
        </header>
    </c:if>

    <c:if test="${type == 'user'}">
        <header id="header">
            <a href="${pageContext.servletContext.contextPath}/" class="h_menu">
                <div>Главная</div>
            </a>
            <a href="${pageContext.servletContext.contextPath}/user/view" class="h_menu">
                <div>Записаться на приём</div>
            </a>
            <a href="" class="h_menu">
                <div>Цены</div>
            </a>
            <a href="" class="h_menu">
                <div>${user.login}</div>
            </a>
        </header>
    </c:if>

    <c:if test="${type == 'doctor'}">
        <header id="header">
            <a href="" class="h_menu">
                <div>Главная</div>
            </a>
            <a href="${pageContext.servletContext.contextPath}/user/view" class="h_menu">
                <div>Клиенты</div>
            </a>
            <a href="" class="h_menu">
                <div>Цены</div>
            </a>
            <a href="" class="h_menu">
                <div>Доктор</div>
            </a>
        </header>
    </c:if>

</body>
</html>
