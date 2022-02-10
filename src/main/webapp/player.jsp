
<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "https://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Alien Data From</title>

<style>

        body{
            background-color: rgb(225, 231, 233);
        }
        #head-out{
            background-color: rgb(225, 226, 214);
            height: 80px;
            text-align: center;
            border-bottom:2px solid rgb(149, 156, 156);
            padding-top: 30px;
        }

        #heading{
            color: rgb(84, 104, 104);
            text-decoration:overline;
            text-shadow: 3px 1px 3px rgb(158, 124, 243);
        }

        #menu{
            margin-top: 60px;
            height: 200px;
            background-color: rgb(222, 229, 243);
            
        }
        #team{
            display: block;
            margin-left: auto;
            margin-right: auto;
            width: 40%;
            

        }
        #player{
            display: block;
            margin-left: auto;
            margin-right: auto;
            width: 40%;
        }
        #teambtn{
            background-color: rgb(161, 195, 214);
            height: 40px;
            width: 90%;
            border:0.1px solid transparent;
            border-radius: 10px;
            margin-top: 50px;
            font-family: 'Times New Roman', Times, serif;
            font-weight: bold;

        }
        #teambtn:hover{
            border:4px solid transparent;
            border-radius: 14px;
            background-color: rgb(120, 165, 192);
            border-bottom: 5px solid rgb(201, 176, 176);
            
            
        }
        #playerbtn{
            background-color: rgb(161, 195, 214);
            height: 40px;
            width: 90%;
            border:0.1px solid transparent;
            border-radius: 10px;
            margin-top: 10px;
            font-family: 'Times New Roman', Times, serif;
            font-weight: bold;

        }
        #playerbtn:hover{
            border:4px solid transparent;
            border-radius: 14px;
            background-color: rgb(120, 165, 192);
            border-bottom: 5px solid rgb(201, 176, 176);

            
        }
        </style>
</head>
<%@ page import="java.util.Date" %>
<body>

<header>
        <div id="head-out">
            <div id="head-in">
                <h2 id="heading">
                    Football Team management
                </h2>
            </div>
        </div>
    </header>



    <div id="menu">
    <div id="player">
       
            Player Data
        
             
            <input type="submit" value="For Player" id="playerbtn">
        </div>
    </div>


</body>
</html>

