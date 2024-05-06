package projetofinal.LP2;

import java.util.*;

public class Instrutor extends Funcionario {

    private List<Aluno> alunosVinculados;

    public Instrutor(float salario, int faltas, String turno, String nome, String cpf, String DataNascimento, String rua, String bairro, String numero, String matricula) {
        super(salario, faltas, turno, nome, cpf, DataNascimento, rua, bairro, numero, matricula);
        this.alunosVinculados = new ArrayList<Aluno>();
    }

    public void vincularAluno(Aluno aluno) {
        try {
             alunosVinculados.add(aluno);
        } catch (Exception e) {
            System.err.println("Erro: " + e.getMessage());
        }
    }

    public void desvincularAluno(Aluno aluno) {
        try {
             alunosVinculados.remove(aluno);
        } catch (Exception e) {
            System.err.println("Erro: " + e.getMessage());
        }
    }

    public static void tipoTreino(String objetivo) { // função que será usada pelo aluno
        try {

            if (objetivo.equals("bulking")){//ganho de massa muscular
            System.out.println("1. Inclua exercícios compostos e isolados.");
            System.out.println("2. Aumente a carga progressivamente para desafiar os músculos.");
            System.out.println("3. Consuma um excedente calórico para apoiar o crescimento muscular.");
            System.out.println("4. Dieta rica em proteínas, carboidratos e gorduras saudáveis.");
            System.out.println("5. Faça refeições frequentes para manter um aporte constante de nutrientes.");
            System.out.println("6. Descanse e recupere-se adequadamente para evitar overtraining.");
            }
            else if (objetivo.equals("cutting")){//perda de peso
                System.out.println("1. Treino de musculação com foco em alta intensidade e repetições moderadas.");
                System.out.println("2. Inclua exercícios multiarticulares para manter a massa muscular.");
                System.out.println("3. Evite excesso de exercícios aeróbicos para não prejudicar a massa muscular.");
                System.out.println("4. Dieta controlada para um déficit calórico, focada em proteínas magras.");
                System.out.println("5. Hidratação adequada para apoiar o processo de queima de gordura.");
            }
            else if (objetivo.equals("condicionamento")){//melhora do condicionamento fisico
                System.out.println("1. Treinos variados, incluindo cardio e resistência.");
                System.out.println("2. Ênfase na melhoria da resistência cardiovascular e muscular.");
                System.out.println("3. Inclua exercícios de alta intensidade em intervalos (HIIT).");
                System.out.println("4. Trabalhe em movimentos funcionais para melhorar a coordenação e agilidade.");
                System.out.println("5. Mantenha uma dieta equilibrada com ênfase em alimentos nutritivos.");
                System.out.println("6. Certifique-se de descansar adequadamente para a recuperação.");
            }

        } catch (Exception e) {
            System.err.println("Erro: " + e.getMessage());//tratamento de erro
        }
    }

    //Calcula o salario do instrutor que é baseado no salario base + 40% se for integral + 25 reais por aluno vinculado
    @Override
    public float calcularSalario() {
        float total = getSalario();

        if (getTurno().equals("Integral")) {
            total += (total * 0.4);
        }

        int qtdAlunos = alunosVinculados.size();

        if (qtdAlunos >= 10) {
            total += qtdAlunos * 25;

        } else {
            total += qtdAlunos * 20;
        }

        total = (total / 30) * (30 - getFaltas());

        return total;
    }

    @Override
    public void imprimirAlunos() {
        System.out.println("Alunos vinculados ao instrutor " + getNome() + ":");
        for (Aluno aluno : alunosVinculados) {
            System.out.println("#############################################################");
            System.out.println("Aluno" + aluno.getNome() + ", Matrícula: " + aluno.getMatricula());
            System.out.println("CPF: " + aluno.getCpf());
        }
    }

    @Override
    public void setMatricula(String matricula) {
        this.matricula = getNome() + matricula;
    }
}
