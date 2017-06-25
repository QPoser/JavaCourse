<%--
  Created by IntelliJ IDEA.
  User: Andrey
  Date: 08.06.2017
  Time: 16:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Register</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.servletContext.contextPath}/css/UserRegister.css" />

    <script>

        function checkPassword(id) {
            var pass1 = document.getElementById('password');
            var pass2 = document.getElementById(id);
            if (pass1.value == pass2.value) {
                pass2.style.backgroundColor = "#00ff00";
            } else {
                pass2.style.backgroundColor = "#ff4c4d";
            }
        }

        function checkEmail(id) {
            var elem = document.getElementById(id);
            if(elem.value.indexOf("@") > 0) {
                elem.style.backgroundColor = "#00ff00";
            } else {
                elem.style.backgroundColor = "#ff4c4d";
            }
        }

        function checkLogin(id) {
            var elem = document.getElementById(id);
            if(elem.value.length > 2) {
                elem.style.backgroundColor = "#00ff00";
            } else {
                elem.style.backgroundColor = "#ff4c4d";
            }
        }
    </script>
</head>
<body>
<div id="register">
    <form id="regForm" action="${pageContext.servletContext.contextPath}/user/create" method="post">

        <table>
            <tr>
                <td align="right">Login : <input type = "text" id="login" name = "login" onchange="checkLogin(this.id)"></td>
            </tr>
            <tr>
                <td align="right">Email : <input type = "email" id="email" name = "email" onchange="checkEmail(this.id)"></td>
            </tr>
            <tr>
                <td align="right">Password : <input id="password" type = "password" name = "password" onchange="checkLogin(this.id), checkPassword('passwordConfim')"></td>
            </tr>
            <tr>
                <td align="right">Confim password : <input type = "password" id="passwordConfim" name = "passwordConfim" onchange="checkPassword(this.id)"></td>
            </tr>
            <tr>
                <td><input type="submit" align="center" value="Submit"></td>
            </tr>
        </table>
    </form>

</div>


</body>
</html>
