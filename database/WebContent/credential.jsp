<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>User Login</title>
</head>
<body>
    <center>
        <h1>Root User Login</h1><hr>
    </center>
    <div align="center">
            <form action="validate" method="post">
        <table border="1" cellpadding="5">
            <caption>
                <h2>Enter Credentials</h2>
            </caption>
            <tr>
                <th>User-name: </th>
                <td>
                    <input type="text" name="username" size="45"
                            value="<c:out value='${user.username}' />"
                        />
                </td>
            </tr>
            <tr>
                <th>Password: </th>
                <td>
                    <input type="text" name="password" size="45"
                            value="<c:out value='${user.password}' />"
                    />
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="Sign-in" />
                </td>
            </tr>
        </table>
        </form>
    </div>   
</body>
</html>
