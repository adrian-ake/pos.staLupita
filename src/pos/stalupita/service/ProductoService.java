/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pos.stalupita.service;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import pos.stalupita.model.Categoria;
import pos.stalupita.model.UnidadMedida;
import pos.stalupita.repository.ProductoDAOI;

/**
 *
 * @author adrian.ake
 */
@Service
public class ProductoService {

    @Resource
    private ProductoDAOI productoDAOI;

    public List<Categoria> getAllCategorias() {
        return this.productoDAOI.getAllCategorias();
    }

    public List<UnidadMedida> getAllUmes() {
        return this.productoDAOI.getAllUMEs();
    }

}
