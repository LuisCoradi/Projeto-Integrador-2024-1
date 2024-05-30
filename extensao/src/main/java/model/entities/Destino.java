package model.entities;

import javax.persistence.*;

@Entity
@Table(name = "Destinos")
public class Destino {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome_destino", nullable = false)
    private String nomeDestino;

    @Column(name = "descricao_destino", columnDefinition = "MEDIUMTEXT", nullable = false)
    private String descricaoDestino;

    @Column(name = "foto_destino", nullable = false)
    private String fotoDestino;

    @Column(name = "pais", nullable = false)
    private String pais;

    @Column(name = "regiao", nullable = false)
    private String regiao;

    // Constructors
    public Destino() {}

    public Destino(String nomeDestino, String descricaoDestino, String fotoDestino, String pais, String regiao) {
        this.nomeDestino = nomeDestino;
        this.descricaoDestino = descricaoDestino;
        this.fotoDestino = fotoDestino;
        this.pais = pais;
        this.regiao = regiao;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeDestino() {
        return nomeDestino;
    }

    public void setNomeDestino(String nomeDestino) {
        this.nomeDestino = nomeDestino;
    }

    public String getDescricaoDestino() {
        return descricaoDestino;
    }

    public void setDescricaoDestino(String descricaoDestino) {
        this.descricaoDestino = descricaoDestino;
    }

    public String getFotoDestino() {
        return fotoDestino;
    }

    public void setFotoDestino(String fotoDestino) {
        this.fotoDestino = fotoDestino;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getRegiao() {
        return regiao;
    }

    public void setRegiao(String regiao) {
        this.regiao = regiao;
    }

    @Override
    public String toString() {
        return "Destino{" +
                "id=" + id +
                ", nomeDestino='" + nomeDestino + '\'' +
                ", descricaoDestino='" + descricaoDestino + '\'' +
                ", fotoDestino='" + fotoDestino + '\'' +
                ", pais='" + pais + '\'' +
                ", regiao='" + regiao + '\'' +
                '}';
    }
}
