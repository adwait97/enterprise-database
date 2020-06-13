<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>New User</title>
</head>
<body>
    <center>
        <h1>New User Sign-Up</h1>
    </center>
    <div align="center">
            <form action="insert" method="post">
        <table border="1" cellpadding="5">
            <caption>
                <h2>
                       --Registration--
                </h2>
            </caption>         
            <tr>
                <th>First Name: </th>
                <td>
                    <input type="text" name="firstname" size="45"
                            value="<c:out value='${user.first_name}' />"
                        />
                </td>
            </tr>
            <tr>
                <th>Last Name: </th>
                <td>
                    <input type="text" name="lastname" size="45"
                            value="<c:out value='${user.last_name}' />"
                        />
                </td>
            </tr>
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
                <th>Re-enter Password: </th>
                <td>
                    <input type="text" name="password2" size="45"
                            value="<c:out value='${user.password}' />"
                        />
                </td>
            </tr>
            <tr>
                <th>Age: </th>
                <td>
                    <input type="text" name="age" size="5"
                            value="<c:out value='${user.age}' />"
                    />
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="Sign-up" />
                </td>
            </tr>
        </table>
        </form>
    </div>   
</body>
</html>