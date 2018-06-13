/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pos.stalupita.repository;

import java.util.List;
import pos.stalupita.model.Categoria;
import pos.stalupita.model.Producto;
import pos.stalupita.model.UnidadMedida;

/**
 *
 * @author adrian.ake
 */
public interface ProductoDAOI {

    public List<Categoria> getAllCategorias();

    public Categoria getCategoriabyId(Integer idcategoria);

    public List<UnidadMedida> getAllUMEs();

    public UnidadMedida getUMEbyId(String idume);

    public List<Producto> getAllProductos();
}
