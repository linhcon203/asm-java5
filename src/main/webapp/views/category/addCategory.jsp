<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<br>
<br>

<c:if test="${account.role == 0 }">
<div class="container">
    <h1>Thêm Category mới</h1>
    <p style="color: red">${message }</p>
    <form:form modelAttribute="cate" action="${pageContext.request.contextPath}/category/add" method="POST">
 
   <label for="exampleInputEmail1">Tên Category * :</label>
    <form:input type="text" class="form-control"  id="exampleInputEmail1" placeholder="Nhập tên category" name="ten" path="ten"/>
       <small><form:errors path="ten" class="error"/></small>
       
      <br>
      <br>
      <button type="submit" class="btn btn-danger"><i class="fa-solid fa-plus"></i> Thêm Category</button>
  </div>
  </div>
              </form:form>
        </div>
<br>
</c:if>
<c:if test="${account == null ||account.role == 1 }">
<h1>Bạn không có quyền truy cập chức năng này !</h1>
</c:if>
