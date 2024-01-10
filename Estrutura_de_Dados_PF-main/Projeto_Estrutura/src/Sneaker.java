
public class Sneaker {
    private String nome;
    private String descricao;
    private double peso;
    private double valorCompra;
    private double valorVenda;
    private double valorLucro;
    private double percentualLucro;
    private Fabricante fabricante;

    public Sneaker(String nome, String descricao, double peso, double valorCompra, double valorVenda,
            Fabricante fabricante) {
        this.nome = nome;
        this.descricao = descricao;
        this.peso = peso;
        this.valorCompra = valorCompra;
        this.valorVenda = valorVenda;
        this.valorLucro = valorVenda - valorCompra;
        this.percentualLucro = (valorLucro / valorCompra) * 100;
        this.fabricante = fabricante;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public double getPeso() {
        return peso;
    }

    public double getValorCompra() {
        return valorCompra;
    }

    public double getValorVenda() {
        return valorVenda;
    }

    public double getValorLucro() {
        return valorLucro;
    }

    public double getPercentualLucro() {
        return percentualLucro;
    }

    public Fabricante getFabricante() {
        return fabricante;
    }
}
