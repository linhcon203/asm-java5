<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %> 
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <br>
   <div class="container" >
    <div class="row">
        <div class="col-md-6">
            <div id="carouselExampleIndicators" class="carousel slide detail-giantrai" data-ride="carousel">
                <ol class="carousel-indicators">
                  <li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
                  <li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
                  <li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
                </ol>
                <div class="carousel-inner">
                  <div class="carousel-item active anhsp-detail">
                    <img class="d-block w-100" src="${pageContext.request.contextPath}/views/img/${p.anh}" alt="First slide">
                  </div>
                  <div class="carousel-item anhsp-detail">
                    <img class="d-block w-100" src="${pageContext.request.contextPath}/views/img/${p.anh}" alt="Second slide">
                  </div>
                  <div class="carousel-item anhsp-detail">
                    <img class="d-block w-100" src="${pageContext.request.contextPath}/views/img/${p.anh}" alt="Third slide">
                  </div>
                </div>
                <a class="carousel-control-prev" role="button" data-slide="prev">
                 
                  <span class="sr-only">Previous</span>
                </a>
                <a class="carousel-control-next" role="button" data-slide="next">
                 
                  <span class="sr-only">Next</span>
                </a>
              </div>
        </div>
        <div class="col-md-6">
         <c:if test="${not empty message}">
   						<input type="hidden" id="message" value="${message }">
                        <input type="hidden" id="type" value="${type }">
						</c:if>
        	<form:form modelAttribute="gioHang" action="${pageContext.request.contextPath }/detail/${p.id }" method="POST">
        	<input type="hidden" name="username" value="${account.username }">
        	<input type="hidden" name="idProduct" value="${p.id }">
            <div class="tieude">${fn:toUpperCase(p.tieuDe) }</div>
          
            <div class="detail"><b>Tình trạng :</b> 
           <c:if test="${p.soLuong > 0}"><b style="color: rgb(16, 175, 16);">Còn hàng</b></c:if>
            <c:if test="${p.soLuong < 1}"><b style="color: rgb(206, 43, 43);">Hết hàng</b></c:if>
         
            </div>
            <div class="inline detail-giamgia"><div class="gia inline"> <c:if test="${p.giamGia > 0 }"><fmt:formatNumber>${p.gia - (p.gia * (p.giamGia /100))}</fmt:formatNumber> VNĐ  </c:if>
              <div class="gia inline" ><c:if test="${p.giamGia < 1 }"><fmt:formatNumber>${p.gia }</fmt:formatNumber> VNĐ </c:if></div><p class="gach"><c:if test="${p.giamGia > 0 }">- <fmt:formatNumber>${p.giamGia}</fmt:formatNumber> % </c:if></p></div></div>
            <div class="detail-indam"><span>Kích thước :</span>
                <br>
                <c:forEach items="${p.kichThuoc }" var="kt">
               <input type="radio" name="kichThuoc" value="${kt }">${kt }</>
                </c:forEach>
                 
            </div>
            <div class="detail-indam"><span>Mô tả :</span> ${p.moTa }</div>
            <div class="detail-indam"><span>Chất liệu :</span> ${p.chatLieu }</div>
            <div class="detail-indam"><span>Thiết kế :</span> ${p.thietKe }</div>
            <br>
            <div class="themvaogio">
                <button class="nutthemgio-detail" type="submit"><a href="#"><i class="fa-sharp fa-solid fa-cart-plus"></i><p class="gian">Thêm vào giỏ hàng</p></a></button>
            </div>
            <br>
        	</form:form>
        </div>
    </div>
   </div>
   <br>
   <br>
