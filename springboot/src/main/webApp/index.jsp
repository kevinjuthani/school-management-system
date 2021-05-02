<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
    <!DOCTYPE html>
    <html lang="en">

    <head>
        <!-- Required meta tags -->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <title>Login | Home</title>
        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/css/bootstrap.min.css"
            integrity="sha384-rwoIResjU2yc3z8GV/NPeZWAv56rSmLldC3R/AZzGRnGxQQKnKkoFVhFQhNUwEyJ"
            crossorigin="anonymous" />
        <!-- JQuery-->
        <script src="https://code.jquery.com/jquery-3.6.0.js"
            integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
    </head>

    <body>
        <style>
            * {
                margin: 0;
                padding: 0;
                box-sizing: border-box;
            }

            /*container*/
            .container {
                display: flex;
                height: 500px;
                width: 800px;
                /*border: 1px solid black;*/
                margin: auto;
                margin-top: 100px;
                box-shadow: 15px 15px 20px black;
            }

            /*Login Form */
            .form {
                display: flex;
                flex-direction: column;
                width: 50%;
                align-items: center;
                background-color: whitesmoke;
            }

            .form h2 {
                font-size: 3rem;
                font-family: Impact, Haettenschweiler, 'Arial Narrow Bold', sans-serif;
                margin: 40px;
            }

            .box {
                padding: 12px;
                width: 65%;
                margin: 15px;
                border: 1px solid black;
                outline: none;
                border-radius: 20px;
            }

            #submit {
                padding: 12px 30px;
                width: 40%;
                margin-top: 40px;
                background-color: white;
                font-weight: bold;
                border: none;
                outline: none;
                border-radius: 20px;
            }

            #submit:hover {
                cursor: pointer;
                background-color: turquoise;
            }

            .form a {
                text-decoration: none;
                color: black;
                margin-top: 20px;
            }

            .form a:hover {
                color: blanchedalmond;
            }

            /*Right Side*/
            .side {
                display: flex;
                justify-content: center;
                align-items: center;
                width: 50%;
                background-color: teal;
            }

            .side img {
                width: 350px;
                height: 450px;
            }

            body {
                background-color: teal;
            }
        </style>
        <div class="container">

            <form action="" class="form">
                <h2>WELCOME</h2>
                <input type="email" name="email" class="box" placeholder="Enter Email">
                <input type="password" name="password" class="box" placeholder="Enter Password">
                <input type="submit" value="Sign in" id="submit">
                <a href="#">Forgot Password?</a>
            </form>
            <div class="side">
                <img src="https://previews.123rf.com/images/ellagrin/ellagrin1510/ellagrin151000043/46202952-back-to-school-doodle-set-concept-background-education-.jpg"
                    alt="" </div>
            </div>
            <!-- jQuery first, then Tether, then Bootstrap JS. -->
            <script src="https://code.jquery.com/jquery-3.1.1.slim.min.js"
                integrity="sha384-A7FZj7v+d/sdmMqp/nOQwliLvUsJfDHW+k9Omg/a/EheAdgtzNs3hpfag6Ed950n"
                crossorigin="anonymous"></script>
            <script src="https://cdnjs.cloudflare.com/ajax/libs/tether/1.4.0/js/tether.min.js"
                integrity="sha384-DztdAPBWPRXSA/3eYEEUWrWCy7G5KFbe8fFjk5JAIxUYHKkDx6Qin1DkWx51bBrb"
                crossorigin="anonymous"></script>
            <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/js/bootstrap.min.js"
                integrity="sha384-vBWWzlZJ8ea9aCX4pEW3rVHjgjt7zpkNpZk+02D9phzyeVkE+jo0ieGizqPLForn"
                crossorigin="anonymous"></script>
    </body>

    </html>