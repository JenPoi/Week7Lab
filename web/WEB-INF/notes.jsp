<%-- 
    Document   : notes
    Created on : Oct 30, 2017, 1:23:43 PM
    Author     : 617702
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Notes</title>
        <link rel="stylesheet" href="<c:url value='styles/notes.css' />" />
    </head>
    <body>
       <h1>Manage Notes</h1>
        <h2>Notes:</h2>
        
        <p>${message}</p>
        <table>
            <tr>
                <th>Note ID</th>
                <th>Date Created</th>
                <th>Contents</th>
                <th>Delete</th>
                <th>Edit</th>
            </tr>
            
            <c:forEach var="note" items="${notes}">
                <tr>
                    <td>${note.noteId}</td>
                    <td>${note.date}</td>
                    <td>${note.contents}</td>
                    <td>
                        <form action="users" method="post" >
                            <input type="submit" value="Delete">
                            <input type="hidden" name="action" value="delete">
                            <input type="hidden" name="selectedUsername" value="${note.noteId}">
                        </form>
                    </td>
                    <td>
                        <form action="users" method="get">
                            <input type="submit" value="Edit">
                            <input type="hidden" name="action" value="view">
                            <input type="hidden" name="selectedNote" value="${note.noteId}">
                        </form>
                    </td>
                </tr>
            </c:forEach>
             </table>
            <c:if test="${selectedNote == null}">
            <h3>Create a new Note</h3>
            <form action="notes" method="POST">
                Note Contents:<br>
                <input type="text" name="contents"><br>
                <input type="hidden" name="action" value="add">
                <input type="submit" value="Save">
            </form>
        </c:if>
        
        <c:if test="${selectedNote != null}">
            <h3>Edit Note</h3>
            <form action="notes" method="POST">
                Note ID: <input type="text" name="noteId" value="${selectedNote.noteId}" readonly><br>
                Contents: <input type="text" name="contents" value="${selectedNote.contents}"><br>
                <input type="hidden" name="action" value="edit">
                <input type="submit" value="Save">
            </form>
        </c:if>
    </body>
</html>
