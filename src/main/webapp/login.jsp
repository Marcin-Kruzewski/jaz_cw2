<html>
<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
    integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
</head>
<body>
    <div class="container">
        <h2>Login form</h2>
        <form action="login" method="post">
            <label>E-mail:</label>
            <input class="form-control" type="text" id="email" name="email"/>

            <label>Password:</label>
            <input class="form-control" type="password" id="password" name="password"/>

            <br/>
            <input class="btn btn-default" type="submit" value="Login"/>
        </form>
    </div>
</body>
</html>
