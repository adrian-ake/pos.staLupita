/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pos.stalupita.repository;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.annotation.Resource;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pos.stalupita.model.DetalleTicket;
import pos.stalupita.model.Ticket;

/**
 *
 * @author adrian.ake
 */
@Repository
public class TicketRepository implements TicketDAOI {

    @Resource
    private SessionFactory sessionFactory;

    @Autowired
    public TicketRepository(SessionFactory sessionfactoryr) {
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
    public List<Ticket> getTicketsByFech(Date f_desde, Date f_hasta) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String fecha_desde = sdf.format(f_desde);
        String fecha_hasta = sdf.format(f_hasta);

        String query = "SELECT * FROM stalupita.categoria WHERE estado= 1";
        SQLQuery sqlQuery = this.getSession().createSQLQuery(query).addEntity(Ticket.class);
        return sqlQuery.list();
    }

    @Override
    public Ticket getTicketActivo() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String fecha = sdf.format(new Date());
//        String query = "SELECT * FROM stalupita.ticket WHERE fecha_registrado like '" + fecha + "%' AND pagado=0 AND estado=1 limit 1";
        String query = "SELECT * FROM stalupita.ticket WHERE pagado=0 AND estado=1 limit 1";
        SQLQuery sqlQuery = this.getSession().createSQLQuery(query).addEntity(Ticket.class);
        return (Ticket) sqlQuery.uniqueResult();
    }

    @Override
    public List<DetalleTicket> getDetfFromTckt(Integer idTicket) {
        String query = "SELECT * FROM stalupita.detalle_ticket WHERE idticket=" + idTicket + ";";
        SQLQuery sqlQuery = this.getSession().createSQLQuery(query).addEntity(DetalleTicket.class);
        return sqlQuery.list();
    }
}
