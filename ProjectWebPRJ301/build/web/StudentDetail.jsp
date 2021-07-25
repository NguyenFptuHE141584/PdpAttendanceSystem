<%-- 
    Document   : StudentDetail
    Created on : Jun 30, 2021, 5:53:33 PM
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
                <a href="StudentPage">Home</a>
                <label>| Student Detail</label>
            </div>
            <div class="infor_name">
                <a href="StudentDetail">${sessionScope.userName}</a>
                <a href="Logout">Logout</a>
            </div>
        </div>
        <div class="student_detail">
            <h1>Student Detail</h1>
            <table><tbody>
                    <tr>
                        <td>
                            <b>Login</b>
                        </td>
                        <td>
                            <span>${inforStudent.userName}</span>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <b>Full name</b>
                        </td>
                        <td>
                            <span>${inforStudent.studentName}</span>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <b>Image</b>
                        </td>
                        <td>
                            <img src="${inforStudent.img}" style="height:auto;width:120px;border-width:0px;" >
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <b>Date of birth</b>
                        </td>
                        <td>
                            <span>
                                <fmt:formatDate value="${inforStudent.dob}" pattern="dd-MM-yyyy" /> 
                            </span>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <b>Address</b>
                        </td>
                        <td>
                            <span>${inforStudent.address}</span>
                        </td>
                    </tr>
                </tbody></table>
        </div>
    </body>
</html>
