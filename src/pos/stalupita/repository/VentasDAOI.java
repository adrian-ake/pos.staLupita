/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pos.stalupita.repository;

import java.util.Date;
import java.util.List;
import pos.stalupita.model.Ticket;

/**
 *
 * @author adrian.ake
 */
public interface VentasDAOI {

    public List<Ticket> getTicketsByFech(Date f_desde, Date f_hasta);

    public List<Ticket> getMontosVentasXDia(int month);
}
