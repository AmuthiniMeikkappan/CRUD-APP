<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="java.util.List,com.crud.entity.User" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="css/home.css" rel="stylesheet" type="text/css">
</head>
<body>

<div class="container">
        <h1>CRUD Application</h1>
        <button id="addButton" class="btn">Add New Entry</button>
        
        <!-- Add Modal (Initially Hidden) -->
        <div id="addModal" class="modal hidden">
            <div class="modal-content">
                <span class="close">&times;</span>
                <form id="addForm" action="AddUserServlet" method="post">
                	<table class="entries">
                	<tr>
                	<div class="form-group">
                       <td> <label for="userId">User Id:</label> </td>
                       <td> <input type="text" id="userId" name="userId" required> </td>
                    </div>
                    </tr>
                    <tr>
                    <div class="form-group">
                       <td> <label for="name">Name:</label></td>
                        <td><input type="text" id="name" name="name" required></td>
                    </div>
                    </tr>
                    <tr>
                    <div class="form-group">
                        <td><label for="password">Password:</label></td>
                        <td><input type="password" id="password" name="password" required></td>
                    </div>
                    </tr>
                    <tr>
                    <div class="form-group">
                        <td><label for="email">Email:</label></td>
                        <td><input type="email" id="email" name="email" required></td>
                    </div>
                    </tr>
                    <tr>
                    <div class="form-group">
                        <td><label for="mobile">Mobile Number:</label></td>
                        <td><input type="text" id="mobile" name="mobile" required></td>
                    </div>
                    </tr>
                    <tr>
                    <div class="form-group">
                        <td><label for="address">Address:</label></td>
                        <td><input type="text" id="address" name="address" required></td>
                    </div>
                    </tr>
                    </table>
                    <button type="submit" class="btn">Add</button>
                </form>
            </div>
        </div>
        
        <!-- Edit Modal (Initially Hidden) -->
        <div id="editModal" class="modal hidden">
            <div class="modal-content">
                <span class="close">&times;</span>
                <form id="editForm" action="ModifyServlet" method="post">
                    <input type="hidden" id="editUserId" name="userId" readonly="readonly">
                    <table class="entries">
                    <tr>
                    <div class="form-group">
                        <td><label for="editName">Name:</label></td>
                        <td><input type="text" id="editName" name="name"></td>
                    </div>
                    </tr>
                    <tr>
                    <div class="form-group">
                        <td><label for="editEmail">Email:</label></td>
                        <td><input type="email" id="editEmail" name="email"></td>
                    </div>
                    </tr>
                    <tr>
                    <div class="form-group">
                        <td><label for="editPassword">Password:</label></td>
                        <td><input type="password" id="editPassword" name="password"></td>
                    </div>
                    </tr>
                    <tr>
                    <div class="form-group">
                        <td><label for="editMobile">Mobile Number:</label></td>
                        <td><input type="text" id="editMobile" name="mobile"></td>
                    </div>
                    </tr>
                    <tr>
                    <div class="form-group">
                        <td><label for="editAddress">Address:</label></td>
                        <td><input type="text" id="editAddress" name="address"></td>
                    </div>
                    </tr>
                    </table>
                    <button type="submit" class="btn">Update</button>
                    
                </form>
            </div>
        </div>
<div class="user-details">
<h2>Data Lists</h2>
<a href="deleteAll" class="deleteBtn">Delete All</a>
<table class="data-list">
<tr>
<th>User Id</th>
<th>Name</th>
<th>Email</th>
<th>Mobile</th>
<th>Address</th>
<th>Actions</th>
</tr>
<%List<User> userList = (List)session.getAttribute("userList"); 
	if(userList != null){
		for(User user : userList){
%>
<tr>
<td><%out.println(user.getUserId()); %></td>
<td><%out.println(user.getName()); %></td>
<td><%out.println(user.getEmail()); %></td>
<td><%out.println(user.getMobile()); %></td>
<td><%out.println(user.getAddress()); %></td>
<td><a href="delete?userId=<%=user.getUserId() %>" class="btn">Delete</a>
<button id="editButton"  class="edit btn" onclick="editUser(<%=user.getUserId() %>, '<%=user.getName() %>', '<%=user.getEmail() %>', '<%=user.getPassword() %>', '<%=user.getMobile() %>', '<%=user.getAddress() %>')">Edit</button>
</td>
</tr>
<%} %>
<%} %>
</table>
</div>
<script>
        document.getElementById('addButton').addEventListener('click', function() {
            document.getElementById('addModal').style.display = 'block';
        });
        
        document.getElementById('editButton').addEventListener('click', function() {
            document.getElementById('editModal').style.display = 'block';
        });

        document.querySelectorAll('.close').forEach(function(closeBtn) {
            closeBtn.onclick = function() {
                document.getElementById('addModal').style.display = 'none';
                document.getElementById('editModal').style.display = 'none';
            };
        });

        window.onclick = function(event) {
            if (event.target === document.getElementById('addModal')) {
                document.getElementById('addModal').style.display = 'none';
            } else if (event.target === document.getElementById('editModal')) {
                document.getElementById('editModal').style.display = 'none';
            }
        };
        
        function editUser(userId, name, email,password, mobile, address) {
            document.getElementById('editUserId').value = userId;
            document.getElementById('editName').value = name;
            document.getElementById('editEmail').value = email;
            document.getElementById('editPassword').value = password;
            document.getElementById('editMobile').value = mobile;
            document.getElementById('editAddress').value = address;
            document.getElementById('editModal').style.display = 'block';
        }
    </script>
</body>
</html>