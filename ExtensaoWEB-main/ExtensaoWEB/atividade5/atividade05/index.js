const express = require("express");
const bodyParser = require("body-parser");
const app = express();
const port = 3000;

app.use(bodyParser.urlencoded({ extended: false }));
app.use(express.static("public"));

// Rota principal que renderiza o formulário
app.get("/", (req, res) => {
    res.sendFile(__dirname + "/views/index.html");
});
app.get("/dados", (req, res) => {
  res.sendFile(__dirname + "/views/dados.html");
});
// Rota para receber os dados do formulário via POST e redirecionar para a página de dados
app.post("/dados", (req, res) => {
    const { nome, endereco, telefone, data } = req.body;
    res.redirect(`/dados?nome=${nome}&endereco=${endereco}&telefone=${telefone}&data=${data}`);
});

app.listen(port, () => {
    console.log(`Servidor rodando em http://localhost:${port}`);
});
