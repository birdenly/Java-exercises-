package CursoJava.sets.src.ententies;

import java.util.List;

public class Turma {
    private String nome;
    private List<Integer> alunos;

    public Turma(String nome, List<Integer> alunos) {
        this.nome = nome;
        this.alunos = alunos;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public List<Integer> getAlunos() {
        return alunos;
    }
    public void setAlunos(List<Integer> alunos) {
        this.alunos = alunos;
    }

}
