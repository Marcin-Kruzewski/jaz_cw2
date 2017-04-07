<html>
<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
    integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
</head>
<body>
    <div class="container">
        <h2>Profile</h2>

        Username: <b>${user.username}</b><br/>
        E-mail: <b>${user.email}</b><br/>
        Role: <b>${user.role}</b><br/>

        <br />

        <a href="premium.jsp" class="btn btn-default">Premium page</a>
        <a href="admin" class="btn btn-default">Administration</a>
        <a href="logout" class="btn btn-default">Logout</a>
    </div>
</body>
</html>
