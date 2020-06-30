<%-- 
    Document   : contact
    Created on : Apr 8, 2020, 1:57:58 PM
    Author     : 794473
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link href="https://fonts.googleapis.com/css?family=Ubuntu&display=swap"rel="stylesheet"/>
        <link rel="stylesheet" type="text/css" href="./style/index.css" />
        <!-- Bootstrap CSS -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script> 
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
        <title>Contact & Return</title>
    </head>
    <body>
        <header  style="padding-top: 3em;">
            <div>
                <h1 class="col-lg" style="font-family: 'Ubuntu', sans-serif; text-align: center">
                    Cutey N' Coolty
                </h1>
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
                            <a class="nav-link" href="/home">Home

                            </a>
                        </li>
                        <li class="nav-item active">
                            <a class="nav-link " href="#" onclick="window.location.reload(true);">Return & Contact
                                <span class="sr-only">(current)</span>
                            </a>
                        </li>
                    </ul>
                    <!-- Links -->

                  
                </div>
                <!-- Collapsible content -->
            </nav>
            <!--/.Navbar-->
        </header>
        <br>
        <div id="body-main">
            <h3 id="heading">Contact Us</h3>  
            <br>
            <form action="contact" method="post">
                <table class="table table-bordered">
                    <thead class="thead-dark">
                        <tr>
                            <th>For Returns and Order Cancellation Please leave your message with an order number, phone number and someone will contact soon.
                            </th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td> <div class="form-group">
                                    <label for="register-input-box">Name</label>
                                    <Input  class="form-control" id="register-input-box" name="name" type="text"
                                            placeholder="Name">
                                    
                                    
                                </div>
                            </td>
                        </tr>
                        <tr>
                            <td> <div class="form-group">
                                    <label for="register-input-box">Email</label>
                                    <Input  class="form-control" id="register-input-box" name="email" type="email"
                                            placeholder="Email">
                                </div>
                            </td>
                        </tr>
                        <tr>
                            <td> <div class="form-group">
                                    <label for="register-input-box">Message</label> 
                                    <textarea  class="form-control" id="register-input-box" name="message" type="text"
                                               placeholder="Message"></textarea>                                                         
                                </div>
                            </td>
                        </tr>
                        <tr>
                            <td><button id="msgbutton" type="submit" name="action" class="btn-lg btn-dark btn-block" value="add" >SUBMIT</button>
                            </td>
                        </tr>
                    </tbody> 
                </table>
            </form>
        </div>
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
</html>
