package Curso;

import java.sql.Time;

public class Curso {
    private int id;
    private String nome;
    private String dataHora;

    public Curso(){}

    public Curso(String nome, String dataHora) {
        this.nome = nome;
        this.dataHora = dataHora;
    }

    public Curso(int id, String nome, String dataHora) {
        this.id = id;
        this.nome = nome;
        this.dataHora = dataHora;
    }

    public int getId() {
        return this.id;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDataHora() {
        return this.dataHora;
    }

    public void setDataHora(String dataHora) {
        this.dataHora = dataHora;
    }

    @Override
    public String toString() {
        return "Curso{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", dataHora=" + dataHora +
                '}';
    }
}
