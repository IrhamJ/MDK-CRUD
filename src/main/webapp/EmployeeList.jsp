<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Employee Management - Daftar Karyawan</title>
    <style>
        table, th, td { border: 1px solid black; border-collapse: collapse; padding: 8px; text-align: left; }
        th { background-color: #f2f2f2; }
    </style>
</head>
<body>
    <center>
        <h1>Manajemen Data Karyawan (CRUD Demo)</h1>
        <h3><a href="new">Tambah Karyawan Baru</a></h3>

        <table border="1">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Nama</th>
                    <th>Jabatan</th>
                    <th>Gaji</th>
                    <th>Aksi</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="employee" items="${listEmployee}">
                    <tr>
                        <td><c:out value="${employee.id}" /></td>
                        <td><c:out value="${employee.name}" /></td>
                        <td><c:out value="${employee.position}" /></td>
                        <td><c:out value="${employee.salary}" /></td>
                        <td>
                            <a href="edit?id=<c:out value='${employee.id}' />">Edit</a>
                            &nbsp;&nbsp;&nbsp;&nbsp;
                            <a href="delete?id=<c:out value='${employee.id}' />"
                               onclick="return confirm('Anda yakin ingin menghapus karyawan ini?');">Hapus</a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </center>
</body>
</html>