/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pos.stalupita.repository;

import java.util.List;
import javax.annotation.Resource;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pos.stalupita.model.Categoria;
import pos.stalupita.model.Producto;
import pos.stalupita.model.UnidadMedida;

/**
 *
 * @author adrian.ake
 */
@Repository
public class ProductoRepository implements ProductoDAOI {

    @Resource
    private SessionFactory sessionFactory;

    @Autowired
    public ProductoRepository(SessionFactory sessionfactoryr) {
        this.sessionFactory = sessionfactoryr;
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public Session getSession() {
        Session session = null;
        if (this.getSessionFactory().getCurrentSession() == null) {
            session = this.getSessionFactory().openSession();
        } else {
            session = this.getSessionFactory().getCurrentSession();
        }
        if (!session.getTransaction().isActive()) {
            session.beginTransaction();
        }
        return session;
    }

    @Override
    public List<Categoria> getAllCategorias() {
        String query = "SELECT * FROM stalupita.categoria WHERE estado= 1";
        SQLQuery sqlQuery = this.getSession().createSQLQuery(query).addEntity(Categoria.class);
        return sqlQuery.list();
    }

    @Override
    public Categoria getCategoriabyId(Integer idcategoria) {
        String query = "SELECT * FROM stalupita.categoria WHERE estado= 1 AND idcategoria = :idcategoria";
        SQLQuery sqlQuery = this.getSession().createSQLQuery(query).addEntity(Categoria.class);
        sqlQuery.setParameter("idcategoria", idcategoria);
        return (Categoria) sqlQuery.uniqueResult();
    }

    @Override
    public List<UnidadMedida> getAllUMEs() {
        String query = "SELECT * FROM stalupita.unidad_medida WHERE estado= 1";
        SQLQuery sqlQuery = this.getSession().createSQLQuery(query).addEntity(UnidadMedida.class);
        return sqlQuery.list();
    }

    @Override
    public UnidadMedida getUMEbyId(String idume) {
        String query = "SELECT * FROM stalupita.unidad_medida WHERE estado= 1 AND idume = :idume";
        SQLQuery sqlQuery = this.getSession().createSQLQuery(query).addEntity(UnidadMedida.class);
        sqlQuery.setParameter("idume", idume);
        return (UnidadMedida) sqlQuery.uniqueResult();
    }

    @Override
    public List<Producto> getAllProductos() {
        String query = "SELECT * FROM stalupita.producto WHERE estado= 1";
        SQLQuery sqlQuery = this.getSession().createSQLQuery(query).addEntity(Producto.class);
        return sqlQuery.list();
    }

}
