<%-- 
    Document   : Login
    Created on : 23-giu-2017, 10.24.35
    Author     : tss
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css" rel="stylesheet">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <br>
        <br>
        <div class="container">
        
         <form method="POST" action="login">
                <div class="form-group">
                    <label for="user">User</label>
                    <input type="text" class="form-control" id="user" placeholder="user" name="user">
                </div>
                <div class="form-group">
                    <label for="password">Password</label>
                    <input type="text" class="form-control" id="password" placeholder="password" name="password">
                </div>
                <input type="submit" class="btn btn-default" value="invio">
            </form>
        </div>
    </body>
</html>
