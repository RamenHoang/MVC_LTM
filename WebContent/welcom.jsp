<%@page import="model.BEAN.Wife"%>
<%@page import="java.util.ArrayList"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcom</title>

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
		max-width: 700px;
		min-width: 500px;
		background-color: white;
		left: 50%;
	    top: 50%;
	    position: absolute;
	    transform: translate(-50%, -50%);
	    padding: 20px;
	    border-radius: 7px;
	}
	table {
		border-collapse: collapse;	
		width: 100%;
		border-radius: 7px;
	}
	
	table td, table th {
	 	border: 1px solid #ddd;
	 	padding: 8px;
	}
	
	table tr:nth-child(even){ background-color: #dfdfdf; }
	
	table tr:hover { background-color: #ddd; }
	
	table th {
	 	padding-top: 12px;
	 	padding-bottom: 12px;
	 	text-align: left;
	 	background-color: #2ebc4f;
	 	color: white;
	}
	
	form {
		width: 100%;
	}
	label {
		font-weight: 600;
	}
	input, a.addNew {
		display: inline-block;
		width: 20%;
		line-height: 1.5;
		/* outline: none; */
		margin: auto;
		padding: 10px;
		box-sizing: border-box;
		border: 1px solid #cbcbcb;
		border-radius: 7px;
		text-align: center;
		text-decoration: none;
		/* border: none; */
	}
	a.addNew {
		
	}
	input[type="text"], input[type="password"] {
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
		String userSS = "";
		int roleSS = 0;
		try {
			userSS = (String)ss.getAttribute("username");
			roleSS = (int)ss.getAttribute("role");
		} catch(Exception e) {
			String redirectURL = "http://localhost:8080/hocJSP/login.jsp";
		    response.sendRedirect(redirectURL);
		}
		ArrayList<Wife> wifies = new ArrayList<Wife>();
	%>
	
	<h1>Welcom <%= userSS %></h1>
	<div>
		<% if (request.getAttribute("result_mod") != null) { %>
			<h2><%= request.getAttribute("result_mod") %> lines changed: <%= (String)request.getAttribute("Hoten") %> updated</h2>
		<% } %>
		<% if (request.getAttribute("result_del") != null) { %>
			<h2><%= request.getAttribute("result_del") %> lines deleted: <%= (String)request.getAttribute("MaSV") %> deleted</h2>
		<% } %>
		<% if (request.getAttribute("result_new") != null) { %>
			<h2><%= request.getAttribute("result_new") %> lines added: <%= (String)request.getAttribute("Hoten") %> added</h2>
		<% } %>
		
		<form action="SVSearch" method="post" id="selectFalcuty">
			<select name="falcuty" form="selectFalcuty">
				  <option value="CNTT">CNTT</option>
				  <option value="XD">XD</option>
				  <option value="H">H</option>
			</select>
			<input type="submit" value="Show"/>
			<a href="/hocJSP/new.jsp" class="addNew">Add new</a>
		</form>
		
		<% if (ss.getAttribute("users") != null) { %>
			<% wifies = (ArrayList<Wife>)ss.getAttribute("users"); %>
			<% if (request.getAttribute("MaSV") != null) { %>
				<% if (request.getAttribute("result_mod") != null) { 
					for (int i = 0; i < wifies.size(); i++) {
						Wife w = wifies.get(i);
						//Object a = (String)request.getAttribute("username");
						if (w.getMaSV().equals((String)request.getAttribute("MaSV"))) {
							w.setHoten((String)request.getAttribute("Hoten"));
							w.setGioitinh((String)request.getAttribute("Gioitinh"));
							w.setKhoa((String)request.getAttribute("Khoa"));
							wifies.set(i, w);
							break;
						}
					}
				} %>
				<% if (request.getAttribute("result_del") != null) {
					for (int i = 0; i < wifies.size(); i++) {
						Wife w = wifies.get(i);
						if (w.getMaSV().equals((String)request.getAttribute("MaSV"))) {
							wifies.remove(i);
							break;
						}
					}
				} %>
				<% if (request.getAttribute("result_new") != null) {
					wifies.add(new Wife(
							(String)request.getAttribute("MaSV"), 
							(String)request.getAttribute("Hoten"),
							(String)request.getAttribute("Gioitinh"),
							(String)request.getAttribute("Khoa")
							));
				} %>
			<% } else if (request.getAttribute("new") != null) { %>
				<h2>No result is matched!</h2>
				
				<% request.removeAttribute("new"); %>
			<% } %>
			
			<table>
				<thead>
					<h1>Sinh vien</h1>
				</thead>
				<tr>
					<th>MaSV</th>
					<th>Hoten</th>
					<th>Gioitinh</th>
					<th>Khoa</th>
					<th>Update</th>
					<th>Delete</th>
				</tr>
				
				<%
					for (int i = 0; i < wifies.size(); i++) { 
						String MaSV = wifies.get(i).getMaSV();
						String Hoten = wifies.get(i).getHoten();
						String Gioitinh = wifies.get(i).getGioitinh();
						String Khoa = wifies.get(i).getKhoa();
						//int role = wifies.get(i).getRole(); 
				%>
				<tr>
					<td><%= MaSV %></td>
					<td><%= Hoten %></td>
					<td><%= Gioitinh %></td>
					<td><%= Khoa %></td>
					<td><a href="/hocJSP/update.jsp?roleSS=<%= roleSS %>&MaSV=<%= MaSV %>&Hoten=<%= Hoten %>&Gioitinh=<%= Gioitinh %>&Khoa=<%= Khoa %>">update</a></td>
					<td><a href="/hocJSP/delete.jsp?roleSS=<%= roleSS %>&MaSV=<%= MaSV %>&Hoten=<%= Hoten %>&Gioitinh=<%= Gioitinh %>&Khoa=<%= Khoa %>">delete</a></td>
				</tr>
				<% } %>
			</table>
		<% } %>
	</div>
	
	<script>
		function addNew() {
			window.location("/hocJSP/new.jsp");
		}
	</script>
</body>
</html>