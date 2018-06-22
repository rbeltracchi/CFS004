
package com.sidc.controllers;
import com.sidc.clases.Medico;
import com.sidc.clases.Persona;
import com.sidc.main.MainSwing;
import org.hibernate.Session;

public class ControllerMedico {
    public static void insertarMedico(Medico m) {
        Session session = MainSwing.sessionFactory.openSession();
        session.beginTransaction();
        session.save(m);
        session.getTransaction().commit();
        session.close();
    }
    
}
