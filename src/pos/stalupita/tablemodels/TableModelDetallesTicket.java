/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pos.stalupita.tablemodels;

import com.alf.clients.gui.util.BeanTableModel;
import pos.stalupita.model.DetalleTicket;

/**
 *
 * @author adrian.ake
 */
public class TableModelDetallesTicket extends BeanTableModel<DetalleTicket> {

    public TableModelDetallesTicket() {
        super(new Object[][]{
            {"Producto", Object.class, "producto.descripcion", null, null},
            {"UME", Object.class, "producto.unidadMedida.idume", null, null},
            {"Precio", Object.class, "precio", null, null},
            {"Cantidad", Object.class, "cantidad", null, null},
            {"Total", Object.class, "total", null, null},
            {"Ganancia", Object.class, "ganancia", null, null}});
    }
}
