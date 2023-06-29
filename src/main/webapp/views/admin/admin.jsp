<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<c:if test="${account.role == 0 }">
<h1 style="text-align: center;"><i class="fa-sharp fa-solid fa-screwdriver-wrench"></i> <s:message code="label.home.qLyPro" /></h1>
<br>
<div class="btnThem"><button type="button" class="btn btn-info"><a href="${pageContext.request.contextPath }/admin/add"><i class="fa-solid fa-circle-plus"></i> Thêm sản phẩm</a></button></div>
<br>
<table class="table">
<tr>
<td>ID</td>
<td>Ảnh</td>
<td>Tên sản phẩm</td>
<td>Giá</td>
<td>Số lượng</td>
<td>Chức năng</td>
</tr>
<c:forEach items="${listProduct }" var="p">
<tr>
<td>${p.id }</td>
<td><img src="${pageContext.request.contextPath}/views/img/${p.anh}" height="100" width="100"></td>
<td>${p.tieuDe }</td>
<td>${p.gia }</td>
<td>${p.soLuong }</td>
 <td>
            <button type="button" class="btn btn-success btnSua"> <a href="${pageContext.request.contextPath}/admin/update/${p.id }"><i class="fa-solid fa-wrench"></i> Sửa</a></button>
<%--             <button type="button" class="btn btn-secondary btnSua" data-toggle="modal" data-target="#exampleModal"> <a href="admin/chitiet?sp=${p.id }"><i class="fa-solid fa-circle-info"></i> Xem chi tiet</a></button>
 --%>            <button type="button" class="btn btn-danger btnSua" ><a href="${pageContext.request.contextPath}/admin/delete/${p.id }"><i class="fa-solid fa-trash"></i> Xóa</a></button>
</td>
</tr>
</c:forEach>

  <!-- Modal -->
  
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
<c:if test="${account == null ||account.role == 1}">
<h1>Bạn không có quyền truy cập chức năng này !</h1>
</c:if>
