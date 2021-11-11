//connect with jquery CDN
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
    user: "root",
    password: "W46t@9Vd8$X7",
    database: "PassStoreDB"
});

connect.connect(function (err) {
    if (err) throw err;
    console.log("Connection Established.")
    var sql = "SELECT * FROM master_login WHERE username = "+mstrUser+
    " AND passwd = "+mstrPswd+";";
    connect.query(sql, function(err, result, fields){
        if(result > 0)
            window.location.replace("localhost:8080/homepage.html")
    });
});
