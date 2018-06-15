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
public class TableModelConsProd extends BeanTableModel<Producto> {

    public TableModelConsProd() {
        super(new Object[][]{            
            {"Producto", Object.class, "descripcion", null, null},
            {"Categoria", Object.class, "categoria.descripcion", null, null},
            {"UME", Object.class, "unidadMedida.descripcion", null, null},            
            {"Precio Venta", Object.class, "precio", null, null}           
        });
    }
}
