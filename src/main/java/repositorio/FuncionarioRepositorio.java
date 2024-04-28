package repositorio;

import modelo.Computador;
import java.util.List;

import modelo.Departamento;
import modelo.Funcionario;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

public class FuncionarioRepositorio {


    final JdbcTemplate conn;

    public FuncionarioRepositorio(JdbcTemplate conn) {this.conn = conn;}

    public Funcionario buscarFuncionarioResponsavelDepartamento(int idFuncionario){
        FuncionarioRepositorio funcionarioRepositorio = new FuncionarioRepositorio(conn);

        return conn.queryForObject("SELECT * FROM funcionario WHERE idFuncionario = ?;", new BeanPropertyRowMapper<>(Funcionario.class), idFuncionario);
    }
}