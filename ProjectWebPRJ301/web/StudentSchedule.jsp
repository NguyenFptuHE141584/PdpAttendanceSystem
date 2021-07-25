<%-- 
    Document   : StudentSchedule
    Created on : Jul 13, 2021, 11:11:14 PM
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
                <label>|Student Schedule</label>
            </div>
            <div class="infor_name">
                <a href="StudentDetail">${sessionScope.userName}</a>
                <a href="Logout">Logout</a>
            </div>  
        </div>
        <main>
            <div class="teacher_active">
                <h1>Activities for ${studentActive.userName} (${studentActive.studentName})</h1>
            </div>
            <div class="teacher_Schedule">
                <div class="table_attendance">
                    <table >
                        <thead>
                            <tr>
                                <th style="background: #6B90DA" rowspan="2">
                                    <label>Date</label>
                                    <br>
                                    <form action="StudentSchedule" method="POST">
                                        <select name="selectedDateStudent"  onchange="this.form.submit()">
                                            <option>Date Schedule</option>
                                            <c:forEach  items="${listWeekOfSchedules}" var="listWeekOfSchedules">
                                                <option value="${listWeekOfSchedules.id}">
                                                    <fmt:formatDate value="${listWeekOfSchedules.startDate}" pattern="dd-MM-yyyy" />
                                                    TO
                                                    <fmt:formatDate value="${listWeekOfSchedules.endDate}" pattern="dd-MM-yyyy" />
                                                </option>
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
                                    <th style="background: #6B90DA;width: 50px">
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
                                            <c:forEach items="${scheduleDetailsStudent}" var="scheduleDetailsStudent" varStatus="y">
                                                <c:if test="${scheduleDetailsStudent.date == pagingScheduleDates.date && scheduleDetailsStudent.slotName == listSlot.slotName}">
                                                <td>
                                                    <p style="color:#23527C ;width: 150px;margin-left: 10px;padding-left: 5px">${scheduleDetailsStudent.subjectCode} at ${scheduleDetailsStudent.className}</p>
                                                    <p style="width: 100px ; background-color: #5cb85c;font-weight: bold;margin-left: 20px;border: 1px solid black">
                                                        (<fmt:formatDate type="time" timeStyle="short" value="${scheduleDetailsStudent.startTime}" />
                                                        -
                                                        <fmt:formatDate type="time" timeStyle="short" value="${scheduleDetailsStudent.endTime}" />)            
                                                    </p>
                                                    <c:if test="${scheduleDetailsStudent.statusAttend ==1}">
                                                        <p style="color: green ;margin-left: 33px">Attended</p>
                                                    </c:if>
                                                    <c:if test="${scheduleDetailsStudent.statusAttend ==0}">
                                                        <p style="color: red;margin-left: 33px">Absent</p>
                                                    </c:if>
                                                    <c:if test="${scheduleDetailsStudent.statusAttend ==2}">
                                                        <p style="color: red;margin-left: 33px">(Not-yet)</p>
                                                    </c:if>
                                                </td>
                                                <c:set var = "check" value = "1"/>
                                            </c:if> 
                                        </c:forEach>
                                        <c:if test="${check eq 0}">  <td> </td></c:if>
                                    </c:forEach>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </main>
        <div class="more_note">
            <p><b>More note / Chú thích thêm</b>:</p>
            <div id="ctl00_mainContent_divfoot">
                <ul>
                    <li>(<font color='green'>attended</font>): ${studentActive.userName} had attended this activity / ${studentActive.studentName} đã tham gia hoạt động này</li>
                    <li>(<font color='red'>absent</font>): ${studentActive.userName} had NOT attended this activity / ${studentActive.studentName} đã vắng mặt buổi này</li>   
                    <li>(-): no data was given / chưa có dữ liệu</li> </ul>
            </div>
        </div>
    </body>
</html>
