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
        <!-- Required meta tags -->
        <meta charset="utf-8" />
        <meta
            name="viewport"
            content="width=device-width, initial-scale=1, shrink-to-fit=no"
            />
        <!-- import font-->
        <link href="https://fonts.googleapis.com/css?family=Ubuntu&display=swap"rel="stylesheet"/>
        <link rel="stylesheet" type="text/css" href="./style/index.css" />
        <!-- Bootstrap CSS -->
        <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script> 

        <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" rel="stylesheet"
              integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous"/>
        <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" />
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">


        <title>Shop</title>
    </head>
   
        <header  style="padding-top: 3em;">
            <div>
                <h1 class="col-lg" style="font-family: 'Ubuntu', sans-serif; text-align: center" >
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
                    <ul class="navbar-nav mr-auto p-1  bg-dark ">
                        <li class="nav-item ">
                            <a class="nav-link" href="/home">Home</a>
                        </li>
                        <li class="nav-item active">
                            <a class="nav-link" href="/shop">Shop</a>
                            <span class="sr-only">(current)</span>

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


            <title>SHOP</title>
        </header>
                        <br>
    <body>

        <!------------------------------------display item-------------------------------------------------->
        <div class="container">

            <br> 

            <div class="row">
                <c:forEach items="${shop}" var="item">

                    <div class="col-md-3 col-sm-6"> 
                        <form action="shop" method="post">  
                            <div class="product-grid3">

                                <div class="product-image3">

                                    <span >
                                        <img src="${item.imageLink}">
                                    </span>






                                </div>
                                <div class="product-content">
                                    <h2 class="title"><a href="#"> ${item.name}</a></h2>
                                    <div class="descripton">
                                        <label>Description:</label>
                                        <span> ${item.description}</span>
                                    </div>
                                    <div class="price">
                                        <label>Cost:</label> <span>${item.cost}</span> <br>
                                        <label>Product Code :</label> <span>${item.upsc}</span><br>
                                        <label>Category:</label> <span>${item.category.categoryDescription}</span> <br>
                                        <input type="number" name="quantity" min="1" max="5" value="1" class="form-control">
                                    </div>
                                </div>

                            </div>
                            <input type="submit"  value="ADD" class="btn-lg btn-dark btn-block" >
                            <input type="hidden" name="action" value="add">
                            <input type="hidden" name="itemcode" value='${item.upsc}'>
                        </form >
                    </div>

                </c:forEach>       
            </div>

        </div>

        <br>
        <br>
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