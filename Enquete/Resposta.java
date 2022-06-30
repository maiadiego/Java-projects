package Enquete;

public class Resposta{
    private int qtdPessoas;
    private double rendaTotal;
    private String estado;
    
    public Resposta(int qtdPessoas, double rendaTotal, String estado) {
        this.qtdPessoas = qtdPessoas;
        this.rendaTotal = rendaTotal;
        this.estado = estado;
    }

    public int getQtdPessoas() {
        return qtdPessoas;
    }

    public double getRendaTotal() {
        return rendaTotal;
    }

    public String getEstado() {
        return estado;
    }
}
