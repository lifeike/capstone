<%-- 
    Document   : admin
    Created on : Jan 28, 2020, 10:43:37 AM
    Author     : 794473 - Amitoj Singh
    Author     : 749300 - Lakhwinder Singh 
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" 
              integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">

        <link rel="stylesheet" href="style/admin.css">
        <title>ADMINISTRATION</title>
    </head>
    <body>
        <h1 style="text-align: center">ADMINISTRATION</h1><br>

        <div class="container">
            <!---row1----->
            <div class="row">

                <div id="padd">
                    <button class="col-sm btn-dark" onclick="window.location.href = 'inventory';">
                        <a href="inventory">Manage Inventory</a>
                    </button>
                </div>
                <div id="padd">
                    <button class="col-sm btn-dark" onclick="window.location.href = 'customer-list';">
                        <a href="customer-list">Manage Customer</a>
                    </button>
                </div>
                <div id="padd">
                    <button class="col-sm btn-dark" onclick="window.location.href = 'category';">
                        <a href="category">Manage Category</a>
                    </button>
                </div>
            </div>
            <!---row2----->
            <div class="row">
                <div id="padd">
                    <button class="col-sm btn-dark"  onclick="window.location.href = 'orderlist';">
                        <a href="orderlist"> Order List</a>
                    </button>
                </div>
                <div id="padd">
                    <button class="col-sm btn-dark" onclick="window.location.href = 'ship-order';">
                        <a href="ship-order">Ship Orders</a>
                    </button>
                </div>   
                <div id="padd">
                    <button class="col-sm btn-dark" onclick="window.location.href = 'message-list';">
                        <a href="message-list">Messages</a>
                    </button>
                </div>                           

            </div>
            <!---row3----->
            <div class="row">
                <div id="padd">
                    <button class="col-sm btn-dark" onclick="window.location.href = 'province';">
                        <a href="province">View Province List and Taxes</a>
                    </button>
                </div>
                <div id="padd">
                    <button class="col-sm btn-danger" onclick="window.location.href = 'login';">
                        <a href="login">Logout</a>
                    </button>
                </div>
            </div>
        </div>


    </body>
</html>
