<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <title>Login | Home</title>
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/css/bootstrap.min.css"
        integrity="sha384-rwoIResjU2yc3z8GV/NPeZWAv56rSmLldC3R/AZzGRnGxQQKnKkoFVhFQhNUwEyJ" crossorigin="anonymous" />
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

        .inner-box {
            padding: 20px;
        }

        .box {
            padding: 12px;
            margin-top: 15px;
            width: 400px;
            margin: 0 auto;
            background:rgba(255,255,255,0.01);
            box-shadow: -1px 4px 28px 0px rgba(0,0,0,0.75);
            margin-top: 100px;
            position: relative;
        }
    
        input[type="email"] {
            padding: 12px 30px;
            width: 100%;
            padding: 10px;
            margin: 10px 0px;
            margin-top: 20px;
            border-radius: 20px;
        }

        #submit {
            padding: 12px 30px;
            width: 70%;
            margin-top: 40px;
            background-color: white;
            font-weight: bold;
            border: none;
            outline: none;
            border-radius: 20px;
        }

        #submit:hover {
            cursor: pointer;
            background-color: rgb(65, 202, 202);
        }

        body {
            text-align: center;
             text-align: center; 
             background:url('Pictures/Otherbg.png');
            height:100vh;
            background-size: cover;
            background-position:center ;
            background-position: absolute;
           
        }
    </style>
    <div class="box">
        <div class="inner-box">
           <b> <h3>Email Verification Link Has Been Sent.</h3></b>
            <p style="text-align: center;">We have send a verification code. Please verify your code here.</p>
        <form action="recoverpassword" method="post">
            <input type="code" placeholder="Code:" name="code">
            <button name="Verify" id="submit" href="#" >Verify</button>
        </form>
        </div>

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
