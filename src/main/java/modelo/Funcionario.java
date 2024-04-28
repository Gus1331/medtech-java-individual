package modelo;

import org.springframework.jdbc.core.JdbcTemplate;
import repositorio.FuncionarioRepositorio;

public class Funcionario {
    private String nome;
    private String CPF;
    private String telefone;
    private String cargo;
    private String email;

    private Hospital hospital;
    private int fkHospital;


    // CONSTRUCTOR

    public Funcionario(String nome, String CPF, String telefone, String cargo, String email, Hospital hospital, int fkHospital) {
        this.nome = nome;
        this.CPF = CPF;
        this.telefone = telefone;
        this.cargo = cargo;
        this.email = email;
        this.hospital = hospital;
        this.fkHospital = fkHospital;
    }

    public String stringCargo(){
        String stringCargo = "";
        switch (this.cargo){
            case "MEDICO_GERENTE":
                stringCargo = "Médico gerente";
                break;
            case "TECNICO_TI":
                stringCargo = "Técnico de Tecnologia da Informação";
                break;
            case "GESTOR_TI":
                stringCargo = "Gestor de Tecnologia da Informação";
                break;
        }
        return stringCargo;
    }

    public Funcionario() {
    }

    // GETTERS
    public String getNome() {
        return nome;
    }

    public String getCPF() {
        return CPF;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getCargo() {
        return cargo;
    }

    public String getEmail() {
        return email;
    }

    public Hospital getHospital() {
        return hospital;
    }

    public int getFkHospital() {
        return fkHospital;
    }

    // SETTERS

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setHospital(Hospital hospital) {
        this.hospital = hospital;
    }

    public void setFkHospital(int fkHospital) {
        this.fkHospital = fkHospital;
    }

    // TO STRING

    @Override
    public String toString() {
        return "Responsável:" +
                "nome='" + nome + '\'' +
                ", CPF='" + CPF + '\'' +
                ", telefone='" + telefone + '\'' +
                ", cargo='" + this.stringCargo() + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
