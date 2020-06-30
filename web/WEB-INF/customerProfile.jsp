<%-- 
    Document   : customerProfile
    Created on : Mar 17, 2020, 3:47:10 PM
    Author     : 794473 - Amitoj Singh
    Author     : 749300 - Lakhwinder Singh 
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="./style/index.css" />
        <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
        <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
        <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

        <meta charset="utf-8">
        <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
        <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
        <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <script type="text/javascript" src="./js/profile.js"></script> 


        <title>Profile Settings</title>
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
                    <a class="float-right p-2 text-muted"  href="/profile" >Hello, ${fname} ${lname}</a>
                </p>
            </div>
            <!--Navbar-->
            <nav class="navbar navbar-expand-lg navbar-dark bg-dark primary-color">
                <!-- Navbar brand -->
                <a class="navbar-brand navbar-dark" href="/home">C&C</a>
                <!-- Collapse button -->
                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#basicNav"
                        aria-controls="basicNav" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <!-- Collapsible content -->
                <div class="collapse navbar-collapse" id="basicNav">
                    <!-- Links -->
                    <ul class="navbar-nav mr-auto p-1  bg-dark">
                        <li class="nav-item ">
                            <a class="nav-link" href="/home">Home</a>
                        </li>

                        <li class="nav-item ">
                            <a class="nav-link" href="/customerOrder"> Order History
                                <span class="sr-only"></span>
                            </a>
                        </li>
                        <li class="nav-item active">
                            <a class="nav-link" href="/profile">Profile</a>
                            <span class="sr-only">(current)</span>
                        </li>

                    </ul>
                    <!-- Links -->


                    <div class="pull-right">
                        <button class="btn btn-danger" onclick="window.location.href = 'login';">
                            Logout</button>
                    </div>

                </div>
                <!-- Collapsible content -->
            </nav>
            <!--/.Navbar-->
        </header>
        <br>
        <h1 id="heading">Profile Settings</h1>
        <br>
        <div class="container">
            <div class="col-md-12">
                <div class="card">
                    <div class="card-body">
                        <div class="row">
                            <div class="col-md-12">

                                <form action="edituser" method="post">
                                    <div class="form-group row">
                                        <label for="email" class="col-4 col-form-label"><h4>Email</h4></label>
                                        <div class="col-8">
                                            <input type="text" class="form-control" name="email" id="email" value="${user.email}"  readonly>
                                        </div>
                                    </div>
                                    <div class="form-group row">

                                        <label for="first_name" class="col-4 col-form-label"><h4>First name</h4></label>
                                        <div class="col-8">
                                            <input type="text" class="form-control" name="fname" id="first_name" value="${user.firstName}"  required>
                                        </div>

                                    </div>
                                    <div class="form-group row">


                                        <label for="last_name" class="col-4 col-form-label"><h4>Last name</h4></label>
                                        <div class="col-8">
                                            <input type="text" class="form-control" name="lname" id="last_name"  value="${user.lastName}" required>
                                        </div>
                                    </div>

                                    <div class="form-group row">

                                        <label for="phone" class="col-4 col-form-label"><h4>Phone</h4></label>
                                        <div class="col-8">
                                            <input type="tel" class="form-control" name="phone" id="phone" value="${user.phone}" required>
                                        </div>
                                    </div>

                                    <div class="form-group row">
                                        <label for="Address" class="col-4 col-form-label"><h4>Address</h4></label>
                                        <div class="col-8">
                                            <input type="text" class="form-control" name="address" id="address" value="${user.address}" required>
                                        </div>
                                    </div>
                                    <div class="form-group row">
                                        <label for="pcode" class="col-4 col-form-label"><h4>Postal Code</h4></label>
                                        <div class="col-8">
                                            <input type="text" class="form-control" name="postalCode" id="pcode" value="${user.postalCode}" required >
                                        </div>
                                    </div>
                                    <div class="form-group row">
                                        <label for="city" class="col-4 col-form-label"><h4>City</h4></label>
                                        <div class="col-8">
                                            <input type="text" class="form-control" id="city" value="${user.city}"  >
                                        </div>
                                    </div>
                                    <div class="form-group row">
                                        <label for="city" class="col-4 col-form-label"><h4>Province</h4></label>
                                        <div class="col-8">
                                            <select name="province"  class="form-control" id="register-input-box">

                                                <c:forEach items="${provList}"  var="prov">

                                                    <option value="${prov.provinceID}"  selected="">${prov.provinceName}</option>

                                                </c:forEach>
                                            </select>
                                        </div>
                                    </div>
                                    <div class="form-group row">
                                        <label for="password" class="col-4 col-form-label"><h4>Password</h4></label>
                                        <div class="col-8">
                                            <input type="password" class="form-control" name="password" id="password" value="${user.password}" required >
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <div class="col-xs-12" style="float: right">
                                            <input type="hidden" name="action" value="up">
                                            <input class="btn btn-lg btn-success" type="submit" value="UPDATE"/>

                                        </div>
                                    </div>
                                </form>

                                <form action="edituser" method="get" style="float: left">
                                    <input type="hidden" name="action" value="deactivate">
                                    <input  class="btn btn-lg btn-danger"type="submit" value="DEACTIVATE ACCOUNT"/>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
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
