<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %> 
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<c:if test="${account == null }">
	<h3>Bạn không có quyền truy cập chức năng này</h3>
</c:if>
<c:if test="${account != null }">
	<div class="container">
	<input type="hidden" value="${account.username }" name="userGH">
	
    <h1 class="giua"><i class="fa-solid fa-cart-plus"></i> <s:message code="label.home.cart" /> </h1>
    <br>
    <div class="giohang">
        <table class="table">
            <thead>
              <tr>
                <th scope="col" colspan="5.5">Tên sản phẩm</th>
               	<th scope="col" colspan="1">Size</th>
                <th scope="col" colspan="1">Đơn giá</th>
                <th scope="col" colspan="1">Số lượng</th>
                <th scope="col" colspan="1">Thành tiền</th>
                <th scope="col" colspan="1">Acction</th>
              </tr>
            </thead>
            <tbody>
            <c:if test="${fn:length(listCart) == 0}">
            <tr>
            <td> Chưa có sản phẩm nào!</td>
            </tr>
            </c:if>
              <c:if test="${fn:length(listCart) > 0}">
              <c:forEach items="${listCart }" var="p">
               <tr>
                <th colspan="5.5"><div class="cart-img"><img src="${pageContext.request.contextPath }/views/img/${p.product.anh}">${p.product.tieuDe}</div></td>
               	<td scope="col" colspan="1">${p.kichThuoc}</td>
               	<td scope="col" colspan="1">${p.donGia}</td>
           
                <td colspan="1"><span><a style="color:red;" href="cart/giam?id=${p.product.id }&kichThuoc=${p.kichThuoc}"><i class="fa-solid fa-minus"></i></a></span> <span>${p.soLuong }</span> <span ><a style="color:green;" href="cart/them?id=${p.product.id }&kichThuoc=${p.kichThuoc}"><i class="fa-solid fa-plus"></i></a></span></td>  
                <td colspan="1">${p.soLuong * p.donGia}</td>
               <td class="xoa" colspan="1"><a style="color: black" href="${pageContext.request.contextPath}/cart/delete?id=${p.product.id }&kichThuoc=${p.kichThuoc}"><i class="fa-solid fa-trash"></i></a></td>
               </tr>
               
              </c:forEach>
              </c:if>
            </tbody>
          </table>
    </div>
    <br>
    <div><h4>*Thông tin giao hàng:</h4> 
<%--     <c:if test="${not empty message}">
    <input type="hidden" id="message" value="${message}">
    <input type="hidden" id="type" value="${type }">
    </c:if> --%>
    
 
	<form:form modelAttribute="gioHang" action="${pageContext.request.contextPath }/cart/thanhtoan" method="POST">
	  <div class="tt"> <form:input type="text" name="tennguoinhan" placeholder="Tên người nhận" path="tennguoinhan"/></div>
	            <small><form:errors path="tennguoinhan" class="error"/></small><br>
	  
 		<div> <form:input type="text" name="sdt" placeholder="Số điện thoại" path="sdt"/></div>
 		          <small><form:errors path="sdt" class="error"/></small><br>
 		
        <div> <form:input type="text" name="diachi" placeholder="Địa chỉ" path="diachi"/></div>
                  <small><form:errors path="diachi" class="error"/></small><br>
        
  		<div> <textarea name="ghichu" rows="2" cols="23" placeholder="Ghi chú (tùy chọn)"></textarea></div>
       
      <div class="thanhtien">Tổng tiền : <span><fmt:formatNumber>${tongTien}</fmt:formatNumber> VNĐ</span></div><br>
      <br>
      <div class="nutthanhtoan">
        <button type="submit" class="nutthemgiott"><a href="#"><i class="fa-brands fa-amazon-pay"></i><p class="gian">Thanh Toán</p></a></button>
      </div>
	</form:form>
  	   </div>
  	   
      <div class="nutthanhtoan1">
        <button class="nutthemgiott1"><a href="${pageContext.request.contextPath }/index"><i class="fa-solid fa-angle-left"></i><p class="gian">Quay lại</p></a></button>
      </div>
      <br>
      </div>
      	
 </c:if>
     
      <br>

