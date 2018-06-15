package pos.stalupita.model;
// Generated 12/06/2018 11:57:14 AM by Hibernate Tools 4.3.1

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * Ticket generated by hbm2java
 */
public class Ticket implements java.io.Serializable {

    private Integer idticket;
    private BigDecimal total;
    private BigDecimal ganancia;
    private BigDecimal pago;
    private BigDecimal cambio;
    private Date fechaRegistrado;
    private Date fechaCancelado;
    private Boolean pagado;
    private Boolean estado;
    private Set detalleTickets = new HashSet(0);

    public Ticket() {
    }

    public Ticket(Integer idticket, BigDecimal total, BigDecimal ganancia, BigDecimal pago, BigDecimal cambio, Date fechaRegistrado, Date fechaCancelado, Boolean pagado, Boolean estado) {
        this.idticket = idticket;
        this.total = total;
        this.ganancia = ganancia;
        this.pago = pago;
        this.cambio = cambio;
        this.fechaRegistrado = fechaRegistrado;
        this.fechaCancelado = fechaCancelado;
        this.pagado = pagado;
        this.estado = estado;
    }

    public Integer getIdticket() {
        return this.idticket;
    }

    public void setIdticket(Integer idticket) {
        this.idticket = idticket;
    }

    public BigDecimal getTotal() {
        return this.total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public BigDecimal getPago() {
        return this.pago;
    }

    public void setPago(BigDecimal pago) {
        this.pago = pago;
    }

    public BigDecimal getCambio() {
        return this.cambio;
    }

    public void setCambio(BigDecimal cambio) {
        this.cambio = cambio;
    }

    public Date getFechaRegistrado() {
        return this.fechaRegistrado;
    }

    public void setFechaRegistrado(Date fechaRegistrado) {
        this.fechaRegistrado = fechaRegistrado;
    }

    public Date getFechaCancelado() {
        return this.fechaCancelado;
    }

    public void setFechaCancelado(Date fechaCancelado) {
        this.fechaCancelado = fechaCancelado;
    }

    public Boolean getPagado() {
        return this.pagado;
    }

    public void setPagado(Boolean pagado) {
        this.pagado = pagado;
    }

    public Boolean getEstado() {
        return this.estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public Set getDetalleTickets() {
        return this.detalleTickets;
    }

    public void setDetalleTickets(Set detalleTickets) {
        this.detalleTickets = detalleTickets;
    }

    public BigDecimal getGanancia() {
        return ganancia;
    }

    public void setGanancia(BigDecimal ganancia) {
        this.ganancia = ganancia;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Ticket other = (Ticket) obj;
        return Objects.equals(this.idticket, other.idticket);
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 11 * hash + Objects.hashCode(this.idticket);
        return hash;
    }

}
