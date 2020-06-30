<%-- 
    Document   : Signup
    Created on : Mar 20, 2020, 1:01:44 PM
    Author     : 794473 - Amitoj Singh
    Author     : 749300 - Lakhwinder Singh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" 
              integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
        <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>

        <link rel="stylesheet" type="text/css" href="./style/logincss.css" />
        <title>Signup</title>
    </head>
    <body>
       	<section id="hire">
            <h2 id="title">Cutey & Coolty</h2><hr>
            <h4>Sign Up</h4>

            <Form id="signup-form" action="signup" method="post">

                <div class="field text-box">
                    <Input  id="register-input-box" name="fname"type="text"
                            placeholder="First name" required>
                    <label for="register-input-box">First name</label>
                    <span class="ss-icon">check</span>
                </div>

                <div class="field text-box">
                    <Input id="register-input-box" name="lname" type="text"
                           placeholder="Last name" required>
                    <label for="register-input-box">Last name</label>
                    <span class="ss-icon">check</span>
                </div>

                <div class="field email-box">
                    <Input id="register-input-box" name="email" type="email"
                           placeholder="Email" required>
                    <label for="register-input-box">Email</label>
                    <span class="ss-icon">check</span>
                </div>

                <div class="field text-box">
                    <Input id="register-input-box" name="password" type="password" 
                           placeholder="password" required>
                    <label for="register-input-box">Password</label>
                    <span class="ss-icon">check</span>
                </div>

                <div class="field text-box">
                    <Input id="register-input-box" name="phone" type="text" 
                           placeholder="0001112222" required>
                    <label for="register-input-box">Phone</label>
                    <span class="ss-icon">check</span>
                </div>

                <div class="field password-box">
                    <Input  id="register-input-box" name="address" type="text" 
                            placeholder="address" required>
                    <label for="register-input-box">Address</label>
                    <span class="ss-icon">check</span>
                </div>

                <div class="field text-box">
                    <Input id="register-input-box" name="postalcode" type="text" 
                           pattern="[A-Za-z][0-9][A-Za-z][0-9][A-Za-z][0-9]" placeholder="postal code" required>
                    <label for="register-input-box">Postal Code</label>
                    <span class="ss-icon">check</span>
                </div>

                <div class="field text-box">
                    <Input id="register-input-box" name="city" type="text" 
                           placeholder="city" required>
                    <label for="register-input-box">City</label>
                    <span class="ss-icon">check</span>
                </div>

                <div class="field text-box">
                    <select name="province" id="register-input-box">
                        <c:forEach items="${provList}"  var="prov">
                            <option value="${prov.provinceID}">${prov.provinceName}</option> 
                        </c:forEach>

                    </select>
                    <label for="register-input-box">Province</label>
                    <span class="ss-icon">check</span>
                </div>
                <br>
                <input type="hidden" name="action" value="add" />

                <input type="submit"  value="REGISTER" 
                       id="register-button"/>
                <br>
                <br>
                <div class="text-center">
                    <a href="/login">Log In</a>
                    <span class="p-2">|</span>
                    <a href="/forgot">Forgot Password</a>
                </div>

            </form>
        </section>

        <c:if test="${error ne null}">
            <div class="error-message">
                <span>${error}</span>
            </div>
        </c:if>
    </body>
    <!-- Footer -->
    <footer class="page-footer font-small ">

        <!-- Copyright -->
        <div class="footer-copyright text-center py-3"> © 2020 Cutey & Coolty
        </div>
        <!-- Copyright -->

    </footer>
    <!-- Footer -->
</html>
