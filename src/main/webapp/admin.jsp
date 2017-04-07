<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
    integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
</head>
<body>
    <div class="container">
        <h2>Admin page</h2>
        <br/>
        <c:if test="${not empty users}">
            <table class="table">
                <tr>
                    <th>Username</th>
                    <th>E-mail</th>
                    <th>Role</th>
                    <th>Premium</th>
                </tr>
                <c:forEach items="${users}" var="user">
                    <tr>
                        <td>${user.username}</td>
                        <td>${user.email}</td>
                        <td>${user.role}</td>
                        <td>
                            <form class="form-inline" action="changePermission" method="post">
                                <input class="form-control" type="hidden" id="email"
                                    name="email" value="${user.email}"/>

                                <input class="form-control" type="checkbox" id="permission"
                                    name="permission" value="true"
                                    <c:if test="${user.premiumUser}">checked="checked"</c:if> />

                                <input type="submit" value="Change" class="btn btn-default"/>
                            </form>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </c:if>
        <a href="logout" class="btn btn-default">Logout</a>
    </div>
</body>
</html>
