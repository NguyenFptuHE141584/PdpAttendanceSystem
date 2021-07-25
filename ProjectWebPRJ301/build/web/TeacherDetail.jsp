<%-- 
    Document   : TeacherDetail
    Created on : Jul 5, 2021, 9:40:20 PM
    Author     : Foxxy
--%>

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
                <label>| Teacher Detail</label>
            </div>
            <div class="infor_name">
                <a href="TeacherDetail">${sessionScope.userName}</a>
                <a href="Logout">Logout</a>
            </div>
        </div>
        <div class="student_detail">
            <h1>Teacher Detail</h1>
            <div class="table">
                <table><tbody>
                        <tr>
                            <td>
                                <b>Login</b>
                            </td>
                            <td>
                                <span>${inforTeacher.userName}</span>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <b>Full name</b>
                            </td>
                            <td>
                                <span>${inforTeacher.teacherName}</span>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <b>Image</b>
                            </td>
                            <td>
                                <img src="${inforTeacher.image}" style="height:auto;width:120px;border-width:0px;" >
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <b>Date of birth</b>
                            </td>
                            <td>
                                <span>
                                    <fmt:formatDate value="${inforTeacher.dob}" pattern="dd-MM-yyyy" />  
                                </span>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <b>Address</b>
                            </td>
                            <td>
                                <span>${inforTeacher.address}</span>
                            </td>
                        </tr>
                    </tbody></table>
            </div>
        </div>
      

    </body>
</html>
