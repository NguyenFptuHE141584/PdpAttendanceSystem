<%-- 
    Document   : TeacherSchedule
    Created on : Jul 9, 2021, 11:48:50 AM
    Author     : Foxxy
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
                <label>|Teacher Schedule</label>
            </div>
            <div class="infor_name">
                <a href="TeacherDetail">${sessionScope.userName}</a>
                <a href="Logout">Logout</a>
            </div>
        </div>
        <main>
            <div class="teacher_active">
                <h1>Activities for ${teacherActive.userName} (${teacherActive.teacherName})</h1>
            </div>
            <div class="teacher_Schedule">

                <div class="table_attendance">
                    <table >
                        <thead>
                            <tr>
                                <th style="background: #6B90DA" rowspan="2">
                                    <label>Date</label>
                                    <br>
                                    <form action="TeacherSchedule" method="POST">
                                        <select name="selectedDateTeacher" onchange="this.form.submit()">
                                            <option>Date Schedule</option>
                                            <c:forEach  items="${listWeekOfSchedules}" var="listWeekOfSchedules">
                                                <option value="${listWeekOfSchedules.id}">
                                                    <fmt:formatDate value="${listWeekOfSchedules.startDate}" pattern="dd-MM-yyyy" /> TO
                                                    <fmt:formatDate value="${listWeekOfSchedules.endDate}" pattern="dd-MM-yyyy" /></option>
                                                </c:forEach>
                                        </select>
                                    </form>

                                </th>
                                <th style="background: #6B90DA"><p style="width: 100px; margin-left: 20px;">Monday</p></th>
                                <th style="background: #6B90DA"><p style="width: 130px;">Tuesday</p></th>
                                <th style="background: #6B90DA"><p style="width: 100px; margin-left: 20px;">Wednesday</p></th>
                                <th style="background: #6B90DA"><p style="width: 130px;">Thursday</p></th>
                                <th style="background: #6B90DA"><p style="width: 100px; margin-left: 20px;">Friday</p></th>
                                <th style="background: #6B90DA"><p style="width: 100px;">Saturday</p></th>
                                <th style="background: #6B90DA"><p style="width: 100px;">Sunday</p></th>
                            </tr>
                            <tr>
                                <c:forEach items="${pagingScheduleDates}" var="pagingScheduleDates">
                                    <th style="background: #6B90DA">
                                        <p>
                                            <fmt:formatDate value="${pagingScheduleDates.date}" pattern="dd-MM-yyyy" />
                                        </p>
                                    </th>
                                </c:forEach>
                            </tr>
                        </thead>

                        <tbody>
                            <c:forEach items="${listSlot}" var="listSlot">
                                <tr>
                                    <th>${listSlot.slotName}</th>
                                        <c:forEach items="${pagingScheduleDates}" var="pagingScheduleDates"varStatus="x"> 
                                            <c:set var = "check" value = "0"/>
                                            <c:forEach items="${scheduleDetailsTeacher}" var="scheduleDetailsTeacher" varStatus="y">
                                                <c:if test="${scheduleDetailsTeacher.date == pagingScheduleDates.date && scheduleDetailsTeacher.slotName == listSlot.slotName}">
                                                <td>
                                                    <p style="color:#23527C ">${scheduleDetailsTeacher.subjectCode} at ${scheduleDetailsTeacher.className}</p>
                                                    <p style="width: 150px ; color: red">
                                                        <fmt:formatDate type="time" timeStyle="short" value="${scheduleDetailsTeacher.startTime}" />
                                                        -
                                                        <fmt:formatDate type="time" timeStyle="short" value="${scheduleDetailsTeacher.endTime}" />                                                
                                                    </p>
                                                </td>
                                                <c:set var = "check" value = "1"/>
                                            </c:if> 
                                        </c:forEach>
                                        <c:if test="${check eq 0}">
                                            <td><p style="color: black;margin-left: 60px"> - </p></td> 
                                        </c:if>
                                    </c:forEach>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
        </main>

    </body>
</html>
