/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pos.stalupita.controller;

import java.util.Date;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import pos.stalupita.model.Ticket;
import pos.stalupita.service.VentasService;

/**
 *
 * @author adrian.ake
 */
@Controller
public class VentasController {

    @Resource
    private VentasService ventasService;

    public List<Ticket> getTicketsByFech(Date f_desde, Date f_hasta) {
        return this.ventasService.getTicketsByFech(f_desde, f_hasta);
    }

    public List<Ticket> getMontosVentasXDia(int month) {
        return this.ventasService.getMontosVentasXDia(month);
    }
}
