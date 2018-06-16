/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pos.stalupita.service;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import pos.stalupita.model.DetalleTicket;
import pos.stalupita.model.Ticket;
import pos.stalupita.repository.GenericDAOI;
import pos.stalupita.repository.TicketDAOI;

/**
 *
 * @author adrian.ake
 */
@Service
public class TicketService {

    @Resource
    private TicketDAOI ticketDAOI;
    @Resource
    private GenericDAOI genericDAOI;

    public void guardarTicket(Ticket ticket) {
        this.genericDAOI.save(ticket);
    }

    public void saveOrUpdateTicket(Ticket ticket) {
        this.genericDAOI.saveOrUpdate(ticket);
    }

    public void guardarDetalleTck(DetalleTicket detalleTicket) {
        this.genericDAOI.save(detalleTicket);
    }

    public void saveOrUpdateDetTicket(DetalleTicket detalleTicket) {
        this.genericDAOI.saveOrUpdate(detalleTicket);
    }

    public Ticket getTicketActivo() {
        return this.ticketDAOI.getTicketActivo();
    }

    public List<DetalleTicket> getDetfFromTckt(Integer idTicket) {
        return this.ticketDAOI.getDetfFromTckt(idTicket);
    }

    public void eliminarDetalle(DetalleTicket detalleTicket) {
        this.genericDAOI.remove(detalleTicket);
    }
}
