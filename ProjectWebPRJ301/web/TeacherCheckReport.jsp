<%-- 
    Document   : TeacherCheckReport
    Created on : Jul 19, 2021, 6:10:44 PM
    Author     : Foxxy
--%>

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
                <a href="TeacherPage">Home</a>
                <label>|Check Report </label>
            </div>
            <div class="infor_name">
                <a href="TeacherDetail">${sessionScope.userName}</a>
                <a href="Logout">Logout</a>
            </div>
        </div>
        <main>
            <div style="margin-left: 280px;width: 70%;">
                <h1>Check Report</h1>
                <div>
                    <table>
                        <thead>
                            <tr>
                                <th style="background: #6B90DA"><p>Date</p></th>
                                <th style="background: #6B90DA"><p>Roll Number</p></th>
                                <th style="background: #6B90DA"><p>Report of Student</p></th>
                                <th style="background: #6B90DA"><p>Content Report</p></th>
                                <th style="background: #6B90DA"><p>Status</p></th>
                                <th style="background: #6B90DA"><p>Accept/Reject</p></th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${listCheckReports}" var="listCheckReports">
                                <c:if test="${listCheckReports.statusl == 2}">
                                    <tr>
                                        <td><p style="margin-left: 50px;font-weight: bold">${listCheckReports.date} (${listCheckReports.time})</p></td>
                                        <td><p style="margin-left: 70px;">${listCheckReports.rollNumber}</p></td>
                                        <td><p style="margin-left: 70px;">${listCheckReports.reportStudent}</p></td>
                                        <td><p style="margin-left: 70px;">${listCheckReports.contentReport}</p></td>
                                        <td>
                                            <p style="margin-left: 70px;color: black">Processing...</p>
                                        </td>
                                        <td>
                                            <a style="margin-left: 20px;" href="CheckReport?date=${listCheckReports.date}&&rollNumber=${listCheckReports.rollNumber}&&time=${listCheckReports.time}&&status=1">Accept</a>
                                            <a style="margin-left: 20px;" href="CheckReport?date=${listCheckReports.date}&&rollNumber=${listCheckReports.rollNumber}&&time=${listCheckReports.time}&&status=0">Reject</a>
                                        </td>
                                    </tr>
                                </c:if>
                                <c:if test="${listCheckReports.statusl == 1}">
                                    <tr>
                                        <td><p style="margin-left: 50px;font-weight: bold">${listCheckReports.date} (${listCheckReports.time})</p></td>
                                        <td><p style="margin-left: 70px;">${listCheckReports.rollNumber}</p></td>
                                        <td><p style="margin-left: 70px;">${listCheckReports.reportStudent}</p></td>
                                        <td><p style="margin-left: 70px;">${listCheckReports.contentReport}</p></td>
                                        <td>
                                            <p style="margin-left: 70px;color: green">Complete</p>
                                        </td>
                                    </tr>
                                </c:if>
                                <c:if test="${listCheckReports.statusl == 0}">
                                    <tr>
                                        <td><p style="margin-left: 50px;font-weight: bold">${listCheckReports.date} (${listCheckReports.time})</p></td>
                                        <td><p style="margin-left: 70px;">${listCheckReports.rollNumber}</p></td>
                                        <td><p style="margin-left: 70px;">${listCheckReports.reportStudent}</p></td>
                                        <td><p style="margin-left: 70px;">${listCheckReports.contentReport}</p></td>
                                        <td>
                                            <p style="margin-left: 70px;color: red">Reject</p>
                                        </td>
                                    </tr>
                                </c:if>
                            </c:forEach>
                        </tbody>
                    </table>
                    <h3 style="margin-left: 500px">${messCheckReport}</h3>
                </div>
            </div>
        </main>
    </body>
</html>
