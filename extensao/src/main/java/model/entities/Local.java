package model.entities;

import javax.persistence.*;

@Entity
@Table(name = "Locais")
public class Local {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome_local", nullable = false)
    private String nomeLocal;

    @Column(name = "descricao", columnDefinition = "MEDIUMTEXT", nullable = false)
    private String descricao;

    @Column(name = "localizacao", nullable = false)
    private String localizacao;

    @Column(name = "foto_local", nullable = false)
    private String fotoLocal;

    @Column(name = "avaliacao", nullable = false)
    private String avaliacao;

    @Column(name = "categoria_local", nullable = false)
    private String categoriaLocal;

    @ManyToOne
    @JoinColumn(name = "id_adm", nullable = false)
    private Administrador administrador;

    // Constructors
    public Local() {}

    public Local(String nomeLocal, String descricao, String localizacao, String fotoLocal, String avaliacao, String categoriaLocal, Administrador administrador) {
        this.nomeLocal = nomeLocal;
        this.descricao = descricao;
        this.localizacao = localizacao;
        this.fotoLocal = fotoLocal;
        this.avaliacao = avaliacao;
        this.categoriaLocal = categoriaLocal;
        this.administrador = administrador;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeLocal() {
        return nomeLocal;
    }

    public void setNomeLocal(String nomeLocal) {
        this.nomeLocal = nomeLocal;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }

    public String getFotoLocal() {
        return fotoLocal;
    }

    public void setFotoLocal(String fotoLocal) {
        this.fotoLocal = fotoLocal;
    }

    public String getAvaliacao() {
        return avaliacao;
    }

    public void setAvaliacao(String avaliacao) {
        this.avaliacao = avaliacao;
    }

    public String getCategoriaLocal() {
        return categoriaLocal;
    }

    public void setCategoriaLocal(String categoriaLocal) {
        this.categoriaLocal = categoriaLocal;
    }

    public Administrador getAdministrador() {
        return administrador;
    }

    public void setAdministrador(Administrador administrador) {
        this.administrador = administrador;
    }

    @Override
    public String toString() {
        return "Local{" +
                "id=" + id +
                ", nomeLocal='" + nomeLocal + '\'' +
                ", descricao='" + descricao + '\'' +
                ", localizacao='" + localizacao + '\'' +
                ", fotoLocal='" + fotoLocal + '\'' +
                ", avaliacao='" + avaliacao + '\'' +
                ", categoriaLocal='" + categoriaLocal + '\'' +
                ", administrador=" + administrador +
                '}';
    }
}
