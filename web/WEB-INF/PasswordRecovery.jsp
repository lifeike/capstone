<%-- 
    Document   : forgotpassword
    Created on : Feb 13, 2020, 11:29:25 AM
    Author     : 794473 - Amitoj Singh
    Author     : 749300 - Lakhwinder Singh 
    Author     : 798125 - Ram Odedara
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>

        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" 
              integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" 
        integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
        <link rel="stylesheet" href="style/logincss.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>LOGIN</title>
    </head>
    <body>
        <header> 
            <div>
                <h1 class="col-lg" style="text-align: center ; margin-top: 2%; font-size: 60px " >
                    Cutey N' Coolty
                </h1>
            </div></header>

        <Form id="forgot-form" action="forgot" method="post">

            <h1 class="text-center">Password Recovery</h1>

            <div class="form-group">

                <Input class="form-control" id="text" name="femail" type="email"
                       placeholder="Email">

            </div>
            <br>
            <input type="submit" class="btn-lg btn-dark btn-block" value="RESET"> </input><br>
            <div class="text-center">
                <a href="/home">GO BACK</a>
            </div>
        </Form>
        <br><br><br><br><br>
        <hr>
        <!-- Footer -->
        <footer class="page-footer font-small ">

            <!-- Copyright -->
            <div class="footer-copyright text-center py-3">© 2020 Cutey & Coolty
            </div>
            <!-- Copyright -->

        </footer>
        <!-- Footer -->
    </body>


</html>
