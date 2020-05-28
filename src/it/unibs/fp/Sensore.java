package it.unibs.fp;

public class Sensore {
    private String nome;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Sensore(String nome) {
        this.nome = nome;
    }

    //TODO PENSACI TU!!! :)
    public String rilevaVariabileFisica(){ return "";}

    @Override
    public String toString() {
        return "it.unibs.fp.Sensore{" +
                "nome='" + nome + '\'' +
                '}';
    }
}
