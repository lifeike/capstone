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
    <body
<head>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script> 
    <link rel="stylesheet" type="text/css" href="./style/index.css" />

    <!-- Required meta tags -->
    <meta charset="utf-8" />
    <meta
        name="viewport"
        content="width=device-width, initial-scale=1, shrink-to-fit=no"
        />

    <!-- import font-->
    <link href="https://fonts.googleapis.com/css?family=Ubuntu&display=swap" rel="stylesheet"/>
    <!-- Bootstrap CSS -->

    <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>

    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous"/>
    <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" />
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">



    <title>Cutie N' Coolty</title>
</head>

<header style="padding-top: 3em;  ">
    <div>
        <h1 class="col-lg" style="font-family: 'Ubuntu', sans-serif; text-align: center " >
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
                    <a class="nav-link " href="/inventory">Inventory 
                        <span class="sr-only">(current)</span>
                    </a>
                </li>

                <li class="nav-item ">
                    <a class="nav-link" href="/inactive-inventory">Inactive Inventory

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


    <title>Inventory</title>
</header>

<c:if test="${edit ne true}">
    <!------------------------------------Add button-------------------------------------------------->
    <br> <div id="addbutton">
        <button type="button" class="btn-lg btn-dark btn-block" data-toggle="modal" data-target="#myModal">
            Add
        </button>           
    </div>

    <!------------------------------------display item-------------------------------------------------->

    <form id="search" action="inventory" method="post" class="form-group">
            <input class="form-control" type="text" name="searchItem" placeholder="Enter UPSC to search">
            <button  id="addbutton" class="btn-lg btn-dark btn-block"type="submit" name="action" value="search" >search</button>
        </form>
    
    <div class="container"><br>
        <h3 id="heading">Inventory </h3>
        <br> 
        <br>

        <div class="row">
            <c:forEach items="${itemList}" var="item">
                <div class="col-md-3 col-sm-6"> 

                    <div class="product-grid3">

                        <div class="product-image3">

                            <span >
                                <img src="${item.imageLink}">
                            </span>

                            <table>
                                <tr>

                                    <td>
                                        <div id="editbutton">
                                            <form action="inventory">
                                                <!--Edit form popup-->
                                                <input type="hidden" name="action" value="modify">
                                                <input type="hidden" name="modifyID" value='${item.upsc}'>
                                                <div >
                                                    <input  type="submit" value="Edit"  id="submit" style="width: 125px"
                                                            class="btn-lg btn-dark btn-block" 
                                                            data-toggle="modal" data-target="#myModalEd">
                                                </div>
                                            </form>
                                        </div>
                                    </td>
                                    <td>
                                        <form action="inventory">
                                            <input type="hidden" name="action" value="de">
                                            <input type="hidden" name="deid" value='${item.upsc}'>    
                                            <input  class="btn btn-lg btn-danger"type="submit" value="Remove"/>
                                        </form >

                                    </td>

                                </tr>


                            </table> 
                        </div>
                        <div class="product-content">
                            <h3 class="title"><a href="#"> ${item.name}</a></h3>
                            <div class="price">
                                <label>Cost: $</label> <span>${item.cost}</span> <br>
                                <label>Retail: $</label> <span> ${item.retailCost}</span><br>
                                <label>UPSC:</label><span> ${item.upsc}</span><br>
                                <label>Quantity:</label> <span>${item.quantity}</span><br>
                                <label>Category:</label> <span> ${item.category.categoryDescription}</span>
                            </div>
                            <div class="descripton">
                                <label>Description:</label>
                                <span> ${item.description}</span>
                            </div>
                        </div>

                    </div>

                </div>
            </c:forEach>       
        </div>

    </div>

    <!------------------------------------Pop Forms-------------------------------------------------->
    <!--add form popup-->
    <div class="modal" id="myModal" style="z-index:9999;">
        <div class="modal-dialog">
            <div class="modal-content">

                <!-- Modal Header -->
                <div class="modal-header">
                    <h4 class="modal-title">Item Information</h4>
                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                </div>

                <!-- Modal body -->
                <div class="bs">
                    <c:if test="${edit ne true}"> 
                        <form action="inventory" method="post">

                            <div class="form-group">
                                <label>Name</label>
                                <input type="text" name="name" class="form-control"  placeholder="Item Name">
                            </div>
                            <div class="form-group">
                                <label>UPSC</label>
                                <input type="text" name="upsc" class="form-control"  placeholder="12345678900">
                            </div> 

                            <div class="form-group">
                                <label >Description</label>
                                <textarea name="description" class="form-control"  placeholder="Description"> </textarea>
                            </div>

                            <div class="form-group">
                                <label >Cost</label>
                                <input type="text" name="cost" class="form-control"  placeholder="0.0" >
                            </div>

                            <div class="form-group">
                                <label >Retail</label>
                                <input type="text" name="retail" class="form-control"  placeholder="0.0" >
                            </div>
                            <div class="form-group">
                                <label >Quantity</label>
                                <input type="text" name="quantity" class="form-control"  placeholder="0" >
                            </div> 
                            <label >Image</label>
                            <div class="input-group mb-3">
                                <div class="custom-file">

                                    Select File to Upload:<input type="file" name="imageLink"  value="$pc.imageLink"><br>

                                </div>
                            </div>

                            <div class="form-group" class="form-control" >
                                <label >Category</label><br>
                                <select id="category" class="form-control" name="category">
                                    <c:forEach items="${cateList}"  var="category">
                                        <option value="${category.categoryID}">${category.categoryDescription}</option>
                                    </c:forEach>
                                </select>
                            </div>
                            <button type="submit" name="action" class="btn-lg btn-dark btn-block" value="add" >Add</button>

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
</c:if>
<!--------------------------------EditForm--------->


<div id="editform">

    <c:if test="${edit eq true}">
        <h2> EDIT ITEM </h2>
        <form action="inventory" method="post" >

            <div class="form-group">
                <label>Name</label>
                <input type="text" name="name" id="name" value='${pc.name}' class="form-control" placeholder="Item Name">
            </div>

            <div class="form-group">
                <label>UPSC</label>
                <input type="text" name="upsc" value='${pc.upsc}' class="form-control"  readonly>
            </div>

            <div class="form-group">
                <label >Description</label>
                <input type="text" class="form-control" name="description" value='${pc.description}' > 
            </div>

            <div class="form-group">
                <label >Cost</label>
                <input type="text" name="cost" value='${pc.cost}' class="form-control" id=""  >
            </div>

            <div class="form-group">
                <label >Retail</label>
                <input type="text" name="retail" value='${pc.retailCost}' class="form-control" id=""  >
            </div>
            <div class="form-group">
                <label >Quantity</label>
                <input type="text" name="quantity" value='${pc.quantity}' class="form-control" id="" >
            </div>
            <div class="form-group">
                <label>Images</label>


                <div class="input-group mb-3">
                    <div class="custom-file">

                        Select File to Upload:<input type="file" name="imageLink"  value="$pc.imageLink"><br>

                    </div>
                </div>


            </div>
            <div class="form-group" class="form-control">
                <label >Category</label><br>
                <select id="category" class="form-control" name="category">
                    <c:forEach items="${cateList}"  var="category">
                        <option value="${category.categoryID}">${category.categoryDescription}</option>
                    </c:forEach>
                </select>
            </div>
            <input type="hidden" name="action" value="modify" />
            <input type="hidden" name="modifyID" value="${item.upsc}">
            <button type="submit" class="btn-lg btn-dark btn-block">Save</button>

        </form>
    </c:if>
</div>

</body>


</html>
