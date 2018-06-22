package com.sidc.controllers;

import com.sidc.clases.Sede;
import com.sidc.clases.Vacuna;
import java.util.List;

import org.hibernate.Session;
import com.sidc.main.MainSwing;
import java.util.ArrayList;
import javax.persistence.criteria.CriteriaQuery;

public class ControllerSede {

   
    public static List<Sede> listarSedes() {
        List<Sede> list = new ArrayList();
        Session session = MainSwing.sessionFactory.openSession();
        session.beginTransaction();
        CriteriaQuery<Sede> query = session.getCriteriaBuilder().createQuery(Sede.class);
        query.select(query.from(Sede.class));
        list = session.createQuery(query).list();
        session.getTransaction().commit();
        session.close();
        return list;
    }

    public static void insertarSede(Sede s) {
        Session session = MainSwing.sessionFactory.openSession();
        session.beginTransaction();

        session.save(s);

        session.getTransaction().commit();
        session.close();
    }
}
