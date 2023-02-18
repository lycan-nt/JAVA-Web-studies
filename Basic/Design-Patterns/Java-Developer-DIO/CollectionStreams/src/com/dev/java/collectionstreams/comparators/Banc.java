package com.dev.java.collectionstreams.comparators;

public class Banc {
    private String titular;
    private String cpf;
    private String agencia;
    private String numeroConta;

    public Banc() { }

    public Banc(String titular, String cpf)
    {
        this.titular = titular;
        this.cpf = cpf;
    }

    public String getTitular()
    {
        return this.titular;
    }
    public void setTitular(String titular)
    {
        this.titular = titular;
    }

    public String getCpf()
    {
        return this.cpf;
    }
    public void setCpf(String cpf)
    {
        this.cpf = cpf;
    }

    public String getAgencia()
    {
        return this.agencia;
    }
    public void setAgencia(String agencia)
    {
        this.agencia = agencia;
    }

    public String getNumeroConta()
    {
        return this.numeroConta;
    }
    public void setNumeroConta(String numeroConta)
    {
        this.numeroConta = numeroConta;
    }

}
