<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Admin | Home</title>
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/css/bootstrap.min.css"
        integrity="sha384-rwoIResjU2yc3z8GV/NPeZWAv56rSmLldC3R/AZzGRnGxQQKnKkoFVhFQhNUwEyJ" crossorigin="anonymous" />
    <!-- JQuery-->
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"
        integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
    <script src="https://kit.fontawesome.com/3b1fe29ded.js" crossorigin="anonymous"></script>

</head>

<body>
    <style>
        @import url('https://fonts.googleapis.com/css2?family=Open+Sans:wght@600&display=swap');

        * {
            margin: 0;
            list-style: none;
            padding: 0;
            text-decoration: none;
            box-sizing: border-box;
            font-family: 'Open Sans', sans-serif;

        }

        body {
            background-color: white;
        }

        .wrapper {
            margin: 10px;
        }

        .wrapper .top_navbar {
            width: calc(100% - 20px);
            height: 60px;
            display: flex;
            position: fixed;
            top: 10px;
        }

        .wrapper .top_navbar .hamburger {
            width: 70px;
            height: 100%;
            background: #c0a1ef;
            padding: 15px 17px;
            border-top-left-radius: 20px;
            cursor: pointer;
        }

        .wrapper .top_navbar .hamburger div {
            width: 35px;
            height: 4px;
            background: #ffde59;
            margin: 5px;
            border-radius: 5px;
        }

        .wrapper .top_navbar .top_menu {
            width: calc(100% - 70px);
            background: whitesmoke;
            height: 100%;
            border-top-right-radius: 20px;
            display: flex;
            justify-content: space-between;
            align-items: center;
            padding: 0 20px;
            box-shadow: 0 1px 1px rgba(0, 0, 0, 0.1);
        }

        .wrapper .top_navbar .top_menu .logo {
            color: #2e4ead;
            font-size: 20px;
            font-weight: 700;
            letter-spacing: 2px;
        }

        .wrapper .top_navbar .top_menu ul {
            display: flex;
        }

        .wrapper .top_navbar .top_menu ul li a {
            display: block;
            margin: 0 10px;
            margin-top: 20px;
            width: 35px;
            height: 35px;
            line-height: 35px;
            border: 1px solid #c0a1ef;
            text-align: center;
            border-radius: 50%;
            color: #ffde59;

        }

        .wrapper .top_navbar .top_menu ul li a:hover {
            background: #c0a1ef;
            color: #fff;
        }

        i {
            color: #ffde59;
        }

        .wrapper .sidebar {
            position: fixed;
            top: 70px;
            left: 10px;
            background: #c0a1ef;
            width: 200px;
            height: calc(100% - 80px);
            border-bottom-left-radius: 20px;
            transition: all 0.3s ease;

        }
        .wrapper .top_navbar .top_menu ul .admin{
            font-family: 'Open Sans', sans-serif;
            margin:0 10px;
            margin-top:25px;
            font-weight:200;
        }

        .wrapper .sidebar ul li a {
            display: block;
            padding: 20px;
            position: relative;
            margin-bottom: 1px;
            color: #ffde59;
            white-space: nowrap;
        }

        .wrapper .sidebar ul li a:before {
            content: "";
            position: absolute;
            top: 0;
            left: 0;
            width: 3px;
            height: 100%;
            background: turquoise;
            display: none;
        }

        .wrapper .sidebar ul li a span.icon {
            margin-right: 10px;
            display: inline-block;
            align-items: center;
        }

        .wrapper .sidebar ul li a span.title {
            display: inline-block;
        }

        .wrapper .sidebar ul li a:hover,
        .wrapper .sidebar ul li a.active {
            background: #00c2cb;
            color: #fff;
        }

        .wrapper .sidebar ul li a:hover:before,
        .wrapper .sidebar ul li a.active:before {
            display: block;
        }

        .wrapper .main_container {
            width: calc(100% - 200px);
            margin-top: 70px;
            margin-left: 200px;
            padding: 15px;
            transition: all 0.3s ease;
        }

        .wrapper .main_container .item {
            background:#fff;
            margin-bottom: 10px;
            padding: 15px;
            font-size: 14px;
            line-height: 22px;
        }

        .wrapper .sidebar.collapse {
            width: 70px;
        }

        .wrapper .sidebar.collapse ul li a {
            text-align: center;
        }

        .wrapper .sidebar .collapse ul li a span.icon {
            margin: 0;
        }

        .wrapper .sidebar .collapse ul li a span.title {
            display: none;
        }

        .wrapper .sidebar .collapse .main_container {
            width: (100% - 70px);
            margin-left: 70px;
        }

        .wrapper .top_navbar .top_menu ul .dropdown {
            position: absolute;
            margin-top: 72px;
            right: 0;
            background: whitesmoke;
            padding: 10px;
            border-radius: 10px;
        }

        .wrapper .top_navbar .top_menu ul .dropdown .dropdown-item {
            color: #ffde59;
            white-space: nowrap;
        }

        .wrapper .top_navbar .top_menu ul .dropdown .dropdown-item:hover {
            background: #00c2cb;
            color: #fff;
        }
    </style>
    <div class="wrapper">
        <div class="top_navbar">
            <div class="hamburger" id="hamburger">
                <div></div>
                <div></div>
                <div></div>
            </div>
            <div class="top_menu">
                <div class="logo">School Management System</div>
                <ul>
                    <li><a href="#"><i class="far fa-bell"></i></a></li>
                    <li><a href="#" id="user-dropdown"><i class="far fa-user"></i><i class="fas fa-sort-up"
                                style="display:none" id="sort-up"></i><i class="fas fa-sort-down"
                                id="sort-down"></i></a></li>
                    <div class="dropdown" style="display:none;" id="user-menu">
                        <a href="#" class="dropdown-item">
                            <i class="fas fa-id-card"></i>
                            Account</a>
                        <hr>
                        <a href="#" class="dropdown-item">
                            <i class="fas fa-envelope"></i>
                            Messages
                        </a>
                        <hr>
                        <a href="#" class="dropdown-item">
                            <i class="fas fa-cogs"></i>
                            Settings
                        </a>
                        <hr>
                        <a href="#" class="dropdown-item">
                            <i class="fas fa-sign-out-alt"></i>
                            Sign out
                        </a>
                    </div>
                    <div class="admin">| Admin</div>
                </ul>

            </div>
        </div>
        <div class="sidebar" id="sidebar">
            <ul>
                <li><a href="#" class="active">
                        <span class="icon"><i class="fas fa-stream" aria-hidden="true"></i></span>
                        <span class="title">Dashboard</span>
                    </a></li>
                <li><a href="#">
                        <span class="icon"><i class="fas fa-user-plus" aria-hidden="true"></i></span>
                        <span class="title">Add User</span>
                    </a></li>
                <li><a href="#">
                        <span class="icon"><i class="fas fa-chalkboard-teacher" aria-hidden="true"></i></span>
                        <span class="title">Teachers</span>
                    </a></li>
                <li><a href="#">
                        <span class="icon"><i class="fas fa-user-graduate" aria-hidden="true"></i></span>
                        <span class="title">Students</span>
                    </a></li>
                <li><a href="#">
                        <span class="icon"><i class="fas fa-file-alt" aria-hidden="true"></i></span>
                        <span class="title">Notice</span>
                    </a></li>

            </ul>

        </div>
        <div class="main_container">
            <div class="item">
                Lorem ipsum dolor, sit amet consectetur adipisicing elit. Rerum, alias.
                Voluptate maxime accusamus debitis fugiat aspernatur quod dicta tempore consequuntur iste, quaerat
                blanditiis
                ex vero asperiores ipsam est nam iusto!
            </div>
            <div class="item">
                Lorem ipsum dolor, sit amet consectetur adipisicing elit. Rerum, alias.
                Voluptate maxime accusamus debitis fugiat aspernatur quod dicta tempore consequuntur iste, quaerat
                blanditiis
                ex vero asperiores ipsam est nam iusto!
            </div>
            <div class="item">
                Lorem ipsum dolor, sit amet consectetur adipisicing elit. Rerum, alias.
                Voluptate maxime accusamus debitis fugiat aspernatur quod dicta tempore consequuntur iste, quaerat
                blanditiis
                ex vero asperiores ipsam est nam iusto!
            </div>
            <div class="item">
                Lorem ipsum dolor, sit amet consectetur adipisicing elit. Rerum, alias.
                Voluptate maxime accusamus debitis fugiat aspernatur quod dicta tempore consequuntur iste, quaerat
                blanditiis
                ex vero asperiores ipsam est nam iusto!
            </div>
        </div>
    </div>
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
        integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
        crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
        integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
        crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
        integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
        crossorigin="anonymous"></script>
    <script>
        $("#hamburger").on("click", function () {
            if ($("#sidebar").width() === 200) {
                $("#sidebar").width(70);
                $(".title").hide();
                $(".main_container").css('margin-left', $("#sidebar").width() - 130);

            }
            else {
                $("#sidebar").width(200);
                $(".title").show();
                $(".main_container").css('margin-left', $("#sidebar").width() + 130);

            }

        });
        $("#user-dropdown").on("click", function () {
            if ($("#user-menu").is(":visible")) {
                console.log("visible");
                $("#user-menu").hide();
                $("#sort-up").hide();
                $("#sort-down").show();
            }
            else {
                console.log("not visible");
                $("#user-menu").show();
                $("#sort-up").show();
                $("#sort-down").hide();

            }

        });
    </script>

</body>

</html>
