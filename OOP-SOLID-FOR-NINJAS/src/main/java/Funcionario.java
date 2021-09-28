public class Funcionario {
    private String nome;
    private String cargo;
    private double salarioBase;

    public Funcionario() {}

    public Funcionario(String nome, String cargo, double salarioBase)
    {
        this.nome = nome;
        this.cargo = cargo;
        this.salarioBase = salarioBase;
    }

    public String getNome()
    {
        return this.nome;
    }
    public void setNome(String nome)
    {
        this.nome = nome;
    }

    public String getCargo()
    {
        return this.cargo;
    }
    public void setCargo(String cargo)
    {
        this.cargo = cargo;
    }

    public double getSalarioBase()
    {
        return this.salarioBase;
    }
    public void setSalarioBase(double salarioBase)
    {
        this.salarioBase = salarioBase;
    }

}
