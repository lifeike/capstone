<%-- 
    Document   : OrderDetailAdmin
    Created on : Mar 2, 2020, 2:13:53 PM
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
        <link rel="stylesheet" type="text/css" href="./style/catagory.css" />
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>ORDER DETAIL</title>
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
                        <li class="nav-item ">
                            <a class="nav-link" href="/admin">Home
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
            <title>Order Details</title>
        </header> 
        <br> <h3 id="heading">ORDER DETAIL</h3><br>
        <div class="container-fluid">

            <div class="row">

                <div class="col-sm-3 col-md-6 col-lg-4" >
                    <table class="table table-bordered">   
                        <tr><td> Order #: ${orderDetail.orderNumber}</td></tr>
                        <tr> <td> Order Placed By Email: ${orderDetail.customer.email}</td></tr>
                    </table>

                    <table class="table table-bordered">  
                        <thead class="thead-dark">

                            <tr>
                                <th>Shipping Details</th>
                            </tr>
                        </thead>

                        <tr><td> To : ${orderDetail.shipfname} ${orderDetail.shiplname}</td></tr>
                        <tr><td> Address:  ${orderDetail.shipAddress}
                                <br>
                                ${orderDetail.shipCity},
                                ${orderDetail.shipProvince.provinceName},
                                ${orderDetail.shipPostalCode}

                            </td></tr>
                        <tr><td> Order Date:  ${orderDetail.orderDate}</td></tr>
                        <tr><td> Ship Date:  ${orderDetail.shipDate}</td></tr>
                        <tr><td> Shipping Cost: $ ${orderDetail.shipCost}</td></tr>
                        <tr><td> Shipped Via:  ${orderDetail.shipCompany}</td></tr>
                        <tr><td> Tracking#:  ${orderDetail.trackingnumber}</td></tr>

                    </table>
                </div>
                <div class="col-sm-9 col-md-6 col-lg-8" >

                    <div class="container">
                        <table class="table table-bordered">
                            <thead class="thead-dark">

                                <tr>
                                    <th>UPSC</th>
                                    <th>Product Name</th>
                                    <th>Cost</th>
                                    <th>Quantity</th>
                                    <th>Product Total</th>
                            </thead>
                            <tbody>
                                <c:forEach items="${orderDetail.orderItemList}" var="c" >
                                    <tr>
                                        <td>
                                            ${c.item.upsc}
                                        </td>
                                        <td>
                                            ${c.item.name}
                                        </td>
                                        <td>
                                            ${c.cost}
                                        </td>
                                        <td>
                                            ${c.quantity}
                                        </td>
                                        <td>
                                            ${c.ordertotal}
                                        </td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                        <br>

                        <table class="table table-bordered">
                            <thead class="thead-dark">
                                <tr><td>
                                        <h4>Shipping Cost:$ ${orderDetail.shipCost} </h4>
                                        <h4>Order Total : $ ${orderDetail.orderTotal} </h4>
                                    </td> </tr>
                            </thead>
                        </table>

                    </div>
                </div>
            </div>





    </body>
</html>
