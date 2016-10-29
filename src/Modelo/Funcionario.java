
package Modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Funcionario {
    
    @Id
    @GeneratedValue
    private Long id;
    
    @Column(nullable = false, unique = true, length = 100)
    private String nome;
    
    @Column(nullable = false, length = 100)
    private String cpf;
    
    @Column(nullable = false, length = 100)
    private String endereco;
    
    @Column(nullable = false, length = 100)
    private String telefone;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 100)
    private SexoEnum sexo;
    
    private String email;
    
    @Column(nullable = false, length = 100)
    private String DataNasc;
    
    @Column(nullable = false, length = 100)
    private String login;
    
    @Column(nullable = false, length = 100)
    private String senha;
    
    public Funcionario() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public SexoEnum getSexo() {
        return sexo;
    }

    public void setSexo(SexoEnum sexo) {
        this.sexo = sexo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getDataNasc() {
        return DataNasc;
    }

    public void setDataNasc(String DataNasc) {
        this.DataNasc = DataNasc;
    }
    
}
