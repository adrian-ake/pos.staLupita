/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pos.stalupita.tablemodels;

import com.alf.clients.gui.util.BeanTableModel;
import pos.stalupita.model.Producto;

/**
 *
 * @author adrian.ake
 */
public class TableModelCatProductos extends BeanTableModel<Producto> {

    public TableModelCatProductos() {
        super(new Object[][]{
            {"Id", Object.class, "idproducto", null, null},
            {"Nombre del Producto", Object.class, "descripcion", null, null},
            {"Categoria", Object.class, "categoria.descripcion", null, null},
            {"UME", Object.class, "unidadMedida.descripcion", null, null},
            {"Costo Compra", Object.class, "costo", null, null},
            {"Precio Venta", Object.class, "precio", null, null}

        });
    }
}
