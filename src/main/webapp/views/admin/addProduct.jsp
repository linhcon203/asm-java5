<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<c:if test="${account.role == 0 }">
<div class="container">
    <h1>Thêm sản phẩm mới</h1>
    <form:form modelAttribute="data" action="${pageContext.request.contextPath}/admin/add" method="post" enctype="multipart/form-data">
 
                <div class="form-group">
                  <label for="exampleFormControlFile1"> Ảnh Sản Phẩm <span style="color: red">*</span>:</label>
                  <input type="file" class="form-control-file" id="fileUpload" name="anh"/>
                </div>
                <label for="exampleInputEmail1">Tên Sản Phẩm <span style="color: red">*</span>:</label>
    <form:input type="text" class="form-control" name="tieude" id="exampleInputEmail1" placeholder="Nhập tên sản phẩm" path="tieuDe" />
      <small><form:errors path="tieuDe" class="error"/></small>
    
    <label for="exampleInputEmail1" required>Số Lượng Sản Phẩm <span style="color: red">*</span>:</label>
    <form:input type="number" class="form-control" id="exampleInputEmail1" name="soluong" placeholder="Nhập số lượng sản phẩm" path="soLuong" />
          <small><form:errors path="soLuong" class="error"/></small>
    
    <label for="exampleInputEmail1" required>Giá Sản Phẩm <span style="color: red">*</span>:</label>
    <form:input type="number" class="form-control" id="exampleInputEmail1" placeholder="Nhập giá bán sản phẩm" name="gia" path="gia" />
          <small><form:errors path="gia" class="error"/></small>
    
    <label for="exampleInputEmail1">Giảm Giá (%)</label>
    <form:input type="number" class="form-control" id="exampleInputEmail1" placeholder="Nhập % giảm giá cho sản phẩm" value="0" name="giamGia" path="giamGia" />
       <small><form:errors path="giamGia" class="error"/></small>
     <label for="exampleInputEmail1">Phân Loại  <span style="color: red">*</span>:</label>
    <form:select class="form-control" id="exampleFormControlSelect1" name="phanloai" path="phanLoai">
    <c:forEach items="${list }" var="p">
    <option value="${p.id }">${p.ten } </option>
    </c:forEach>
        
      </form:select>
      <label for="exampleInputEmail1">Kiểu Size  <span style="color: red">*</span>:</label>
      <br>
            
                  <form:checkbox  path="kichThuoc"  value="S"/>S
                  <form:checkbox  path="kichThuoc"  value="M"/>M
                  <form:checkbox  path="kichThuoc"  value="L"/>L
                  <form:checkbox  path="kichThuoc"  value="XL"/>XL
                  <form:checkbox  path="kichThuoc"  value="XXL"/>XXL
    
         

      <br>
      <label for="exampleInputEmail1">Mô Tả Sản Phẩm <span style="color: red">*</span>:</label>
      <form:input type="text" class="form-control" id="exampleInputEmail1" placeholder="Nhập mô tả sản phẩm" name="mota" path="moTa" />
         <small><form:errors path="moTa" class="error"/></small>
      <label for="exampleInputEmail1">Chất Liệu Sản Phẩm <span style="color: red">*</span>:</label>
      <form:input type="text" class="form-control" id="exampleInputEmail1" placeholder="Nhập chất liệu sản phẩm" name="chatlieu" path="chatLieu" />
               <small><form:errors path="chatLieu" class="chatLieu"/></small>
      <label for="exampleInputEmail1">Thiết kế Sản Phẩm <span style="color: red">*</span>:</label>
      <form:input type="text" class="form-control" id="exampleInputEmail1" placeholder="Nhập thiết kế sản phẩm" name="thietke" path="thietKe" />
               <small><form:errors path="thietKe" class="error"/></small>
      <br>
      <button type="submit" class="btn btn-primary"><i class="fa-solid fa-plus"></i> Thêm Sản Phẩm</button>
  </div>
  </div>
              </form:form>
        </div>
<br>
</c:if>
<c:if test="${account == null ||account.role == 1 }">
<h1>Bạn không có quyền truy cập chức năng này !</h1>
</c:if>

<!-- <script>

    const image = document.querySelector("img"),
    input = document.querySelector("input");

    input.addEventListener("change" , () => {
        image.src = URL.createObjectURL(input.files[0]);
    });
</script> -->
