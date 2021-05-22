<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<!DOCTYPE html>
<html>

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
    <!--Fonts-->
    <script src="https://kit.fontawesome.com/3b1fe29ded.js" crossorigin="anonymous"></script>
</head>

<body>
    <style> 
     @import url('https://fonts.googleapis.com/css2?family=Open+Sans:wght@600&display=swap');
          *{
              margin:0;
              padding:0;
              box-sizing: border-box; 
          }
          .bg-img{
              background: url('Pictures/login.png');
              height:100vh;
              background-size: cover;
              background-position:center ;
              
          }
          .bg-img:after{
            position: absolute;
            content: '';
            top:0;
            left:0;
            height:100%;
            width:100%;
            background:rgb(0, 0, 0,0.1);
          }
          .content{
              position: absolute;
              top:50%;
              left:50%;
              transform: translate(-50%, -50%);
              text-align: center;
              z-index: 999;
              width: 370px;
              text-align: center;
              padding: 60px 32px;
              background:rgba(255,255,255,0.01);
              box-shadow: -1px 4px 28px 0px rgba(0,0,0,0.75);
          }
          .content header{
              color: black;
              font-size:33px;
              font-weight: 600;
              margin:0 0 35px 0;
              font-family: 'Open Sans', sans-serif;
          }
          .field{
              position: relative;
              height: 45px;
              width:100%;
              display: flex;
              background:rgba(255,255,255,0.94)
          }
          .field input{
              height:100%;
              width:100%;
              background: transparent;
              border:none;
              outline:none;
              font-size:16px;
              font-family: 'Open Sans', sans-serif;
          }
          .show{
              position: absolute;
              right:13px;
              font-size: 13px;
              font-weight: 700;
              color:#222;
              cursor: pointer;
              display: none;
              font-family: 'Open Sans', sans-serif;;
          }
          .space{
              margin-top:16px;
          }
          .field span{
              color: #222;
              width: 40px;
              line-height:45px;
          }
          .pass{
              text-align: left;
              margin:10px 0;
          }
          .pass a{
              color:black;
              font-family:'Open Sans', sans-serif;
              text-decoration: none;
          }
          .pass:hover a{
              text-decoration: underline;
          }
           #submit{
                  padding:12px 30px;
                  width:40%;
                  margin-top:40px;
                  background-color: white;
                  font-weight:bold;
                  border: none;
                  outline: none;
                  border-radius: 20px;
              }
         #submit:hover{
                  cursor:pointer;
                  background-color:rgb(65, 202, 202);
                  }
            .password:valid ~ .show{
                display:block;
            }
    </style>

    
<div class="bg-img">
    <div class="content">
        <header>Login</header>
        <form action="login" method="post">
            <div class="field">
                <span><i class="fas fa-user"></i></span>
                <input type="email" required placeholder="Enter Email" name="email">
            </div>
            <div class="field space">
                <span class="fa fa-lock"></span>
                <input type="password" class="password" required placeholder="Enter Password" id="Pass" name="password">
                <span class="show">Show</span>
            </div>
            <div class="pass">
                <a href="forgot.jsp">Forgot Password?</a>
            </div>
            <div>
             <input type="submit" value="Log in" id="submit">
            </div>
        </form>
    </div>
</div>
<script>
    const pass_field = document.querySelector('.password');
    const show_btn = document.querySelector('.show');
    show_btn.addEventListener('click',function () {
        if(pass_field.type == "password"){
            pass_field.type ="text";
            show_btn.style.color = "#222";
            show_btn.textContent = "Hide";
        }else{
            pass_field.type = "password";
            show_btn.style.color = "#222";
             show_btn.textContent = "Show";
        }
        
    });

</script>
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
