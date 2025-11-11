<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Formulir Karyawan</title>
</head>
<body>
    <center>
        <h1>
            <c:if test="${employee != null}">
                Edit Data Karyawan
            </c:if>
            <c:if test="${employee == null}">
                Tambah Karyawan Baru
            </c:if>
        </h1>
        <h3><a href="./">Kembali ke Daftar</a></h3>

        <form action="<c:if test="${employee != null}">update</c:if><c:if test="${employee == null}">insert</c:if>" method="post">
            <c:if test="${employee != null}">
                <input type="hidden" name="id" value="<c:out value='${employee.id}' />" />
                <input type="hidden" name="action" value="update" />
            </c:if>

            <table border="0">
                <tr>
                    <td>Nama:</td>
                    <td><input type="text" name="name"
                               value="<c:out value='${employee.name}' />" required></td>
                </tr>
                <tr>
                    <td>Jabatan:</td>
                    <td><input type="text" name="position"
                               value="<c:out value='${employee.position}' />" required></td>
                </tr>
                <tr>
                    <td>Gaji:</td>
                    <td><input type="number" name="salary" step="0.01"
                               value="<c:out value='${employee.salary}' />" required></td>
                </tr>
                <tr>
                    <td colspan="2" align="center">
                        <input type="submit" value="Simpan Data">
                    </td>
                </tr>
            </table>
        </form>
    </center>
</body>
</html>