/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sidc.controllers;

import com.sidc.clases.Antecedente;
import com.sidc.main.MainSwing;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.criteria.CriteriaQuery;
import org.hibernate.Session;

/**
 *
 * @author julian
 */
public class ControllerAntecedente {
    
     public static List<Antecedente> listarAntecedentes() {
        List<Antecedente> list = new ArrayList();
        try {
            Session sessionHB = MainSwing.sessionFactory.openSession();
            sessionHB.beginTransaction();
            CriteriaQuery<Antecedente> query
                    = sessionHB.getCriteriaBuilder().createQuery(Antecedente.class);
            query.select(query.from(Antecedente.class));
            list = sessionHB.createQuery(query).list();
            sessionHB.getTransaction().commit();
        } catch (Exception e) {
            System.err.println("Exception: " + e);
            throw new ExceptionInInitializerError(e);
        }

        return list;
    }

    public static void addAntecedente(Antecedente a) {
        Session session = MainSwing.sessionFactory.openSession();
        session.beginTransaction();

        session.save(a);

        session.getTransaction().commit();
        session.close();
    }
}
