<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<c:if test="${account.role == 0 }">
<h1 style="text-align: center;"><i class="fa-solid fa-users-line"></i><s:message code="label.home.qLyU" /></h1>
<br>
<div class="btnThem"><button type="button" class="btn btn-secondary"><a href="${pageContext.request.contextPath }/users/add"><i class="fa-solid fa-circle-plus"></i> Thêm user</a></button></div>
<br>
<table class="table">
<tr>
<td>Username</td>
<td>Password</td>
<td>Email</td>
<td>Vai trò</td>
<td>Chức năng</td>
</tr>
<c:forEach items="${listAccount }" var="p">
<c:if test="${p.role != 2}">
<tr>
<td>${p.username }</td>
<td>${p.password }</td>
<td>${p.email }</td>
<td><c:if test="${p.role == 0 }">Admin</c:if><c:if test="${p.role == 1 }">Thành viên</c:if></td>
        <td>

            <button type="button" class="btn btn-success btnSua"> <a href="${pageContext.request.contextPath}/users/update/${p.username }"><i class="fa-solid fa-wrench"></i> Sửa</a></button>
            <button type="button" class="btn btn-warning btnSua" ><a href="${pageContext.request.contextPath}/users/delete/${p.username }"><i class="fa-solid fa-trash"></i> Xóa</a></button>
        </td>
</tr>
</c:if>
</c:forEach>
</table>
<br>
 <%-- <div class="aa">
 	
            <nav aria-label="Page navigation example">
			<ul class="pagination">
				<li class="page-item"><a class="page-link" href="users">1</a></li>
				<c:forEach begin="2" end="${count }" var="i">
					<li class="page-item"><a class="page-link" href="?page=${i}">${i}</a></li>
				</c:forEach>
				</ul>
				</nav>
 
 </div> --%>
 <div>
			<ul class="pagination">
				<c:forEach begin="1" end="${count}" var="i">
					<li class="page-item">
						<a  href="${pageContext.request.contextPath}?pageNum=${i}" class="page-link">${i }</a>
					</li>
				</c:forEach>
			</ul>
		</div>
				
				
</c:if>
