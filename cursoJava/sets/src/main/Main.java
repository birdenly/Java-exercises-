import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import CursoJava.sets.src.ententies.Turma;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("How many students for course A?");
        int amountA = sc.nextInt();
        List<Integer> alunosA = new ArrayList<>();
        sc.nextLine();
        for(int i = 0; i < amountA; i++){
            int aluno = sc.nextInt();
            sc.nextLine();
            alunosA.add(aluno);

        }
        Turma turmaA = new Turma("A", alunosA);

        System.out.print("How many students for course B?");
        int amountB = sc.nextInt();
        List<Integer> alunosB = new ArrayList<>();
        sc.nextLine();
        for(int i = 0; i < amountB; i++){
            int aluno = sc.nextInt();
            sc.nextLine();
            alunosB.add(aluno);

        }
        Turma turmaB = new Turma("B", alunosB);

        System.out.print("How many students for course C?");
        int amountC = sc.nextInt();
        List<Integer> alunosC = new ArrayList<>();
        sc.nextLine();
        for(int i = 0; i < amountC; i++){
            int aluno = sc.nextInt();
            sc.nextLine();
            alunosC.add(aluno);

        }
        Turma turmaC = new Turma("C", alunosC);
        
        Set<Integer> set = new HashSet<>(turmaA.getAlunos());

        set.addAll(turmaB.getAlunos());
        set.addAll(turmaC.getAlunos());

        System.out.println("Total alunos: " +  set.size());
        sc.close();

    }
}
