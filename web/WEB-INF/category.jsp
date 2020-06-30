<%-- 
    Document   : category
    Created on : Jan 28, 2020, 10:44:52 AM
    Author     : 794473 - Amitoj Singh
    Author     : 749300 - Lakhwinder Singh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html>
<html>
    <head> <link href="https://fonts.googleapis.com/css?family=Ubuntu&display=swap"rel="stylesheet"/>
        <link rel="stylesheet" type="text/css" href="./style/index.css" />
        <!-- Bootstrap CSS -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script> 
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
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
                        <li class="nav-item active">
                            <a class="nav-link" href="/admin">Home
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
            <title>Category Management</title>
        </header> 

        <br>


        <div id="addbtncatagory">
            <button  type="id="addid="addbtncatagorybtncatagory " class="btn-lg btn-dark btn-block" data-toggle="modal" data-target="#myModal"button>
                Add
            </button> 
        </div>
        <br>


        <div id="body-main">
            <c:if test="${edit ne true}">



                <h3 id="heading">CATEGORY MANAGEMENT</h3>
                <br>
                <form>
                    <table class="table">
                        <thead class="thead-dark">
                            <tr>
                                <th>SELECT</th>
                                <th>ID</th>
                                <th>CATEGORY NAME</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${categories}" var="category">
                                <tr>
                                    <td align="center">
                                        <input type="radio" name="categoryselected" value=${category.categoryID} ><br>

                                    </td>
                                    <td align="center">
                                        ${category.categoryID}
                                        <br>

                                    </td>
                                    <td align="center">
                                        ${category.categoryDescription}
                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                    <input id="edit" class="btn-lg btn-dark btn-block" type="submit"  value="EDIT">
                    <input type="hidden" name="action" value="editcategory">

                </form>

            </c:if>
            <!--add form popup-->
            <div class="modal" id="myModal"style="z-index:9999;">
                <div  class="modal-dialog">
                    <div class="modal-content">

                        <!-- Modal Header -->
                        <div class="modal-header">
                            <h4 class="modal-title">ADD CATEGORY</h4>
                            <button type="button" class="close" data-dismiss="modal">&times;</button>
                        </div>

                        <!-- Modal body -->
                        <div class="bs-example">
                            <c:if test="${edit ne true}">
                                <form id="addform" action="category" method="post">

                                    <table >
                                        <tr>
                                        <div class="form-group">
                                            <label>Category Name:</label>
                                            <input type="text" name="addcategoryname"  class="form-control" placeholder="Category Name" required/>
                                        </div>
                                        </tr>
                                    </table>
                                    <input type="hidden" name="action" value="addcategory" />
                                    <input id="add" class="btn-lg btn-dark btn-block" type="submit" value="ADD"/>

                                </form>   
                            </c:if>
                        </div>

                        <!-- Modal footer -->
                        <div class="modal-footer">
                            <button type="button" class="btn btn-primary" data-dismiss="modal">Close</button>
                        </div>
                    </div>
                </div>
            </div>

            <!-----------------------------------------edit form---------------------------->

            <div id="editformcat">
                <c:if test="${edit eq true}">
                    <h2> EDIT CATEGORY </h2>
                    <form action="category" method="post">
                        <div class="form-group">
                            <label style="font-size: 20px">Category Name</label> 
                            <input type="text" name="newcatname"  class="form-control" value=${catid.categoryDescription} required/>
                            <br>

                            <table>

                                <tr>
                                    <td>
                                        <input type="hidden" name="action" value="editcategory" />
                                        <input type="hidden" name="editcategoryidval" value=${catid.categoryID} />
                                        <input class="btn-lg btn-dark btn-block" type="submit" value="UPDATE"/>
                                    </td>

                                    <td>
                                        <input type="hidden" name="action" value="clear" />
                                        <input class="btn-lg btn-dark btn-block" type="submit" value="CANCEL"/>
                                    </td>
                                </tr>
                            </table>

                        </div> 
                    </form>


                </c:if>
            </div>

        </div>
    </body>
</html>
