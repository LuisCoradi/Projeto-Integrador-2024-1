package model.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Viagens")
public class Viagem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "data_inicio", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dataInicio;

    @Column(name = "data_termino", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dataTermino;

    @Column(name = "status_viagem", nullable = false)
    private String statusViagem;

    @Column(name = "orcamento", nullable = false, precision = 10, scale = 2)
    private Double orcamento;

    @Column(name = "avaliacao_viagem", nullable = false)
    private String avaliacaoViagem;

    @ManyToOne
    @JoinColumn(name = "id_usuario_v", nullable = false)
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "id_destino", nullable = false)
    private Destino destino;

    // Constructors
    public Viagem() {}

    public Viagem(Date dataInicio, Date dataTermino, String statusViagem, Double orcamento, String avaliacaoViagem, Usuario usuario, Destino destino) {
        this.dataInicio = dataInicio;
        this.dataTermino = dataTermino;
        this.statusViagem = statusViagem;
        this.orcamento = orcamento;
        this.avaliacaoViagem = avaliacaoViagem;
        this.usuario = usuario;
        this.destino = destino;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    public Date getDataTermino() {
        return dataTermino;
    }

    public void setDataTermino(Date dataTermino) {
        this.dataTermino = dataTermino;
    }

    public String getStatusViagem() {
        return statusViagem;
    }

    public void setStatusViagem(String statusViagem) {
        this.statusViagem = statusViagem;
    }

    public Double getOrcamento() {
        return orcamento;
    }

    public void setOrcamento(Double orcamento) {
        this.orcamento = orcamento;
    }

    public String getAvaliacaoViagem() {
        return avaliacaoViagem;
    }

    public void setAvaliacaoViagem(String avaliacaoViagem) {
        this.avaliacaoViagem = avaliacaoViagem;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Destino getDestino() {
        return destino;
    }

    public void setDestino(Destino destino) {
        this.destino = destino;
    }

    @Override
    public String toString() {
        return "Viagem{" +
                "id=" + id +
                ", dataInicio=" + dataInicio +
                ", dataTermino=" + dataTermino +
                ", statusViagem='" + statusViagem + '\'' +
                ", orcamento=" + orcamento +
                ", avaliacaoViagem='" + avaliacaoViagem + '\'' +
                ", usuario=" + usuario +
                ", destino=" + destino +
                '}';
    }
}
