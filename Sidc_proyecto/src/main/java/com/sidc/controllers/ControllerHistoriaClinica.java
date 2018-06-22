
package com.sidc.controllers;

import com.sidc.clases.Antecedente;
import com.sidc.clases.HistoriaClinica;
import com.sidc.clases.Persona;
import com.sidc.clases.Vacuna;
import com.sidc.main.MainSwing;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.criteria.CriteriaQuery;
import org.hibernate.Session;

public class ControllerHistoriaClinica {

   

    public static void addHistoriaClinica(HistoriaClinica hc) {
        Session session = MainSwing.sessionFactory.openSession();
        session.beginTransaction();

        session.save(hc);

        session.getTransaction().commit();
        session.close();
    }
}
