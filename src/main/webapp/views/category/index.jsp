<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<c:if test="${account.role == 0 }">
<h1 style="text-align: center;"> <i class="fa-solid fa-file-invoice"></i> <s:message code="label.home.qLyCate" /></h1>
<br>
<div class="btnThem"><button type="button" class="btn btn-secondary"><a href="${pageContext.request.contextPath }/category/add"><i class="fa-solid fa-circle-plus"></i> Thêm category</a></button></div>
<br>
<table class="table">
<tr>
<td>ID</td>
<td>Tên Category</td>
<td>Chức năng</td>
</tr>
<c:forEach items="${listCategory }" var="p">
<c:if test="${p.trangThai == 0 }">
<tr>
<td>${p.id }</td>
<td>${p.ten }</td>
 <td>
      <button type="button" class="btn btn-danger btnSua"> <a href="${pageContext.request.contextPath}/category/update/${p.id }"><i class="fa-solid fa-wrench"></i> Sửa</a></button>
      <button type="button" class="btn btn-warning btnSua" ><a href="${pageContext.request.contextPath}/category/delete/${p.id }"><i class="fa-solid fa-trash"></i> Xóa</a></button>
 </td>
</tr>
</c:if>
</c:forEach>
</table>
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
<c:if test="${account == null ||account.role == 1 }">
<h1>Bạn không có quyền truy cập chức năng này !</h1>
</c:if>

