<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="/stylesheets/bootstrap.css" rel="stylesheet">
    <link href="/stylesheets/bootstrap-theme.css" rel="stylesheet">
    <link href="/stylesheets/login.css" rel="stylesheet">
</head>
<body>
<div class="container">
    <div class="row">
        <div class="col-sm-6 col-md-4 col-md-offset-4">
            <h1 class="text-center login-title">Sign Up to continue to Bootsnipp</h1>
            <div class="account-wall">
                <img class="profile-img" src="/images/iCloud_Alt.png"
                     alt="">
                <form class="form-signin" action="/signup" method="post">
                    <input type="text" class="form-control" name="username" placeholder="Email" required autofocus>
                    <input type="password" class="form-control" name="password" placeholder="Password" required>
                    <button class="btn btn-lg btn-primary btn-block" type="submit">Sign Up</button>
                </form>
            </div>
            <a href="/login" class="text-center new-account">Login</a>
        </div>
    </div>
</div></body>
</html>
