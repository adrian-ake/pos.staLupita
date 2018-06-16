/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pos.stalupita.tablemodels;

import com.alf.clients.gui.util.BeanTableModel;
import pos.stalupita.model.Ticket;

/**
 *
 * @author adrian.ake
 */
public class TableModelTicketsVta extends BeanTableModel<Ticket> {

    public TableModelTicketsVta() {
        super(new Object[][]{
            {"# Ticket", Object.class, "idticket", null, null},
            {"Total Pagado", Object.class, "total", null, null},
            {"Ganancia Final", Object.class, "ganancia", null, null},
            {"Fecha Venta", Object.class, "fechaRegistrado", null, null}});
    }
}
