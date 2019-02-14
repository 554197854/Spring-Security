<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<form class="form-auth-small" action="/login" method="post">
    <div class="form-group">
        <div class="input-group">
            <span class="input-group-addon"><i class="fa fa-user"></i></span>
            <input class="form-control" placeholder="Username" type="text" name="username">
        </div>
    </div>
    <div class="form-group">
        <label for="signin-password" class="control-label sr-only">Password</label>
        <input type="password" class="form-control" id="signin-password" name="password"  placeholder="Password">
    </div>

    <div class="form-group clearfix">
        <label class="fancy-checkbox element-left">
            <input type="checkbox" name="remember">
            <span>Remember me</span>
        </label>
    </div>
    <button type="submit" class="btn btn-primary btn-lg btn-block">Login</button>

</form>
</body>
</html>