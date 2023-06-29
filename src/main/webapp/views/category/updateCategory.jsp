<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<c:if test="${account.role == 0 }">
<div class="container">
    <h1>Sửa Category </h1>
  
    <form:form action="${pageContext.request.contextPath}/category/update" modelAttribute="cate" method="post">
       <!--      <label for="exampleInputEmail1">Id * :</label> -->
    		<form:input type="hidden" class="form-control"  id="exampleInputEmail1"  name="id" value="${cate.id }" readonly="readonly" path="id"/>
            <label for="exampleInputEmail1">Tên category * :</label>
    		<form:input type="text" class="form-control"  id="exampleInputEmail1" placeholder="Nhập tên " name="ten" value="${cate.ten }"  path="ten"/>
    		   <small><form:errors path="ten" class="error"/></small>
    
      <br>
      <button type="submit" class="btn btn-danger"><i class="fa-solid fa-plus"></i> Sửa Category</button>
    </form:form>
      </div>

<br>
</c:if>
<c:if test="${account == null ||account.role == 1 }">
<h1>Bạn không có quyền truy cập chức năng này !</h1>
</c:if>
