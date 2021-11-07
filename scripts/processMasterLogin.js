//connect with jquer CDN
var script = document.createElement('script');
script.src = 'https://code.jquery.com/jquery-3.4.1.min.js';
script.type = 'text/javascript';
document.getElementsByTagName('head')[0].appendChild(script);

//grab parameters from index page
var mstrUser = $("#user").value;
var mstrPswd = $("#pswd").value;

//connect to mysql
var mysql = require('mysql');
var connect = mysql.createConnection({
    host: "localhost",
    user: "mysqlUser",
    password: "mysqlPassword",
    database: "PassStoreDB"
});

//query the table

//redirect using fs