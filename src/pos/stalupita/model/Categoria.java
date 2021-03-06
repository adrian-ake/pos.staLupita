package pos.stalupita.model;
// Generated 12/06/2018 11:57:14 AM by Hibernate Tools 4.3.1

import java.util.HashSet;
import java.util.Set;

/**
 * Categoria generated by hbm2java
 */
public class Categoria implements java.io.Serializable {

    private Integer idcategoria;
    private String descripcion;
    private Boolean estado;
    private Set productos = new HashSet(0);

    public Categoria() {
    }

    public Categoria(String descripcion, Boolean estado, Set productos) {
        this.descripcion = descripcion;
        this.estado = estado;
        this.productos = productos;
    }

    public Integer getIdcategoria() {
        return this.idcategoria;
    }

    public void setIdcategoria(Integer idcategoria) {
        this.idcategoria = idcategoria;
    }

    public String getDescripcion() {
        return this.descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Boolean getEstado() {
        return this.estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public Set getProductos() {
        return this.productos;
    }

    public void setProductos(Set productos) {
        this.productos = productos;
    }

    @Override
    public String toString() {
        return descripcion;
    }

}
