/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pos.stalupita.controller;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import pos.stalupita.model.Categoria;
import pos.stalupita.model.UnidadMedida;
import pos.stalupita.service.ProductoService;

/**
 *
 * @author adrian.ake
 */
@Controller
public class ProductoController {

    @Resource
    private ProductoService productoService;

    public List<Categoria> getAllCategorias() {
        return this.productoService.getAllCategorias();
    }

    public List<UnidadMedida> getAllUmes() {
        return this.productoService.getAllUmes();
    }
}
