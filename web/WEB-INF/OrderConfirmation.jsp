<%-- 
    Document   : OrderConfirmation
    Created on : Mar 6, 2020, 1:49:42 PM
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
        <link href="https://fonts.googleapis.com/css?family=Ubuntu&display=swap"rel="stylesheet"/>
        <link rel="stylesheet" type="text/css" href="./style/index.css" />
        <!-- Bootstrap CSS -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script> 

        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
        <link rel="stylesheet" type="text/css" href="./style/catagory.css" />

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <title>Order Confirmation</title>
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
                        <li class="nav-item ">
                            <a class="nav-link" href="/shop">Shop</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="/cart">Cart (${cartcount})</a>
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

            <title>Order Details</title>
        </header> 

        <br>
        <div id="body-main">
            <h1 id="heading">Order Confirmation</h1>
            <br>
            <table  class="table table-bordered">  
                <thead class="thead-dark">
                    <tr>
                        <th>Ship To</th>
                    </tr>
                </thead>
                <tbody>
                    <tr><td> Order Reference #: ${order.orderNumber}</td></tr>
                    <tr><td> Name: ${order.shipfname} ${order.shiplname}</td></tr>
                    <tr><td> Address : ${order.shipAddress}, ${order.shipCity}, ${order.shipPostalCode}, ${order.shipProvince.provinceName}
                    <tr><td> Shipping and Handling: $ ${order.shipCost}</td></tr>
                    <tr><td> Order Total: $ ${order.orderTotal}</td></tr>
                </tbody>

            </table>

            <h4>ITEMS</h4>
            <table class="table table-bordered">
                <c:forEach  items="${order.orderItemList}" var="c">
                    <tr> 
                        <td >
                            ${c.quantity}
                        </td>
                        <td>
                            ${c.item.name}
                        </td>
                        <td>
                            ${c.ordertotal}
                        </td>
                    </c:forEach> 
            </table>



        </div>
        <br>
        <form action="checkout" method="post" >
            <input id="orderbutton" class="btn-lg btn-dark btn-block" type="submit"  value="Place Order">
            <input  type="hidden" name="action" value="placeOrder">
        </form>



    </body>


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
</html>
