package projetofinal.LP2;

public abstract class Pessoa {

    public static class Endereco {
        String rua;
        String bairro;
        String numero;

        Endereco(String rua, String bairro, String numero) {
            this.rua = rua;
            this.bairro = bairro;
            this.numero = numero;
        }

        @Override
        public String toString() {
            return "Rua: " + rua + ", Bairro: " + bairro + ", Número: " + numero;
        }

    }

    protected String nome;
    protected String cpf;
    protected String DataNascimento;
    protected Endereco endereco;
    protected String matricula;

    public Pessoa(String nome, String cpf, String DataNascimento, String rua, String bairro, String numero, String matricula) {
        this.nome = nome;
        this.cpf = cpf;
        this.DataNascimento = DataNascimento;
        this.endereco = new Endereco(rua, bairro, numero);
        this.matricula = matricula;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return this.nome;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getCpf() {
        return this.cpf;
    }

    public void setDataNascimento(String DataNascimento) {
        this.DataNascimento = DataNascimento;
    }

    public String getDataNascimento() {
        return this.DataNascimento;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public Endereco getEndereco() {
        return this.endereco;
    }

    public abstract void setMatricula(String matricula); // muda de aluno pra funcionario

    public String getMatricula() {
        return this.matricula;
    }

}
