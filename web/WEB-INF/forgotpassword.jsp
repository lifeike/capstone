<%-- 
    Document   : forgotpassword
    Created on : Mar 20, 2020, 1:01:44 PM
    Author     : 794473 - Amitoj Singh
    Author     : 749300 - Lakhwinder Singh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Account Recovery</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" 
              integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
        <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>

        <link rel="stylesheet" type="text/css" href="./style/logincss.css" />

        <title>forget</title>
    </head>
    <body>
       	<section id="hire">
            <h2 id="title" style="color: black">Cutey & Cooley</h2>
            <hr>

            <h4>Account Recovery</h4>
            <br>
            <br>
            <br>
            <Form id="forgot-form" action="forgot" method="post">
                <div class="field email-box">
                    <input name="email" type="email"/>
                    <label for="text">Email</label>
                    <span class="ss-icon">check</span>
                </div>
                <br>
                <input class="button" type="submit" value="RESET" />
                <input type="hidden" name="action" value="reset">
                <br>
                <br>
                <br>
                <div class="text-center">
                    <a href="/login">Log In</a>

                </div>
            </form>
        </section>
    </body>

    <!-- Footer -->
    <footer class="page-footer font-small " >

        <!-- Copyright -->
        <div class="footer-copyright text-center py-3">© 2020 Copyright:
            <a href="/home"> Cutey & Cooley</a>
        </div>
        <!-- Copyright -->

    </footer>
    <!-- Footer -->
</html>
