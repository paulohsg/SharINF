package com.example.sharinf;

/**
 * Created by ilha1 on 07/02/2018.
 */

public class Aluno {

    private String nome;
    private String curso;
    private String colocacao;


    public Aluno(String nome, String curso, String colocacao) {
        this.nome = nome;
        this.curso = curso;
        this.colocacao = colocacao;
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public String getColocacao() {
        return colocacao;
    }

    public void setColocacao(String colocacao) {
        this.colocacao = colocacao;
    }

    @Override
    public String toString() {
        return "Curso: " + nome + " Curso: " +
                curso + " Colocação: " + colocacao;
    }

}
