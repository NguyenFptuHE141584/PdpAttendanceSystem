<%-- 
    Document   : TeacherAttendance
    Created on : Jul 6, 2021, 1:03:10 PM
    Author     : Foxxy
--%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
                <label>| Attedance class</label>
            </div>
            <div class="infor_name">
                <a href="TeacherDetail">${sessionScope.userName}</a>
                <a href="Logout">Logout</a>
            </div>
        </div>
        <main>
            <div class="main_contain">
                <div class="teacher_Attendance_left">
                    <h1>Course</h1>
                    <p style="color: red;font-weight: bold">${mess}</p>
                    <c:forEach items="${listTeacherSubject}" var="listTS">
                        <ul>
                            <li>
                                <a  href="TeacherAttendance?subjectCode=${listTS.subjectCode}&&className=${listTS.className}&&startTime=${listTS.startTime}&&endTime=${listTS.endTime}">
                                    ${listTS.subjectName}
                                    (${listTS.subjectCode})
                                    (${listTS.className})
                                    (<fmt:formatDate type="time" timeStyle="short" value="${listTS.startTime}" />
                                    TO
                                    <fmt:formatDate type="time" timeStyle="short" value="${listTS.endTime}" />)
                                    (<fmt:formatDate value="${listTS.date}" pattern="dd-MM-yyyy" /> )
                                </a>
                                <br>
                            </li>
                        </ul>
                    </c:forEach>
                </div>
                <div class ="teacher_Attendance_right">
                    <h1>Information</h1>
                    <p style="color: green;font-weight: bold">${mess2}</p>
                    <c:if test="${sessionScope.subjectCode != null &&sessionScope.startTime != null&&sessionScope.endTime != null}">
                        <form action="TeacherAttendance" method="POST">
                            <div class="table_attendance">
                                <table>
                                    <thead>
                                        <tr>
                                            <th style="background: #6B90DA">
                                                <p>Roll Number</p>
                                            </th>
                                            <th style="background: #6B90DA">
                                                <p>Student Name</p>

                                            </th>
                                            <th style="background: #6B90DA">
                                                <p>Attendance</p>

                                            </th>
                                            <th style="background: #6B90DA">
                                                <p>Note</p>
                                            </th>
                                        </tr>
                                    </thead>
                                    <tbody>

                                        <c:forEach items="${list}" var="listStudent">
                                            <tr>
                                                <td>${listStudent.rollNumber}</td>
                                                <td >${listStudent.studentName}</td>
                                                <td>
                                                    <p style="margin-left: 30px">
                                                        Attend<input type="radio" name="attendance${listStudent.rollNumber}" ${listStudent.statusAttendance==1?"checked=\"checked\"":""} value="1">
                                                        Absent<input type="radio" name="attendance${listStudent.rollNumber}" ${listStudent.statusAttendance==0?"checked=\"checked\"":""} value="0">
                                                    </p>
                                                </td>
                                                <td>
                                                    <div style="margin-left: 70px;"class="text_note">
                                                        <input style="width: 300px;" type="text" name="note${listStudent.rollNumber}" value="${listStudent.note}">
                                                    </div>
                                                </td>
                                            </tr>
                                        </c:forEach>
                                    </tbody>
                                </table>
                                <input type="submit" value="Save">
                            </div>
                        </form>

                    </c:if>
                    <c:if test="${sessionScope.subjectCode == null &&sessionScope.startTime == null&&sessionScope.endTime == null}">
                        <p style="color: red;font-weight: bold">< < < < < Please teacher choice subject need to attendance</p>
                    </c:if>
                </div>
            </div>
        </main>

    </body>
</html>
