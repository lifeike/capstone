<%-- 
    Document   : inactive
    Created on : Apr 1, 2020, 3:08:05 AM
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
        
        <title>Inactive Inventory</title>

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
                         <li class="nav-item ">
                            <a class="nav-link " href="/inventory">Inventory
                            </a>
                        </li>

                        <li class="nav-item active">
                            <a class="nav-link " href="/inactive">Inactive Inventory
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
            <h3 id="heading">Inactive Inventory</h3>            
            <br>
            <table class="table table-bordered">
                <thead class="thead-dark">
                    <tr>
                        <th>UPSC</th> 
                        <th>NAME</th>
                        <th>COST</th>
                        <th>RETAIL</th>
                        <th>SET ACTIVE</th>
                    </tr>
                </thead>
                <tbody>

                    <c:forEach items="${iainventory}" var="is">
                    <td>${is.upsc}</td>
                    <td>${is.name}</td>
                    <td>$${is.cost}</td>
                    <td>$${is.retailCost}</td>
                    <td>
                        <form action="inactive-inventory" method="post">
                            <input type="hidden" name="action" value="setactive">
                            <input type="hidden" name="id" value='${is.upsc}'>
                            <input class="btn-sm btn-dark btn-block" type="submit"  value="YES">
                        </form>
                    </td>
                    </tr>
                </c:forEach>

                </tbody>

            </table>
    </body>
</html>
