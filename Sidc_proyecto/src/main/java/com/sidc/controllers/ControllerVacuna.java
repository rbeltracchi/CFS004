package com.sidc.controllers;

import com.mysql.jdbc.PreparedStatement;
import com.sidc.clases.Persona;
import com.sidc.clases.Vacuna;
import com.sidc.main.MainSwing;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.persistence.criteria.CriteriaQuery;
import javax.swing.DefaultListModel;
import org.hibernate.Session;
import org.hibernate.query.Query;

public class ControllerVacuna {

    /*  public static boolean aplicable(Persona p, Vacuna v){
        
        if (p.getFechaNacimiento())
        
        return true;
    }*/
    
    public static void addVacuna(Vacuna v) {
        Session session = MainSwing.sessionFactory.openSession();
        session.beginTransaction();
        session.save(v);
        session.getTransaction().commit();
        session.close();
    }

     public static void eliminarVacuna(Vacuna v) {
        Session session = MainSwing.sessionFactory.openSession();
        session.beginTransaction();
        Vacuna aux = session.get(Vacuna.class, v.getIdVacuna());
        if (aux != null) {
            session.delete(aux);
        }
        session.getTransaction().commit();
        session.close();
    }
    
    public static List<Vacuna> listarVacunas() {
        Session session = MainSwing.sessionFactory.openSession();
        session.beginTransaction();
        Query query = session.createQuery("from Vacuna");
        List<Vacuna> list = query.list();
        return list;
}
}

