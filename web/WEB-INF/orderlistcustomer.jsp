<%-- 
    Document   : orderlistcustomer
    Created on : Mar 23, 2020, 6:19:00 PM
    Author     : 794473 - Amitoj Singh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head> 
        <link href="https://fonts.googleapis.com/css?family=Ubuntu&display=swap"rel="stylesheet"/>
        <link rel="stylesheet" type="text/css" href="./style/index.css" />
        <!-- Bootstrap CSS -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script> 

        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
        <link rel="stylesheet" type="text/css" href="./style/catagory.css" />

        <title>Order History</title>
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
                    <a class="float-right p-2 text-muted"  href="/profile" >Hello, ${fname} ${lname}</a>
                </p>
            </div>
            <!--Navbar-->
            <nav class="navbar navbar-expand-lg navbar-dark bg-dark primary-color">
                <!-- Navbar brand -->
                <a class="navbar-brand navbar-dark" href="/shop">C&C</a>
                <!-- Collapse button -->
                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#basicNav"
                        aria-controls="basicNav" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <!-- Collapsible content -->
                <div class="collapse navbar-collapse" id="basicNav">
                    <!-- Links -->
                    <ul class="navbar-nav mr-auto p-1  bg-dark">

                        <li class="nav-item">
                            <a class="nav-link" href="/shop">Shop
                            </a>
                        </li>

                        <li class="nav-item active">
                            <a class="nav-link" href="/customerOrder">Order History
                                <span class="sr-only">(current)</span>
                            </a>
                        </li>

                        <li class="nav-item">
                            <a class="nav-link" href="/profile">Profile
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
            <h3 id="heading">ORDER HISTORY</h3>
            <br>
            <table class="table table-bordered">
                <thead class="thead-dark">
                    <tr>
                        <th>ORDER NUMBER</th>
                        <th>ORDER STATUS</th>
                        <th>ORDER DATE</th>
                        <th>ORDER TOTAL</th>
                        <th>DETAILS</th>
                    </tr>
                </thead>
                <tbody>

                    <c:forEach items="${user.ordersList}" var="o">

                        <tr>
                            <td align="center">
                                ${o.orderNumber}
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

                    <form action="customerOrder">
                        <td align="center">
                            <input class="btn-sm btn-dark btn-block" type="submit"  value="VIEW DETAILS">
                            <input type="hidden" name="action" value="moreDetails">
                            <input  type="hidden" name="idValue" value='${o.orderNumber}'>
                        </td>
                    </form>

                    </tr>

                </c:forEach> 
                </tbody>

            </table>



        </div>

    </body>
</html>
