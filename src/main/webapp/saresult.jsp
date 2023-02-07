<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Pasha
  Date: 31.01.2023
  Time: 19:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Pets</title>
    <style>
        table {
            border-collapse:collapse;
            width: 50%;
            text-align: center;
        }
        th, td {
            border: 1.5px solid black;
            padding: 5px;
        }
    </style>
</head>
<body>
<h2>These are all my pets:</h2>
<br/>
<table>
    <tr style="background-color:rgb(207,207,211)">
    <th>Pet ID</th>
    <th>Pet species</th>
    <th>Pet name</th>
    <th>Pet age</th>
    <th>Pet color</th>
    <th>Pet owner</th>
    </tr>
    <c:forEach var="pet" items="${petList}">
        <tr>
            <td>${pet.id}</td>
            <td>${pet.species}</td>
            <td>${pet.name}</td>
            <td>${pet.age}</td>
            <td>${pet.color}</td>
            <td>${pet.owner}</td>
        </tr>
    </c:forEach>
</table>
<br/>

<a href="/Pets/main.html">Return to main</a>

</body>
</html>
