package projetofinal.LP2;

public class Recepcionista extends Funcionario {

    public Recepcionista(float salario, int faltas, String turno, String nome, String cpf, String DataNascimento, String rua, String bairro, String numero, String matricula) {
        super(salario, faltas, turno, nome, cpf, DataNascimento, rua, bairro, numero, matricula);
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

    @Override
    public float calcularSalario() {
        float total = getSalario();

        if (getTurno().equals("Integral")) {
            total += (total * 0.4);
        }

        total = (total / 30) * (30 - getFaltas());

        return total;
    }

    @Override
    public void imprimirAlunos() {
        System.out.println("Listando todos os alunos matriculados na academia:");
        for (Aluno aluno : alunosAcademia) {
            System.out.println("#############################################################");
            System.out.println("Aluno: " + aluno.getNome() + ", Matrícula: " + aluno.getMatricula());
            System.out.println("CPF: " + aluno.getCpf());
        }
    }

    public void matricularAluno(Aluno aluno) {
        try {

            for (Aluno alunosRegistrado : alunosAcademia) {
                if (alunosRegistrado.getCpf().equals(aluno.getCpf()) || alunosRegistrado.getMatricula().equals(aluno.getMatricula())) {
                    System.out.println("Aluno já matriculado na academia. CPF ou Matricula já utilizada.");
                    break;
                }
            }
        alunosAcademia.add(aluno);

        } catch (Exception e) {
            System.err.println("Erro: " + e.getMessage());
        }
    }

    public void cancelarMatricula(String cpf) {
        try {

            Aluno removido = retornaAluno(cpf);
            if (removido.equals(null)){
                System.out.println("Aluno não encontrado.");
            }
            else{
                alunosAcademia.remove(retornaAluno(cpf));
                System.out.println("Aluno desmatriculado.");
            }

        } catch (Exception e) {
            System.err.println("Erro: " + e.getMessage());
        }
    }

    public Aluno retornaAluno(String cpf){  //retorna o aluno caso ele esteja matriculado
        for (Aluno alunosRegistrado : alunosAcademia) {
            if (alunosRegistrado.getCpf().equals(cpf) || alunosRegistrado.getMatricula().equals(cpf)) {
                return alunosRegistrado;
            }
        }
        return null;
    }

    public boolean buscarAluno(String cpf) {//retorna true se o aluno estiver matriculado e false se não estiver
        for (Aluno alunosRegistrado : alunosAcademia) {
            if (alunosRegistrado.getCpf().equals(cpf) || alunosRegistrado.getMatricula().equals(cpf)) {
                return true;
            }
        }
        return false;
    }

    public void listaPlanos() {
        System.out.println("A academia conta com três modalidades, sendo elas musculação, funcional e muay thai. Estes são os planos disponíveis e suas vantagens:");
        System.out.println("1 - Plano básico (R$55,00): o aluno pode escolher uma modalidade para praticar.");
        System.out.println("2 - Plano avançado(R$75,50): o aluno pode escolher duas modalidades para praticar");
        System.out.println("3 - Plano super(R$100,00): o aluno pode escolher todas as modalidades para praticar");
    }
}
