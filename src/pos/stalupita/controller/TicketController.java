/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pos.stalupita.controller;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import pos.stalupita.model.DetalleTicket;
import pos.stalupita.model.Ticket;
import pos.stalupita.service.TicketService;

/**
 *
 * @author adrian.ake
 */
@Controller
public class TicketController {

    @Resource
    private TicketService ticketService;

    public Ticket getTicketActivo() {
        return this.ticketService.getTicketActivo();
    }

    public void guardarTicket(Ticket ticket) {
        this.ticketService.guardarTicket(ticket);
    }

    public void guardarDetalleTicket(DetalleTicket nuevo_det) {
        this.ticketService.guardarDetalleTck(nuevo_det);
    }

    public List<DetalleTicket> getDetfFromTckt(Integer idTicket) {
        return this.ticketService.getDetfFromTckt(idTicket);
    }

    public void actualizarDet(DetalleTicket agregadoDetalle) {
        this.ticketService.saveOrUpdateDetTicket(agregadoDetalle);
    }

    public void eliminarDetalle(DetalleTicket detalleTicket) {
        this.ticketService.eliminarDetalle(detalleTicket);
    }
}
