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
public class VentasRepository implements VentasDAOI {

    @Resource
    private SessionFactory sessionFactory;
    private SimpleDateFormat formatoFechaSql = new SimpleDateFormat("yyyy-MM-dd");
    private SimpleDateFormat formatoFechaIni = new SimpleDateFormat("yyyy-MM-dd 00:00:00");
    private SimpleDateFormat formatoFechaFin = new SimpleDateFormat("yyyy-MM-dd 23:59:59");

    @Autowired
    public VentasRepository(SessionFactory sessionfactoryr) {
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

        String fecha_desde = formatoFechaIni.format(f_desde);
        String fecha_hasta = formatoFechaFin.format(f_hasta);

        String query = "SELECT * FROM stalupita.ticket"
                + " WHERE estado= 1 AND pagado=1 AND "
                + " fecha_registrado BETWEEN  '" + fecha_desde + "' AND '" + fecha_hasta + "' ";
        SQLQuery sqlQuery = this.getSession().createSQLQuery(query).addEntity(Ticket.class);
        return sqlQuery.list();
    }

    @Override
    public List<Ticket> getMontosVentasXDia(int month) {
        String mes = String.format("%02d", month);
        String query = "  select it.idticket as idticket,sum(it.total) as total,sum(it.ganancia) as ganancia,sum(it.pago) as pago, "
                + "sum(it.cambio) as cambio,it.fecha_registrado as fecha_registrado,it.fecha_cancelado as fecha_cancelado,it.pagado as pagado, "
                + "it.estado as estado from ( "
                + "select  t.idticket,t.total,t.ganancia,t.pago,t.cambio,DATE(t.fecha_registrado) as fecha_registrado,t.fecha_cancelado,t.pagado,t.estado  "
                + " from ticket as t where t.fecha_registrado like '2018-" + mes + "%' AND t.estado=1 AND t.pagado=1) AS it GROUP BY it.fecha_registrado;";
        SQLQuery sqlQuery = this.getSession().createSQLQuery(query).addEntity(Ticket.class);
        return sqlQuery.list();
    }

    @Override
    public List<DetalleTicket> getDetsAgrupadoXProducto(Date date) {
        String query = " select dt.iddetticket as iddetticket,dt.idticket as idticket,dt.idproducto as idproducto, "
                + " sum(dt.precio) as precio,sum(dt.cantidad) as cantidad,sum(dt.total) as total, sum(dt.ganancia) as ganancia "
                + " from detalle_ticket as dt "
                + " inner join ticket as t on dt.idticket =t.idticket "
                + " where t.fecha_registrado like '" + formatoFechaSql.format(date) + "%' group by dt.idproducto;";
        SQLQuery sqlQuery = this.getSession().createSQLQuery(query).addEntity(DetalleTicket.class);
        return sqlQuery.list();
    }
}
