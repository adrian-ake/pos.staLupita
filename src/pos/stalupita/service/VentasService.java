/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pos.stalupita.service;

import java.util.Date;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import pos.stalupita.model.Ticket;
import pos.stalupita.repository.GenericDAOI;
import pos.stalupita.repository.VentasDAOI;

/**
 *
 * @author adrian.ake
 */
@Service
public class VentasService {
    @Resource
    private VentasDAOI ticketDAOI;
    @Resource
    private GenericDAOI genericDAOI;
    public List<Ticket> getTicketsByFech(Date f_desde, Date f_hasta) {
        return this.ticketDAOI.getTicketsByFech(f_desde, f_hasta);
    }
}
