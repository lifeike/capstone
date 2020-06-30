<%-- 
    Document   : customerlist
    Created on : Feb 24, 2020, 12:36:55 PM
    Author     : 794473 - Amitoj Singh
    Author     : 749300 - Lakhwinder Singh 
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <link href="https://fonts.googleapis.com/css?family=Ubuntu&display=swap"rel="stylesheet"/>
        <link rel="stylesheet" type="text/css" href="./style/index.css" />
        <!-- Bootstrap CSS -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script> 

        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
        <title>Customer List</title>
    </head>
    <body>
        <header  style="padding-top: 3em;">
            <div>
                <h1 class="col-lg" style="font-family: 'Ubuntu', sans-serif; text-align: center">
                    Cutey N' Coolty
                </h1>
            </div>
            <div class="row">
                <p class="col-sm">
                    <a class="float-right p-2 text-muted" >Hello, ${fname} ${lname}</a>
                </p>
            </div>
            <!--Navbar-->
            <nav class="navbar navbar-expand-lg navbar-dark bg-dark primary-color">
                <!-- Navbar brand -->
                <a class="navbar-brand navbar-dark" href="/admin">C&C</a>
                <!-- Collapse button -->
                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#basicNav"
                        aria-controls="basicNav" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <!-- Collapsible content -->
                <div class="collapse navbar-collapse" id="basicNav">
                    <!-- Links -->
                    <ul class="navbar-nav mr-auto p-1  bg-dark">
                        <li class="nav-item active">
                            <a class="nav-link" href="/admin">Home
                                <span class="sr-only">(current)</span>
                            </a>
                        </li>

                        <li class="nav-item ">
                            <a class="nav-link" href="/inactive">Inactive Customers
                            </a>
                        </li>
                    </ul>
                    <!-- Links -->

                    <div class="md-form my-0">
                        <button class="btn btn-danger" onclick="window.location.href = 'login';">
                            Logout</button>
                    </div>

                </div>
                <!-- Collapsible content -->
            </nav>
            <!--/.Navbar-->
        </header>
        <br>


        <div id="body-main">
            <h3 id="heading">CUSTOMER LIST</h3>
            <br>

            <c:if test="${edit ne true}">
                <table class="table table-bordered">

                    <thead class="thead-dark">

                        <tr>
                            <th>EMAIL</th>
                            <th>FIRST NAME</th>
                            <th>LAST NAME</th>
                            <th>PHONE</th>
                            <th>ADDRESS</th>
                            <th>POSTAL CODE</th>
                            <th>CITY</th>
                            <th>PROVINCE</th>
                            <th>ACTIVE</th>
                            <th>ROLE</th>
                            <th>EDIT</th>
                        <tr>
                    </thead>
                    <tbody>

                        <c:forEach items="${userList}" var="c" >

                            <tr>

                                <td align="center">
                                    ${c.email}
                                </td>

                                <td align="center">
                                    ${c.firstName}
                                </td>

                                <td align="center">
                                    ${c.lastName}
                                </td>

                                <td align="center">
                                    ${c.phone}
                                </td>

                                <td align="center">
                                    ${c.address}
                                </td>

                                <td align="center">
                                    ${c.postalCode}
                                </td>

                                <td align="center">
                                    ${c.city}
                                </td>

                                <td align="center">
                                    ${c.province.provinceName}
                                </td>


                                <td align="center">
                                    ${c.status}
                                </td>

                                <td align="center">
                                    ${c.role.roleDescription}
                                </td>

                                <td>
                                    <form action="customer-list">
                                        <input type="hidden" name="action" value="modify">
                                        <input type="hidden" name="modifyID" value='${c.email}'>
                                        <input  type="submit" value="Edit"  class="btn-lg btn-dark btn-block" >
                                    </form>
                                </td>

                            </tr>

                        </c:forEach> 

                    </tbody>

                </table>
            </c:if>

            <c:if test="${edit eq true}">
                <div class="container">
                    <div class="col-md-12">
                        <div class="card">
                            <div class="card-body">
                                <div class="row">
                                    <div class="col-md-12">
                                        <form action="customer-list" method="post" id="custform">

                                            <div class="form-group row">
                                                <label for="email" class="col-2 col-form-label"><h4>Email</h4></label>
                                                <div class="col-10">
                                                    <input class="form-control" type="email" name="email" value="${pc.email}"  />
                                                </div>
                                            </div>
                                            <div class="form-group row">

                                                <label for="first_name" class="col-2 col-form-label"><h4>First name</h4></label>
                                                <div class="col-10">
                                                    <input class="form-control" type="text" name="fname" value="${pc.firstName}"  />
                                                </div>
                                            </div>
                                            <div class="form-group row">
                                                <label for="last_name" class="col-2 col-form-label"><h4>Last name</h4></label>
                                                <div class="col-10">
                                                    <input type="text" class="form-control" name="lname" id="last_name" value="${pc.lastName}" required>
                                                </div>
                                            </div>

                                            <div class="form-group row">

                                                <label for="phone" class="col-2 col-form-label"><h4>Phone</h4></label>
                                                <div class="col-10">
                                                    <input type="tel" class="form-control" name="phone" id="phone" value="${pc.lastName}" required>
                                                </div>
                                            </div>
                                            <div class="form-group row">
                                                <label for="Address" class="col-2 col-form-label"><h4>Address</h4></label>
                                                <div class="col-10">
                                                    <input type="text" class="form-control" name="address" id="address" value="${pc.address}" required>
                                                </div>
                                            </div>
                                            <div class="form-group row">
                                                <label for="pcode" class="col-2 col-form-label"><h4>Postal Code</h4></label>
                                                <div class="col-10">
                                                    <input type="text" class="form-control" name="postalCode" id="pcode" value="${pc.address}" required >
                                                </div>
                                            </div>

                                            <div class="form-group row">
                                                <label for="city" class="col-2 col-form-label"><h4>City</h4></label>
                                                <div class="col-10">
                                                    <input type="text" class="form-control" id="city" value="${pc.city}" required  >
                                                </div>
                                            </div>
                                            <div class="form-group row">
                                                <label for="city" class="col-2 col-form-label"><h4>Role</h4></label>
                                                <div class="col-10">
                                                    <select name="roles" class="form-control" id="register-input-box">
                                                        <c:forEach items="${role}" var="role"> 
                                                            <option value="${role.roleID}">${role.roleDescription}</option>
                                                        </c:forEach> 
                                                    </select>
                                                </div>
                                            </div>
                                            <div class="form-group row">
                                                <label for="city" class="col-2 col-form-label"><h4>Province</h4></label>
                                                <div class="col-10">
                                                    <select name="province"  class="form-control" id="register-input-box">

                                                        < <c:forEach items="${provinces}" var="p"> 
                                                            <option value="${p.provinceID}">${p.provinceName}</option>
                                                        </c:forEach> 
                                                    </select>
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <div class="col-xs-12" style="float: right">
                                                    <input type="hidden" name="action" value="modify">
                                                    <input class="btn btn-lg btn-success" type="submit" value="Save"/>

                                                </div>
                                            </div>

                                        </form>

                                        <form action="edituser" method="get" style="float: left">
                                            <input type="hidden" name="action" value="clear">
                                            <input  class="btn btn-lg btn-danger"type="submit" value="DEACTIVATE ACCOUNT"/>
                                        </form>
                                    </div></div></div></div></div></div>
                                </c:if>
        </div>
        <br>
        <br>
        <footer  class="page-footer font-small  pt-4 text-white">
            <div class="bg-dark ">
                <div class="row">
                    <div class="col-sm">
                        <h5 class="white-text">Visit Us:</h5>
                        <div id="location">
                            #G30 260300 Writing Creek Cres<br>
                            Rocky View County, AB T4A 0G3
                        </div>
                    </div>
                    <div class="col-sm">
                        <h5 class="white-text">Contact Us:</h5>
                        <div id="contact-us">
                            587-834-7890<br>
                            <a href="mailto:eva.ou0314@gmail.com?Subject=Hello">eva.ou0314@gmail.com</a>
                        </div>
                    </div> 
                    <div class="col-sm">
                        <h5 class="white-text">Team:</h5>
                        <div id="team">
                            Eva Oyang
                        </div>
                    </div>
                    <div id="copy"class="container text-white p-4" >
                        © 2020 Cutey & Coolty
                    </div>
                </div>               
            </div>
        </footer>
    </body>
</html>
