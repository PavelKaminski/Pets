<%--
  Created by IntelliJ IDEA.
  User: Pasha
  Date: 05.02.2023
  Time: 01:09
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
<h2>This is the pet, you've selected:</h2>
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
    <tr>
        <td>${pet.id}</td>
        <td>${pet.species}</td>
        <td>${pet.name}</td>
        <td>${pet.age}</td>
        <td>${pet.color}</td>
        <td>${pet.owner}</td>
    </tr>
</table>
<br/>
<br/>
<form name="edit" method="post" action="engine">
    <input type="hidden" name="command" value="editform">
    <input type="hidden" name="pet" value="${pet}">
    <input type="submit" value="Edit" style="font-weight: bold">
</form>
<form name="delete" method="post" action="engine">
    <input type="hidden" name="command" value="delete">
    <input type="hidden" name="id" value="${pet.id}">
    <input type="submit" value="Delete" style="font-weight: bold">
</form>
<br/>

<a href="/Pets/main.html">Return to main</a>

</body>
</html>
