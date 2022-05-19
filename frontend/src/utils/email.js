const http = require('http'); 
const express = require('express');
const app = express();
const bodyParser = require('body-parser');

app.use(require("cors")()); 
app.use(bodyParser.json());

app.get('/', (req, res, next) => {
    res.json({message: "Tudo ok por aqui!"});
})

app.post('/oivalfrs', (req, res, next) => { 
    const nome = req.body.nome;
    const email = req.body.email;
    const msg = req.body.msg;
    const telefone = req.body.telefone;
    const radioEmail = req.body.radioEmail;
    const radioTelefone = req.body.radioTelefone;
    const radioWhatsapp = req.body.radioWhatsapp;
    const receber = req.body.receber;

    require("./nodemail")(nome,
    email,
    msg,
    telefone,
    radioEmail,
    radioTelefone,
    radioWhatsapp,
    receber)
        .then(response => res.json(response))
        .catch(error => res.json(error));
}) 

const server = http.createServer(app); 
server.listen(3030);
console.log("Servidor escutando na porta 3030...")