<%-- 
    Document   : shippingdetails
    Created on : Feb 24, 2020, 7:09:23 PM
    Author     : 794473 - Amitoj Singh
    Author     : 749300 - Lakhwinder Singh 
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <meta
            name="viewport"
            content="width=device-width, initial-scale=1, shrink-to-fit=no"
            />

        <!-- import font-->
        <link href="https://fonts.googleapis.com/css?family=Ubuntu&display=swap" rel="stylesheet"/>
        <link rel="stylesheet" type="text/css" href="./style/index.css" />
        <!-- Bootstrap CSS -->

        <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>

        <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" rel="stylesheet"
              integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous"/>
        <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" />
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">

        <title>SHIPPING DETAILS</title>

    </head>
    <body>
        <header style="padding-top: 3em;">
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
                        <li class="nav-item">
                            <a class="nav-link" href="/shop">Shop</a>
                        </li>
                        <li class="nav-item ">
                            <a class="nav-link" href="/cart">Cart (${cartcount})</a>
                            <span class="sr-only">(current)</span>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="/profile">Profile</a>
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

        <br>
        <div id="shippingform"><h3 id="heading">SHIPPING DETAILS</h3>
            <div class="modal-content">

                <div class="bs">

                    <br>
                    <form action="shipping-details" method="post" >
                        <div class="form-group">
                            <label>First Name</label>
                            <input type="text" class="form-control" placeholder="First Name" name="fname"  value='${user.firstName}' required/>
                        </div>
                        <div class="form-group">
                            <label>Last Name</label>
                            <input type="text" class="form-control" placeholder="Last Name" name="lname" value='${user.lastName}' required/>
                        </div>
                        <div class="form-group">
                            <label>Phone</label>
                            <input type="text" class="form-control" placeholder="Address" name="phone"  value='${user.phone}'required/>
                        </div>
                        <div class="form-group">
                            <label>Address</label> 
                            <input type="text" class="form-control" placeholder="Address" name="address"  value='${user.address}'required/>
                        </div>
                        <div class="form-group">
                            <label>Postal Code</label>
                            <input type="text" class="form-control" placeholder="Postal Code" name="postalcode"  value='${user.postalCode}'required/>
                        </div>
                        <div class="form-group">
                            <label>City</label>
                            <input type="text" class="form-control" placeholder="City" name="city" value='${user.city}' required/>
                        </div>
                        <br>
                        <div class="form-group">
                            <label> Province</label>
                            <select name="province"  class="form-control">
                                <c:forEach items="${provList}"  var="prov">
                                    <option value="${prov.provinceID}"  >${prov.provinceName}</option> 
                                </c:forEach>

                            </select>
                            <br>

                            <input class="btn-lg btn-dark btn-block" type="submit"  value="Confirm Details">
                            <input  type="hidden" name="action" value="confirm">
                            </form>

                        </div>
                </div>
            </div>
        </div>
    </body>
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
</html>
