const express = require('express');
const app = express();
var fs = require('fs');
var port = 8080;

app.get('/', function (req, res) {
  fs.readFile('./webpages/index.html', function(err, data){
    res.writeHead(200, {'Content-Type': 'text/html'});
    res.write(data);
    res.end();
  });
});

app.listen(port, function () {
  console.log("Server up on localhost:" + port);
})