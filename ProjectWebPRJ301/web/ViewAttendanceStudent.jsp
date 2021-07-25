<%-- 
    Document   : ViewAttendanceStudent
    Created on : Jul 14, 2021, 6:58:26 PM
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
                <label>| View Attendance For Student </label>
            </div>
            <div class="infor_name">
                <a href="StudentDetail">${sessionScope.userName}</a>
                <a href="Logout">Logout</a>
            </div>
        </div>
        <main>
            <div class="main_contain">
                <div class="teacher_Attendance_left">
                    <h1>Course</h1>
                    <c:forEach items="${liststStudentSubjects}" var="liststStudentSubjects">
                        <ul>
                            <li>
                                <a href="ViewAttendanceStudent?subjectCode=${liststStudentSubjects.subjectCode}&&className=${liststStudentSubjects.className}">
                                    ${liststStudentSubjects.subjectName}
                                    (${liststStudentSubjects.subjectCode})
                                    (${liststStudentSubjects.className}, start
                                    <fmt:formatDate value="${liststStudentSubjects.date}" pattern="dd-MM-yyyy" />
                                </a>
                                <br>
                            </li>
                        </ul>
                    </c:forEach>
                </div>
                <div class ="teacher_Attendance_right">
                   
                        <h1>Information</h1>
                         <c:if test="${subjectCodeS != null && classNameS != null }">
                        <div class="table_attendance">
                            <table>
                                <thead>
                                    <tr>
                                        <th style="background: #6B90DA">NO</th>
                                        <th style="background: #6B90DA">Date</th>
                                        <th style="background: #6B90DA">SLOT</th>
                                        <th style="background: #6B90DA">LECTURER</th>
                                        <th style="background: #6B90DA">CLASS</th>
                                        <th style="background: #6B90DA">ATTEDANCE STATUS</th>
                                        <th style="background: #6B90DA">LECTURER'S COMMENT</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach items="${listDetailAttendanceStudents}" var="listDetailAttendanceStudents">
                                        <tr>
                                            <td>${listDetailAttendanceStudents.id}</td>
                                            <td>
                                                <fmt:formatDate value="${listDetailAttendanceStudents.date}" pattern="dd-MM-yyyy" />
                                            </td>
                                            <td>${listDetailAttendanceStudents.slotId}</td>
                                            <td>${listDetailAttendanceStudents.userNameTeacher}</td>
                                            <td>${listDetailAttendanceStudents.className}</td>
                                            <td>
                                                <c:if test="${listDetailAttendanceStudents.statusAttend ==1}">
                                                    <p style="color: green ;margin-left: 33px">Present</p>
                                                </c:if>
                                                <c:if test="${listDetailAttendanceStudents.statusAttend ==0}">
                                                    <p style="color: red;margin-left: 33px">Absent</p>
                                                </c:if>
                                                <c:if test="${listDetailAttendanceStudents.statusAttend ==2}">
                                                    <p style="color: black;margin-left: 33px">Future</p>
                                                </c:if>
                                            </td>
                                            <td>${listDetailAttendanceStudents.noteAttand}</td>
                                        </tr>
                                    </c:forEach>
                                </tbody>
                            </table>
                            <div class="final" style="border-top: 10px solid #E9F7F6">
                                <h3>ABSENT: ${percent}% ABSENT SO FAR (${totalAbsentSessionOfSubject} ABSENT ON ${totalSessionOfSubject} TOTAL).</h3>
                            </div>
                        </c:if>
                        <c:if test="${subjectCodeS == null && classNameS == null }">
                             <h3 style="color: red;font-weight: bold"> < < < < Please choose course and subject</h3>
                        </c:if>
                    </div>
                </div>
            </div>
        </main>
    </body>
</html>
