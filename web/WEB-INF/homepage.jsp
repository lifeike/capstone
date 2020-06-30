<%-- 
    Document   : homepage
    Created on : Feb 5, 2020, 8:21:39 AM
    Author     : 794473 - Amitoj Singh
    Author     : 749300 - Lakhwinder Singh 
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

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
        <link
            href="https://fonts.googleapis.com/css?family=Ubuntu&display=swap"
            rel="stylesheet"
            />
        <link rel="stylesheet" type="text/css" href="./style/index.css" />
        <!-- Bootstrap CSS -->
        <link
            rel="stylesheet"
            href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
            integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
            crossorigin="anonymous"
            />
        <title>Cutey N' Coolty</title>
    </head>
    <body>
        <header style="padding-top: 3em;">
            <div>
                <h1 class="col-lg" style="font-family: 'Ubuntu', sans-serif; text-align: center">
                    Cutey N' Coolty
                </h1>
            </div>
            <c:if test="${logged ne true}">

                <div class="row">
                    <p class="col-sm">
                        <a class="float-right p-2 text-muted" href="/login">Login/Signup</a>
                    </p>
                </div>
            </c:if>

            <c:if test="${logged eq true}">

                <div class="row">
                    <p class="col-sm">
                        <a class="float-right p-2 text-muted"  href="/profile" >Hello, ${fname} ${lname}</a>
                    </p>
                </div>
            </c:if>

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
                    <ul class="navbar-nav mr-auto p-1  bg-dark" >
                        <li class="nav-item active">
                            <a class="nav-link" href="/home">Home
                                <span class="sr-only">(current)</span>
                            </a>
                        </li> 
                        <li class="nav-item">
                            <a class="nav-link" href="/shop">Shop</a>
                        </li>
                        <c:if test="${logged eq true}">
                            <li>  <a class="nav-link" href="/cart">Cart (${cartcount})</a>
                            </li>
                        </c:if>
                        <li class="nav-item">
                            <a class="nav-link" href="/contact">Return & Contact</a>
                        </li>

                    </ul>
                    <!-- Links -->
                    <c:if test="${logged eq true}">
                        <div class="md-form my-0">
                            <button class="btn btn-danger" onclick="window.location.href = 'login';">
                                Logout</button>
                        </div>
                    </c:if>
                </div>
                <!-- Collapsible content -->
            </nav>
            <!--/.Navbar-->  

        </header>
        <br>
        <h2 id="wel">Welcome to C&C</h2>
        <!-- Slideshow container -->
        <div class="slideshow-container">
            <!-- Full-width images with number and caption text -->
            <div class="mySlides">
                <div class="numbertext">1 / 3</div>
                <img src="images/image1.png" style="width:100%" />

            </div>

            <div class="mySlides">
                <div class="numbertext">2 / 3</div>
                <img src="images/image2.png" style="width:100%" />

            </div>

            <div class="mySlides">
                <div class="numbertext">3 / 3</div>
                <img src="images/image3.png" style="width:100%" />

            </div>

            <!-- Next and previous buttons -->

        </div>
        <br /> 


        <br>

        <div class="container">

            <br> 

            <div class="row">
                <c:forEach items="${shop}" var="item">

                    <div class="col-md-3 col-sm-6"> 
                        <form action="shop" method="post">  
                            <div class="product-grid3">

                                <div class="product-image3">

                                    <span >
                                        <img id="img" src="${item.imageLink}" onclick="window.location.href = 'shop';">
                                    </span>
                                </div>
                                <div class="product-content">
                                    <h2 class="title"><a href="/shop"> ${item.name}</a></h2>
                                    <div>
                                        <label>Cost:</label> <span>$${item.cost}</span> <br>
                                    </div>
                                </div>

                            </div>

                        </form >
                    </div>

                </c:forEach>       
            </div>

        </div>

        <a id="shop" href="/shop">Shop More</a>

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

    <script
        src="https://code.jquery.com/jquery-3.4.1.slim.min.js"
        integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n"
        crossorigin="anonymous"
    ></script>

    <script
        src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
        integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
        crossorigin="anonymous"
    ></script>
    <script
        src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"
        integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6"
        crossorigin="anonymous"
    ></script>
    <script src="./js/HomePage.js"></script>
</html>

