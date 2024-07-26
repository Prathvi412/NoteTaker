<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
   <%@include file="all_js_css.jsp" %>
<title>Add Notes</title>
</head>
<body>
<div class="container ">
   	<%@include file="navbar.jsp" %>
   <br>
   <h1>please fill your note detail</h1>
   
   <br>
   <form action="SaveNoteServlet" method="post">
  <div class="form-group">
    <label for="title">Note title</label>
    <input 
   	required
    type="text" 
    class="form-control"
     id="title" 
     name="title"
     aria-describedby="emailHelp" 
     placeholder="Enter here"/>
    </div>
  <div class="form-group">
    <label for="content">Note Content</label>
    <textarea
    name="content"
     id="content"
     
    placeholder="Enter your content here"
    class="form-control"
    style="height:200px; "
    ></textarea>
     </div>
 <div class="container text-center">
  <input type="submit" value="Add" class="btn btn-primary"/>
 </div>
 
</form>
   </div>
</body>
</html>