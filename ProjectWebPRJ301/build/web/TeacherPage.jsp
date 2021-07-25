<%-- 
    Document   : TeacherPage
    Created on : Jul 5, 2021, 9:20:03 PM
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
        <div class="infor">
            <div class="home">
                <a href="">Home</a>
            </div>
            <div class="infor_name">
                <a href="TeacherDetail">${sessionScope.userName}</a>
                <a href="Logout">Logout</a>
            </div>
        </div>
        <main>
            <div class="main_contain">
                <div class="main_left">
                    <h1>News</h1>
                </div>
                <div class="main_right">
                    <h1>Academic Information</h1>
                    <div class="main_right_contain">
                        <ul>
                            <li style="font-weight: bold"><a href="TeacherSchedule">View weekly timetable</a></li>
                            <br>
                            <br>
                            <li style="font-weight: bold"><a href="TeacherAttendance">Attedance class</a></li>
                            <br>
                            <br>
                            <li style="font-weight: bold"><a href="CheckReport">Check Report</a></li>
                            <br>
                            <br>
                        </ul>
                    </div>
                </div>
            </div>
        </main>
        
    </body>
</html>
