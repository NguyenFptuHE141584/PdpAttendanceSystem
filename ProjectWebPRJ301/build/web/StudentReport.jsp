<%-- 
    Document   : StudentReport
    Created on : Jul 16, 2021, 12:03:43 AM
    Author     : Foxxy
--%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
                <a href="StudentPage">Home</a>
                <label>| Report </label>
            </div>
            <div class="infor_name">
                <a href="StudentDetail">${sessionScope.userName}</a>
                <a href="Logout">Logout</a>
            </div>
        </div>
        <main>
            <div class="main_contain">
                <div class="teacher_Attendance_left">
                    <h1>Report</h1>
                    <p style="color: green">${mess}</p>
                    <p style="color: red">${mess1}</p>
                    <form style="margin-top:20px;" action="StudentReport" method="POST">
                        <label style="font-weight: bold">Teacher:</label>
                        <select style="width: 73%" name="selectTeacher">
                            <option value="0">--Select--</option>
                            <c:forEach items="${listTeacher}" var="listTeacher">
                                <option value="${listTeacher.teacherID}">${listTeacher.teacherName}(${listTeacher.userName})</option>
                            </c:forEach>
                        </select>
                        <label style="font-weight:bold;margin-top: 30px;">Content:</label>
                        <input style="height: 100px;width: 95%" type="text" name="contentReport">
                        <input style="margin-top: 10px;"type="submit" value="Report">
                    </form>
                </div>
                <div class ="teacher_Attendance_right">
                    <h1>Information</h1>
                    <div class="table_attendance">
                        <table>
                            <thead>
                                <tr>
                                    <th style="background: #6B90DA"><p>Date</p></th>
                                    <th style="background: #6B90DA"><p>Report Teacher</p></th>
                                    <th style="background: #6B90DA"><p>Content Report</p></th>
                                    <th style="background: #6B90DA"><p>Status</p></th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach items="${listReports}" var="listReports">
                                    <tr>
                                        <td>
                                            <p style="margin-left: 20px;font-weight: bold">${listReports.date} (${listReports.time})</p>
                                            
                                        </td>
                                        <td><p style="margin-left:90px;">${listReports.nameTeacher}</p></td>
                                        <td><p style="margin-left:70px;">${listReports.contentReport}</p></td>
                                        <td>
                                            <c:if test="${listReports.status == 2}">
                                                <p style="margin-left:110px;color: black">Processing...</p>
                                            </c:if>
                                            <c:if test="${listReports.status == 1}">
                                                <p style="margin-left:110px;color: green">Complete</p>
                                            </c:if>
                                            <c:if test="${listReports.status == 0}">
                                                <p style="margin-left:110px;color: red">Reject</p>
                                            </c:if>
                                        </td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                        <h2 style="margin-left: 350px;">${mess2}</h2>
                    </div>
                </div>
            </div>
        </main>
    </body>
</html>
