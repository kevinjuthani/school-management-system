<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>New Password</title>
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/css/bootstrap.min.css"
        integrity="sha384-rwoIResjU2yc3z8GV/NPeZWAv56rSmLldC3R/AZzGRnGxQQKnKkoFVhFQhNUwEyJ" crossorigin="anonymous" />
    <!-- JQuery-->
    <script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk="
        crossorigin="anonymous"></script>
        
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
    
        
        #submit {
            
            padding: 12px 30px;
            width: 70%;
            margin-top: 40px;
            background-color: white;
            font-weight: bold;
            border: none;
            outline: none;
            border-radius: 20px;
            cursor:no-drop;
        }
    
        #submit:hover {
            cursor: pointer;
            background-color: rgb(65, 202, 202);
        }
        .container form .field{
            width:100%;
            height:45px;
            display:flex;
            margin: 15px 0;
            position: relative;
        }
        .container form .error-text{
            background: #F8D7DA;
            padding:8px 0;
            border-radius: 5px;
            color:#8B3E46;
            border:1px solid #F5C6Cb;
            display:none;
        }
        .container form .error-text.matched{
        background: #D4EDDA;
        color:#588C64;
        border:#C3E6CB;
        }
        body{
            text-align: center;
            background:url('Pictures/Otherbg.png');
            height:100vh;
            background-size: cover;
            background-position:center ;
            background-position: absolute;
        }
        form button.active:hover{
            background: rgb(65, 202, 202);
        }
        form button.active{
             cursor: pointer;
             opacity: 1;
             transition: all 0.3s;
         }
         form .field .show{
             position: absolute;
             right:10px;
             top:50%;
             transform: translateY(-50%);
             font-size: 14px;
             font-weight: 600;
             user-select: none;
             cursor: pointer;
             display: none;
         }
         form .field .show .active{
             color: rgb(65, 202, 202);
         }
        
    </style>
  
    <div class="container">
    
    <form action="setpassword" method="put">
        <div class="box">
       <div class="inner-box">
        <h5 style="text-align: center;">Set a new password:</h5>
        <div class="error-text"></div>
        <div class="field">
            <input onkeyup="active()" type="password" id="newPass"  class="form-control" placeholder="New password" name="newpassword">
            <label data-error="wrong" data-success="right" for="newPass"></label>
            
        </div>
    
        <div class="field">
            
            <input onkeyup="active_2()"  type="password" id="newPassConfirm" class="form-control" placeholder="Confirm password" name="confirmpassword" disabled>
            <label data-error="wrong" data-success="right" for="newPassConfirm"></label>
            <div class="show">Show</div>
        </div>
        </div>
        <button disabled type="submit" value="Change Password" href="#" id="submit" >Change Password</button>
        </div>
        
    
    </form>
    </div>
    
    <script>
        const np = document.querySelector("#newPass");
        const npc = document.querySelector("#newPassConfirm");
        const errorText = document.querySelector(".error-text");
        const Showbtn = document.querySelector(".show");
        const btn = document.querySelector("button");

        function active() {
            if (np.value.length >= 6) {
                btn.removeAttribute("disabled", "");
                btn.classList.add("active");
                npc.removeAttribute("disabled", "");
            } else {
                btn.setAttribute("disabled", "");
                btn.classList.remove("active");
                npc.setAttribute("disabled", "");
            }
        }
        btn.onclick = function () {
            if (np.value != npc.value) {
                errorText.style.display = "block";
                errorText.style.display = "block";
                errorText.classList.remove("matched");
                errorText.textContent = "Confirm Password did not match";
                return false;
            } else {
                errorText.style.display = "block";
                errorText.classList.add("matched");
                errorText.textContent = "Confirm Password Matched";
                return true;
            }
        }
        function active_2() {
            if (npc.value != "") {
                Showbtn.style.display = "block";
                Showbtn.onclick = function () {
                    if ((np.type == "password")&&(npc.type == "password")){
                        np.type = "text";
                        npc.type = "password";
                        this.textContent = "Hide";
                        this.classList.add("active");
                    }else{
                        np.type = "password";
                        npc = "password";
                        this.textContent = "Show";
                        btn.classList.remove("active");
                    }

                }

            } else {
                Showbtn.style.display = "none";
            }
        }

    </script>
    
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
    

