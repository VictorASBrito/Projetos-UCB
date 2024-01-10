class Fabricante {
    private String nome;
    private String site;
    private String telefone;
    private String uf;

    public Fabricante(String nome, String site, String telefone, String uf) {
        this.nome = nome;
        this.site = site;
        this.telefone = telefone;
        this.uf = uf;
    }

    public String getNome() {
        return nome;
    }

    public String getSite() {
        return site;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getUf() {
        return uf;
    }
}