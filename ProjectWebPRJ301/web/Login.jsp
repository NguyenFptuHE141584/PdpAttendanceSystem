<%-- 
    Document   : Login
    Created on : Jun 28, 2021, 3:24:31 PM
    Author     : Foxxy
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="css.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <header>
            <div class="headercontain">
                <h1>PDP University Academic Portal</h1>
            </div>
        </header>
        <div class="messFailed">
            <label>${mess}</label>
        </div>
        <main>
            <div class="maincontain">
                <div class="labelLogin" >
                    <h2>Login System</h2></div>
                <div class ="formLogin">
                    <form action="" method="post">
                        <label>User Name<input type="text" name="username"></label>
                        <br>
                        <br>
                        <label>Password <input style="margin-left: 26px;" type="password" name="password"></label>
                        <br>
                        <br>
                        <input style="margin-left: 100px;" type="submit" value="LOGIN">
                    </form>
                </div> 
            </div>
        </main>
    </body>
</html>
