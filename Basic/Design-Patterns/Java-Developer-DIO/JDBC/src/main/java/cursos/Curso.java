package cursos;

public class Curso {

    private int id;
    private String nome;
    private int duracaoHoras;

    public Curso(int id, String nome, int duracaoHoras)
    {
        this.id = id;
        this.nome = nome;
        this.duracaoHoras = duracaoHoras;
    }

    public Curso(String nome, int duracaoHoras)
    {
        this.nome = nome;
        this.duracaoHoras = duracaoHoras;
    }

    public Curso() {}

    public int getId()
    {
        return this.id;
    }
    public void setId(int id)
    {
        this.id = id;
    }

    public String getNome()
    {
        return this.nome;
    }
    public void setNome(String nome)
    {
        this.nome = nome;
    }

    public int getDuracaoHoras()
    {
        return this.duracaoHoras;
    }
    public void setDuracaoHoras(int duracaoHoras)
    {
        this.duracaoHoras = duracaoHoras;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Curso{");
        sb.append("id=").append(id);
        sb.append(", nome='").append(nome).append('\'');
        sb.append(", Duracao Horas=").append(duracaoHoras);
        sb.append('}');
        return sb.toString();
    }
}
