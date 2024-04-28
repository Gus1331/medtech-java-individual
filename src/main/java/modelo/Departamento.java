package modelo;

import java.util.ArrayList;
import java.util.List;

public class Departamento {

    private int idDepartamento;
    private String nome;
    private Hospital hospital;
    private Funcionario funcionario;

    private int fkHospital;
    private int fkFuncionarioResponsavel;
    private List<Computador> computadores;

    public Departamento(int idDepartamento, String nome, Hospital hospital, Funcionario funcionario)
    {
        this.idDepartamento = idDepartamento;
        this.nome = nome;
        this.hospital = hospital;
        this.funcionario = funcionario;
        this.computadores = new ArrayList<>();
    };

    public Departamento(){
        this.hospital = new Hospital();
        this.computadores = new ArrayList<>();
        this.funcionario = new Funcionario();
    }

    //GETTERS
    public int getIdDepartamento()
    {
        return this.idDepartamento;
    }

    public String getNome()
    {
        return this.nome;
    }

    public Hospital getHospital() {
        return hospital;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public List<Computador> getComputadores() {
        return computadores;
    }

    public int getFkFuncionarioResponsavel() {
        return fkFuncionarioResponsavel;
    }

    //Setters


    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public void setIdDepartamento(int idDepartamento)
    {
        this.idDepartamento = idDepartamento;
    }

    public void setNome(String nome)
    {
        this.nome = nome;
    }

    public void setHospital(Hospital hospital) {
        this.hospital = hospital;
        hospital.addDepartamentos(this);
    }

    public void setFkFuncionarioResponsavel(int fkFuncionarioResponsavel) {
        this.fkFuncionarioResponsavel = fkFuncionarioResponsavel;
    }

    public void setFkHospital(int fkHospital) {
        this.fkHospital = fkHospital;
    }

    public void setComputadores(List<Computador> computadores) {
        this.computadores = computadores;
    }

    public int getFkHospital() {
        return this.fkHospital;
    }

    public void addComputadores(Computador computador){
        if(this.computadores.contains(computador)){
            return;
        }
        this.computadores.add(computador);
    }
}
