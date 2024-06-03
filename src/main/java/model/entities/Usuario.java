package model.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "senha", nullable = false)
    private String senha;

    @Column(name = "datacadastro", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dataCadastro;

    @Column(name = "informacoes_perfil", nullable = false, length = 255)
    private String informacoesPerfil;

    // Constructors
    public Usuario() {}

    public Usuario(String nome, String email, String senha, Date dataCadastro, String informacoesPerfil) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.dataCadastro = dataCadastro;
        this.informacoesPerfil = informacoesPerfil;
    }

    // Getters and Setters
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Date getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public String getInformacoesPerfil() {
        return informacoesPerfil;
    }

    public void setInformacoesPerfil(String informacoesPerfil) {
        this.informacoesPerfil = informacoesPerfil;
    }


    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", senha='" + senha + '\'' +
                ", dataCadastro=" + dataCadastro +
                ", informacoesPerfil='" + informacoesPerfil + '\'' +
                '}';
    }
}
