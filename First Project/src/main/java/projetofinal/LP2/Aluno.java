package projetofinal.LP2;

public class Aluno extends Pessoa {

    protected Plano planoAluno;
    protected String objetivo;
    public Instrutor instrutor;

    public Aluno(String nome, String cpf, String DataNascimento, String rua, String bairro, String numero, String matricula, Plano planoAluno, String objetivo, Instrutor instrutor) {
        super(nome, cpf, DataNascimento, rua, bairro, numero, matricula);
        this.planoAluno = planoAluno;
        this.objetivo = objetivo;
        setInstrutor(instrutor);
    }
    //Enum com os planos disponiveis e seus respectivos valores. 
    public enum Plano {
        planoBasico(55), planoAvancado(75.50), planoSuper(100);

        double precoPlano;

        Plano(double precoPlano) {
            this.precoPlano = precoPlano;
        }

        public double getPrecoPlano() {
            return precoPlano;
        }
    }

    @Override
    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public void setInstrutor(Instrutor instrutor){
        this.instrutor = instrutor;
        instrutor.vincularAluno(this);
    }

    public String getInstrutor(){
        return instrutor.getNome();
    }

    public void setObjetivo(String objetivo) {
        this.objetivo = objetivo;
    }

    public String getObjetivo() {
        return this.objetivo;
    }

    public void instrucoesTreino() {
        System.out.println("Instruções de treino para " + this.objetivo + ":");
        Instrutor.tipoTreino(objetivo);
    }

}
