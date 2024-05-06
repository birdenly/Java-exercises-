package projetofinal.LP2;
import java.util.*;

public class Gerente extends Funcionario {
    private double tetoDeGastos; // valor máximo que o gerente pode gastar
    private double bonus = 0.2;  // gratificação de + 20% no salário pela função de gerente
    public List<Instrutor> InstrutoresVinculados;
    public List<Recepcionista> RecepcionistasVinculados;

    public Gerente (float salario, int faltas, String turno, String nome, String cpf, String DataNascimento, String rua, String bairro, String numero, String matricula, double tetoDeGastos) {
        super(salario, faltas, turno, nome, cpf, DataNascimento, rua, bairro, numero, matricula);
        this.tetoDeGastos = tetoDeGastos;
        this.InstrutoresVinculados = new ArrayList<Instrutor>(); ;
        this.RecepcionistasVinculados= new ArrayList<Recepcionista>();
    }

    @Override
    public void setMatricula(String matricula) {
        try {
            int space = getNome().indexOf(" ");
            this.matricula = getNome().substring(0, space) + matricula;
        } catch (Exception e) {
            System.err.println("Erro: " + e.getMessage());
        }
    }

    public void setTetoDeGastos(double tetoDeGastos) {
        this.tetoDeGastos = tetoDeGastos;
    }

    public double getTetoDeGastos() {
        return tetoDeGastos;
    }

    public double getBonus() {
        return bonus;
    }

    @Override
    public float calcularSalario() {
        float total = getSalario();

        if (getTurno().equals("Integral")) {
            total += (total * 0.4);
        }

        total *= (1 + getBonus());

        total = (total / 30) * (30 - getFaltas());

        return total;
    }

    public void comprarAparelho(float aparelho) { // recebe o preço do aparelho
        if (aparelho <= tetoDeGastos) {
            setTetoDeGastos(getTetoDeGastos() - aparelho);
            System.out.println("Aparelho comprado com sucesso!");
        } else {
            System.out.println("Não há dinheiro suficiente para comprar o aparelho!");
        }
    }

    public void contratarFuncionarios(Funcionario funcionario) {
        try {

            if (funcionario instanceof Instrutor){
            if (funcionario.getSalario() <= tetoDeGastos) {
                setTetoDeGastos(getTetoDeGastos() - funcionario.getSalario());
                InstrutoresVinculados.add((Instrutor) funcionario);
                System.out.println("Funcionário contratado com sucesso!");
            } else {
                System.out.println("Não há dinheiro suficiente para contratar o funcionário!");
            } 
            }
            else if (funcionario instanceof Recepcionista){
                if (funcionario.getSalario() <= tetoDeGastos) {
                    setTetoDeGastos(getTetoDeGastos() - funcionario.getSalario());
                    RecepcionistasVinculados.add((Recepcionista) funcionario);
                    System.out.println("Funcionário contratado com sucesso!");
                } else {
                    System.out.println("Não há dinheiro suficiente para contratar o funcionário!");
                }
            }

        } catch (Exception e) {
            System.err.println("Erro: " + e.getMessage()); // caso ocorra algum erro, imprime a mensagem de erro.
        }
    }

    public void demitirFuncionarios(Funcionario funcionario) {
        try {

            if (funcionario instanceof Instrutor){
            InstrutoresVinculados.remove((Instrutor) funcionario);
            }
            else if (funcionario instanceof Recepcionista){
                RecepcionistasVinculados.remove((Recepcionista) funcionario);
            }

            setTetoDeGastos(getTetoDeGastos() + funcionario.getSalario());
            System.out.printf("Funcionário " + funcionario.getNome() + " de Matricula " + funcionario.getMatricula() + " foi demitido com sucesso!");
            
        } catch (Exception e) {
            System.err.println("Erro: " + e.getMessage());
        }
    }
    //Funções de impressão.
    @Override
    public void imprimirAlunos() {
        System.out.println("Alunos matriculados na academia:");
        for (Aluno aluno : alunosAcademia) {
            System.out.println("#############################################################");
            System.out.println("Aluno " + aluno.getNome() + ", Matrícula: " + aluno.getMatricula());

            System.out.println("CPF: " + aluno.getCpf());
            System.out.println("Data de Nascimento: " + aluno.getDataNascimento());

            System.out.println("Endereço:");
            System.out.println("Rua: " + aluno.endereco.rua + ", Bairro: " + aluno.endereco.bairro + ", Número: " + aluno.endereco.numero);
            
        }
    }

    public void imprimirInstrutores() {
        System.out.println("Instrutores cadastrados:");
        for (Instrutor instrutor : InstrutoresVinculados) {
            System.out.println("#############################################################");
            System.out.println("Instrutor " + instrutor.getNome() + ", Matrícula: " + instrutor.getMatricula());

            System.out.println("CPF: " + instrutor.getCpf());
            System.out.println("Data de Nascimento: " + instrutor.getDataNascimento());

            System.out.println("Endereço:");
            System.out.println("Rua: " + instrutor.endereco.rua + ", Bairro: " + instrutor.endereco.bairro + ", Número: " + instrutor.endereco.numero);
        }
    }

    public void imprimirRecepcionistas() {
        System.out.println("Recepcionistas cadastrados:");
        for (Recepcionista recepcionista : RecepcionistasVinculados) {
            System.out.println("#############################################################");
            System.out.println("Recepcionista " + recepcionista.getNome() + ", Matrícula: " + recepcionista.getMatricula());

            System.out.println("CPF: " + recepcionista.getCpf());
            System.out.println("Data de Nascimento: " + recepcionista.getDataNascimento());

            System.out.println("Endereço:");
            System.out.println("Rua: " + recepcionista.endereco.rua + ", Bairro: " + recepcionista.endereco.bairro + ", Número: " + recepcionista.endereco.numero);
        }
    }

    public void imprimirTodosFuncionarios() {
        System.out.println("Funcionários da academia:");
        for (Recepcionista recepcionista : RecepcionistasVinculados) {
            System.out.println("#############################################################");
            System.out.println("Recepcionista " + recepcionista.getNome() + ", Matrícula: " + recepcionista.getMatricula());

            System.out.println("CPF: " + recepcionista.getCpf());
            System.out.println("Data de Nascimento: " + recepcionista.getDataNascimento());

            System.out.println("Endereço:");
            System.out.println("Rua: " + recepcionista.endereco.rua + ", Bairro: " + recepcionista.endereco.bairro + ", Número: " + recepcionista.endereco.numero);
        }

        for (Instrutor instrutor : InstrutoresVinculados) {
            System.out.println("#############################################################");
            System.out.println("Instrutor " + instrutor.getNome() + ", Matrícula: " + instrutor.getMatricula());

            System.out.println("CPF: " + instrutor.getCpf());
            System.out.println("Data de Nascimento: " + instrutor.getDataNascimento());

            System.out.println("Endereço:");
            System.out.println("Rua: " + instrutor.endereco.rua + ", Bairro: " + instrutor.endereco.bairro + ", Número: " + instrutor.endereco.numero);
        }
        
        System.out.println("Gerente " + getNome() + ", Matrícula: " + getMatricula());
    }
    
}