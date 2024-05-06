package projetofinal.LP2;

import java.util.*;

public abstract class Funcionario extends Pessoa {

    protected float salario;
    protected int faltas;
    protected String turno;
    public List<Aluno> alunosAcademia;

    public Funcionario(float salario, int faltas, String turno, String nome, String cpf, String DataNascimento, String rua, String bairro, String numero, String matricula) {
        super(nome, cpf, DataNascimento, rua, bairro, numero, matricula);
        this.salario = salario;
        this.faltas = faltas;
        this.turno = turno;
        this.alunosAcademia = new ArrayList<Aluno>();
    }

    public void setSalario(float salario) {
        this.salario = salario;
    }

    public float getSalario() {
        return this.salario;
    }

    public void setFaltas(int faltas) {
        this.faltas = faltas;
    }

    public int getFaltas() {
        return this.faltas;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    public String getTurno() {
        return this.turno;
    }
    //Métodos abstratos para serem implementados nas classes filhas.
    public abstract float calcularSalario();

    public abstract void imprimirAlunos();

}
