<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<div class="giua">
	<img src="./views/img/logo3.png" width="90px" height="50px">
	<h2> <s:message code="label.home.sanphammew" /> </h2>
</div>
<br>
<div class="container">
	<div class="row">
		<c:forEach items="${listProduct}" var="p">
			<div class="col-md-3 col-6">
				<div class="thumbnail xoagach">
					<a href="detail/${p.id }">
						<div class="anhsp">
							<c:if test="${p.giamGia > 0 }">
								<span class="giamgia1">- ${p.giamGia}%</span>
							</c:if>
							<img src="${pageContext.request.contextPath}/views/img/${p.anh}"
								alt="Lights" style="width: 100%">
						</div>
						<div class="tensp">${fn:toUpperCase(p.tieuDe)}</div>
					</a>
					<div class="line">
						<p class="money1">
							<c:if test="${p.giamGia < 1 }">
								<fmt:formatNumber>${p.gia}</fmt:formatNumber> VNĐ</c:if>
						</p>
						<p class="money1">
							<c:if test="${p.giamGia > 0 }">
								<fmt:formatNumber>${p.gia - (p.gia * (p.giamGia /100))}</fmt:formatNumber> VNĐ</c:if>
						</p>
						<p class="gach">
							<c:if test="${p.giamGia >0 }">
								<fmt:formatNumber>${p.gia}</fmt:formatNumber> VNĐ</c:if>
						</p>

					</div>
					<br>
					<div>
						<button class="nutthemgio">
							<a href="detail/${p.id}"><i class="fa-solid fa-cart-shopping"></i>
							<p class="gian">Mua Ngay</p></a>
						</button>
					</div>

				</div>
				<div class="ribbon-wrap">
					<!--  <div class="ribbon2"><i class="fa-solid fa-fire"></i> New</div> -->
				</div>
			</div>
		</c:forEach>
	</div>
</div>
<%-- 
	<div class="aa">
			<nav aria-label="Page navigation example">
		<ul class="pagination">
			<li class="page-item"><a class="page-link" href="index">1</a></li>
			<c:forEach begin="2" end="${count }" var="i">
				<li class="page-item"><a class="page-link" href="?page=${i }">${i}</a></li>
			</c:forEach>
		</ul>
	</nav>
	
	</div> --%>
<div>
	<ul class="pagination">
		<c:forEach begin="1" end="${count}" var="i">
			<li class="page-item"><a
				href="${pageContext.request.contextPath}?pageNum=${i}"
				class="page-link">${i }</a></li>
		</c:forEach>
	</ul>
</div>

