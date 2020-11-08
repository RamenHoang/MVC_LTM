<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update</title>
<style>
	body {
		background-color: #2b3137;
		font-size: 15px;
		font-family: "Trebuchet MS", Arial, Helvetica, sans-serif;
	}
	h1 {
		color: white;
	}
	div {
		width: 300px;
		background-color: white;
		left: 50%;
	    top: 50%;
	    position: absolute;
	    transform: translate(-50%, -50%);
	    padding: 20px;
	    border-radius: 7px;
	}
	form {
		width: 100%;
	}
	label {
		font-weight: 600;
	}
	input {
		display: block;
		width: 100%;
		line-height: 1.5;
		/* outline: none; */
		margin: auto;
		padding: 10px;
		box-sizing: border-box;
		border: 1px solid #cbcbcb;
		border-radius: 7px;
		/* border: none; */
	}
	input[type="text"] {
		margin-top: 10px;
	}
	input[type="submit"] {
		padding: 10px;
		font-size: 15px;
		background-color: #2ebc4f;
		border-radius: 7px;
		cursor: pointer;
		border: none;
		color: white;
	}
</style>
</head>
<body>
	
	<% 
		HttpSession ss = request.getSession();
		int roleSS = 0, role = 0;
		String userSS = "", MaSV = "", Hoten = "", Gioitinh = "", Khoa = "";
		try {
			roleSS = (int) ss.getAttribute("role");
			userSS = (String) ss.getAttribute("username");
			MaSV = request.getParameter("MaSV");
			Hoten = request.getParameter("Hoten");
			Gioitinh = request.getParameter("Gioitinh");
			Khoa = request.getParameter("Khoa");
		} catch(Exception e) {
			if (userSS.length() > 0) {
				String redirectURL = "http://localhost:8080/hocJSP/login.jsp";
			    response.sendRedirect(redirectURL);
			}
		}
	%>
	
	<h1>Welcom <%= userSS %>, Role: <%= ((roleSS == 1) ? "Admin" : (roleSS == 2) ? "Manager" : "Woker") %></h1>
	<div>
		<form action="SVCheckUpdate" method="post" id="update">
			<label>Sua sinh vien: <%= Hoten %></label>
			<label>MaSV</label>
			<br>
			<input type="text" name="MaSV" value="<%= MaSV %>" readonly/>
			<br>
			<label>Hoten</label>
			<br>
			<input type="text" name="Hoten" value="<%= Hoten %>" required/>
			<br>
			<label>Gioitinh</label>
			<br>
			<label>Nam</label>
			<input type="radio" name="Gioitinh" value="Nam" <%= Gioitinh.equals("Nam") ? "checked" : "" %>/>
			<br>
			<label>Nu</label>
			<input type="radio" name="Gioitinh" value="Nu" <%= Gioitinh.equals("Nu") ? "checked" : "" %>/>
			<br>
			<select name="Khoa" form="update">
				  <option value="CNTT" <%= Khoa.equals("CNTT") ? "selected" : "" %>>CNTT</option>
				  <option value="XD" <%= Khoa.equals("XD") ? "selected" : "" %>>XD</option>
				  <option value="H" <%= Khoa.equals("H") ? "selected" : "" %>>H</option>
			</select><%-- 
			<input type="hidden" name="role" value="<%= role %>" /> --%>
			<br>
			<br>
			<input type="submit" value="Save"/>
			<br>
			<input type="button" value="Turn back" onclick="history.back()"/>
		</form>
	</div>
</body>
</html>