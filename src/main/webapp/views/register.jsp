<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
      <c:if test="${account == null}">
       <section class="vh-100 register" style="background-color: #fff;">
            <div class="container py-5 h-100">
              <div class="row d-flex justify-content-center align-items-center h-100">
                <div class="col col-xl-10">
                  <div class="card" style="border-radius: 1rem;">
                    <div class="row g-0">
                      <div class="col-md-6 col-lg-5 d-none d-md-block login">
                        <img src="./views/img/signup.jpg"
                          alt="login form" class="img-fluid" style="border-radius: 1rem 0 0 1rem;" />
                      </div>
                      <div class="col-md-6 col-lg-7 d-flex align-items-center">
                        <div class="card-body p-4 p-lg-5 text-black">
          			
          <form:form modelAttribute="register" action="${pageContext.request.contextPath }/register" method="POST">
          					
                            <div class="d-flex align-items-center mb-3 pb-1">
                              <span class="h1 fw-bold mb-0"> <h1 class="giua"><i class="fa-solid fa-square-plus"></i> Đăng Ký</h1></span>
                            </div>
                            <div class="form-outline mb-4">
                                <label class="form-label" for="form2Example17"><i class="fa-solid fa-user"></i> Tài khoản</label>
                              <form:input type="text" id="form2Example17" class="form-control form-control-lg" name="username" path="username" />
                               <small><form:errors path="username" class="error"/></small>
                            </div>
          
                            <div class="form-outline mb-4">
                                <label class="form-label" for="form2Example27"><i class="fa-solid fa-lock"></i> Mật khẩu</label>
                              <form:password  id="form2Example27" class="form-control form-control-lg" name="password" path="password"/>
                               <small><form:errors path="password" class="error"/></small>
                              
                            </div>
                            <div class="form-outline mb-4">
                                <label class="form-label" for="form2Example27"><i class="fa-solid fa-repeat"></i> Nhập lại mật khẩu</label>
                              <form:password  id="form2Example27" class="form-control form-control-lg" name="re-password" path="repass" />
                               <small><form:errors path="repass" class="error"/></small>
                            </div>
                            <div class="form-outline mb-4">
                                <label class="form-label" for="form2Example17"><i class="fa-solid fa-envelope"></i> Email</label>
                              <form:input id="form2Example17" class="form-control form-control-lg" name="email"  path="email"/>
                               <small><form:errors path="email" class="error"/></small>
                            </div>
                            <div class="form-outline mb-4">
                              <input type="checkbox" name="checkbox"/> Tôi đồng ý với các điều khoản trên!
                            </div>
                            <div class="pt-1 mb-4">
                              <button class="btn btn-dark btn-lg btn-block" type="submit"><i class="fa-solid fa-square-plus"></i> Đăng Ký</button>
                            </div>
                            <p class="mb-5 pb-lg-2 l" style="color: #121216;">
							Bạn đã có tài khoản? <a href="login"
							style="color: blue;">Đăng nhập.</a>
							</p>
                          </form:form>
                        </div>
                      </div>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </section>
      </c:if>
      <c:if test="${account != null }">
      <h1>Vui lòng đăng xuất trước khi thực hiện chức năng này !</h1>
      </c:if>
</br>
</br>