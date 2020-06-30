<%-- 
    Document   : ship
    Created on : Apr 1, 2020, 2:55:47 AM
    Author     : 794473 - Amitoj Singh
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
        <title>Ship Orders</title>
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
                        <li class="nav-item ">
                            <a class="nav-link" href="/admin">Home

                            </a>
                        </li>
                        <li class="nav-item active">
                            <a class="nav-link " href="#" onclick="window.location.reload(true);">Ship Orders
                                <span class="sr-only">(current)</span>
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
            <h3 id="heading">Ship Orders</h3>            
            <br>

            <c:if test="${edit ne true}">
                <form action="ship-order">
                    <table class="table table-bordered">
                        <thead class="thead-dark">
                            <tr>
                                <th>ORDER NUMBER</th>
                                <th>CUSTOMER</th>
                                <th>ORDER STATUS</th>
                                <th>ORDER DATE</th>
                                <th>ORDER TOTAL</th>
                                <th>ADD SHIP DETAILS</th>
                            </tr>
                        </thead>
                        <tbody>

                            <c:forEach items="${var.ordersList}" var="o">

                                <tr>
                                    <td align="center">
                                        ${o.orderNumber}
                                    </td>

                                    <td align="center">
                                        ${o.customer.email}
                                    </td>

                                    <td align="center">
                                        ${o.orderstat.statDescription}
                                    </td>

                                    <td align="center">
                                        ${o.orderDate}
                                    </td>

                                    <td align="center">
                                        $ ${o.orderTotal}
                                    </td>


                                    <td align="center">


                                        <input id="edit" class="btn-lg btn-dark btn-block" type="submit"  value="YES">
                                        <input type="hidden" name="on" value=${o.orderNumber} />
                                        <input type="hidden" name="action" value="ship">


                                    </td>
                                </tr>
                            </c:forEach> 
                        </tbody>
                    </table>
                </form>
            </c:if>

            <c:if test="${edit eq true}">


                <form action="ship-order" method="post">
                    <table class="table table-bordered">
                        <thead class="thead-dark">
                            <tr>
                                <th>Order #: ${sval}</th>
                            </tr>
                        </thead>
                        <tbody>
                        <br>
                        <tr><td>Shipping Company Name :<input type="text" name="company"  class="form-control" required/></td></tr>
                        <tr><td>  Tracking Number : <input type="text" name="tn"  class="form-control" required/></td><br></tr>
                        <tr><td><input type="hidden" name="action" value="ship-order" />
                                <input type="hidden" name="onn" value=${sval} />
                                <input class="btn-lg btn-dark btn-block" type="submit" value="Add Details"/></td></tr>
                        </tbody>
                    </table>
                </form>
            </c:if>
        </div>
    </body>
</html>
