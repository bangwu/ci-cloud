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
            <h1 class="text-center login-title">Sign in to continue to Bootsnipp</h1>
            <div class="account-wall">
                <img class="profile-img" src="/images/iCloud_Alt.png"
                     alt="">
                <form class="form-signin" action="/login" method="post">
                    <input type="text" class="form-control" name="user.username" placeholder="Email" required autofocus>
                    <input type="password" class="form-control" name="user.password" placeholder="Password" required>
                    <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
                    <label class="checkbox pull-left">
                        <input type="checkbox" value="remember-me">
                        Remember me
                    </label>
                    <a href="#" class="pull-right need-help">Need help? </a><span class="clearfix"></span>
                </form>
            </div>
            <a href="#" class="text-center new-account">Create an account </a>
        </div>
    </div>
</div></body>
</html>
