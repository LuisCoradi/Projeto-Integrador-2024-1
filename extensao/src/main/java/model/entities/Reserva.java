package model.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Reservas")
public class Reserva {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "data_reserva", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dataReserva;

    @Column(name = "detalhes", columnDefinition = "MEDIUMTEXT", nullable = false)
    private String detalhes;

    @ManyToOne
    @JoinColumn(name = "id_usuario", nullable = false)
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "id_local", nullable = false)
    private Local local;

    // Constructors
    public Reserva() {}

    public Reserva(Date dataReserva, String detalhes, Usuario usuario, Local local) {
        this.dataReserva = dataReserva;
        this.detalhes = detalhes;
        this.usuario = usuario;
        this.local = local;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDataReserva() {
        return dataReserva;
    }

    public void setDataReserva(Date dataReserva) {
        this.dataReserva = dataReserva;
    }

    public String getDetalhes() {
        return detalhes;
    }

    public void setDetalhes(String detalhes) {
        this.detalhes = detalhes;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Local getLocal() {
        return local;
    }

    public void setLocal(Local local) {
        this.local = local;
    }

    @Override
    public String toString() {
        return "Reserva{" +
                "id=" + id +
                ", dataReserva=" + dataReserva +
                ", detalhes='" + detalhes + '\'' +
                ", usuario=" + usuario +
                ", local=" + local +
                '}';
    }
}
