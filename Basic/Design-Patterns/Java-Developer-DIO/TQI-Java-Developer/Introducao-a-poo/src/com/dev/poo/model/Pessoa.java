package com.dev.poo.model;

public class Pessoa {
    private static final int TAMANHO_CPF = 11;
    private static final int TAMANHO_CNPJ = 14;

    public enum TipoPessoa{FISICA, JURIDICA}
    public Integer codigo;
    public String nome;
    private String documento;
    public TipoPessoa tipo;

    public String getDocumento(){
        return this.documento;
    }
    public void setDocumento(String documento){
        if (documento == null || documento.isEmpty()){
            throw new RuntimeException("O numero do cocumento não pode ser nulo ou vazio");
        }
        if (documento.length() == TAMANHO_CPF){
            setDocumento(documento, TipoPessoa.FISICA);
        } else if(documento.length() == TAMANHO_CNPJ){
            setDocumento(documento, TipoPessoa.JURIDICA);
        } else {
            throw new RuntimeException("Documento invalido para pessoa FISICA/JURIDICA");
        }
    }

    private void setDocumento(String documento, TipoPessoa tipoPessoa){
        this.tipo = TipoPessoa.FISICA;
        this.documento = documento;
    }

}
