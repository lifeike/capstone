<%-- 
    Document   : inventory
    Created on : Feb 14, 2020, 2:05:43 PM
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
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script> 
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">

        <title>Cart</title>




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
                        <li class="nav-item active">
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
            <title>Cart</title>
        </header> 
        <br>
        <div id="body-main">
            <h3 id="heading">CART</h3>

            <table class="table table-bordered">
                <thead class="thead-dark">
                    <tr>
                        <th>Image</th>
                        <th>Quantity</th>
                        <th>Name</th>
                        <th>Price</th>
                        <th>Total</th>
                        <th>Remove Item </th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach  items="${cart}" var="c">
                        <tr> 
                            <td>
                                <img id="imgcart" src="${c.item.imageLink}">
                            </td>
                            <td align="center">
                                ${c.quantity}
                            </td>
                            <td>
                                ${c.item.name}
                            </td>
                            <td>
                                ${c.item.cost}
                            </td>
                            <td>
                                ${c.ordertotal}
                            </td>

                    <form >
                        <td>

                            <input class="btn-lg btn-dark btn-block" type="submit"  value="REMOVE">
                            <input type="hidden" name="action" value="remove">
                            <input  type="hidden" name="removeid" value='${c.item.upsc}'>
                        </td>
                    </form>

                    </tr>
                </c:forEach> 
                </tbody>

            </table>
        </div>
        <br>

        <h5 id="heading"> Pre-Tax Total : $ ${pre} </h5> 

        <br>
        <form action="shipping-details" >
            <input id="billbutton"class="btn-lg btn-dark btn-block" type="submit"  value="Billing & Shipping">
            <input  type="hidden" name="action" value="shipping-details">
        </form>

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
