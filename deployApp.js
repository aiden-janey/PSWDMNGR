const express = require('express');
const app = express();
var fs = require('fs');
var port = 8080;

app.get('/webpages/index.html', function (req, res) {
  res.writeHead(200, {'Content-Type': 'text/html'});
  res.end();
});

app.listen(port, function () {
  console.log("Server up on localhost:" + port);
})