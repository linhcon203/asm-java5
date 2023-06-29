<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


 <c:if test="${account == null }">
 <section class="vh-100" style="background-color: rgb(255, 255, 255);">
            <div class="container py-5 h-100">
              <div class="row d-flex justify-content-center align-items-center h-100">
                <div class="col col-xl-10">
                  <div class="card" style="border-radius: 1rem;">
                    <div class="row g-0">
                      <div class="col-md-6 col-lg-5 d-none d-md-block login">
                        <img src="./views/img/signin.jpg"
                          alt="login form" class="img-fluid" style="border-radius: 1rem 0 0 1rem;" />
                      </div>
                      <div class="col-md-6 col-lg-7 d-flex align-items-center">
                        <div class="card-body p-4 p-lg-5 text-black">
                       <%--  <c:if test="${not empty messageLogin}">
   							 <input type="hidden" id="message" value="${messageLogin }">
                        <input type="hidden" id="type" value="${typeLogin }">
						</c:if> --%>
                                           
                          <form:form modelAttribute="lo" action="${pageContext.request.contextPath }/login" method="POST">
          
                            <div class="d-flex align-items-center mb-3 pb-1">
                              <span class="h1 fw-bold mb-0"> <h1 class="giua"> <i class="fas fa-cubes fa-2x me-3" style="color: #ff6219;"></i> Đăng Nhập</h1></span>
                              
                            </div>
								<div class="error">${message }</div>                
                            <div class="form-outline mb-4">
                                <label class="form-label" for="form2Example17"><i class="fa-solid fa-user"></i> Tài khoản</label>
                              <form:input id="form2Example17" class="form-control form-control-lg" name="username" value="${username }" path="username"/>
                              <small><form:errors path="username" class="error"/></small>
                            </div>
          
                            <div class="form-outline mb-4">
                                <label class="form-label" for="form2Example27"><i class="fa-solid fa-lock"></i> Mật khẩu</label>
                              <form:password id="form2Example27" class="form-control form-control-lg" name="password" value="${password }" path="password"/>
                              <small><form:errors path="password" class="error"/></small>
                              
                            </div>
                             <div class="form-outline mb-4">
                              <input type="checkbox" name="checkbox"> Remember me ?    <a class="small text-muted i" href="forget">Forgot Password?</a>
                              
                            </div>
          					
                            <div class="pt-1 mb-4">
                              <button class="btn btn-dark btn-lg btn-block" type="submit"><i class="fa-solid fa-arrow-right-to-bracket"></i> Đăng Nhập</button>
                            </div>
          
                         
                            <p class="mb-5 pb-lg-2 l" style="color: #393f81;">Bạn chưa có tài khoản? <a href="register"
                                style="color: blue;">Đăng ký ngay</a></p>
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
 <c:if test="${account != null}">
<h1>Vui lòng đăng xuất trước khi thực hiện chức năng này !</h1>
</c:if>
<br>

