package revisao;

public class Produto {
    private int cod;
    private String nome;
    private double preco;
    private int qnt;

    public Produto(int cod, String nome, double preco, int qnt) {
        this.cod = cod;
        this.nome = nome;
        this.preco = preco;
        this.qnt = qnt;
    }

    public int getCod() {
        return cod;
    }

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    } 
    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getQnt() {
        return qnt;
    }

    public void setQnt(int qnt) {
        this.qnt = qnt;
    }

    @Override
    public String toString() {
        return this.cod+";"+this.nome+";"+this.preco+";"+this.qnt;
    }
    
    
    
}
