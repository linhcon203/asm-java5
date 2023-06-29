<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<br>
<br>
<c:if test="${account.role == 0 }">
<div class="container">
    <h1>Thêm user mới</h1>
    <p style="color: red">${message }</p>
   <form:form modelAttribute="user" action="${pageContext.request.contextPath}/users/add" method="POST">
 
        <label for="exampleInputEmail1">Username * :</label>
          <form:input type="text" class="form-control"  id="exampleInputEmail1" placeholder="Nhập username " name="username" path="username"/>
             <small><form:errors path="username" class="error"/></small><br>
        <label for="exampleInputEmail1">Password * :</label>
          <form:input type="text" class="form-control"  id="exampleInputEmail1" placeholder="Nhập password " name="password" path="password"/>
             <small><form:errors path="password" class="error"/></small><br>
       <label for="exampleInputEmail1">Email * :</label>
          <form:input type="text" class="form-control" id="exampleInputEmail1" placeholder="Nhập email " name="email" path="email" />
             <small><form:errors path="email" class="error"/></small><br>
       <label for="exampleInputEmail1">Vai trò * :</label>
    <form:select class="form-control" id="exampleFormControlSelect1" name="role" path="role">
        <option value="0">Admin</option>
        <option value="1">Thành viên</option>
      </form:select>
      
      <br>
      <button type="submit" class="btn btn-danger"><i class="fa-solid fa-plus"></i> Thêm User</button>
 </div>
   </form:form>
     
<br>
</c:if>
<c:if test="${account == null ||account.role == 1 }">
<h1>Bạn không có quyền truy cập chức năng này !</h1>
</c:if>
