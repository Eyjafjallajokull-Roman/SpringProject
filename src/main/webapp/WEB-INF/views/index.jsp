<!DOCTYPE html>
<html>
<%@ page language="java" session="true" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<head>
    <title>Spring MVC</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet"
          href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
    <script
            src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script
            src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
</head>
<body>

<nav class="navbar navbar-default">
    <div class="container-fluid">
        <div style="margin: 15px; font-size: 14px; color: green;" class="navbar-header">Spring MVC - Logos</div>
        <ul class="nav navbar-nav">
            <li class="active"><a href="/">All EI</a></li>
            <li><a href="/product/create">new EI</a></li>
        </ul>
    </div>
</nav>

<div class="container">

    <table class="table table-striped">
        <thead>
        <tr>
            <th>Id</th>
            <th>Name</th>
            <th>accreditation</th>
            <th>numberOfStudents</th>
            <th>numberOfUniversity</th>
            <th>addressUniversity</th>
            <th>Edit</th>
            <th>Delete</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="institut" items="${institutions}">
            <tr>
                <td>${institut.id}</td>
                <td>${institut.name}</td>
                <td>${institut.accreditation}</td>
                <td>${institut.numberOfStudents}</td>
                <td>${institut.numberOfUniversity}</td>
                <td>${institut.addressUniversity}</td>
                <td><a href="/edit?id=${institut.id}">Edit</a></td>
                <td><a href="/institution/delete/${institut.id}">Delete</a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
