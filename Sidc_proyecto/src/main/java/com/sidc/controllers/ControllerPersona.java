package com.sidc.controllers;

import com.sidc.clases.HistoriaClinica;
import com.sidc.clases.Persona;
import com.sidc.clases.Vacuna;
import static com.sidc.controllers.ControllerVacuna.listarVacunas;
import com.sidc.main.MainSwing;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import javax.persistence.criteria.CriteriaQuery;
import org.hibernate.Session;

public class ControllerPersona {

    public static void insertarPersona(Persona c) {
        Session session = MainSwing.sessionFactory.openSession();
        session.beginTransaction();
        session.save(c);
        session.getTransaction().commit();
        session.close();
    }

    private static boolean habilitar(Persona p, String contraseña) {
        Session session = MainSwing.sessionFactory.openSession();
        session.beginTransaction();
        Persona aux = getPersonaByDni(p.getDni());
        session.getTransaction().commit();
        session.close();
        return contraseña == aux.getPassword();
    }

    private static Persona getPersonaByDni(int dni) {
        Session session = MainSwing.sessionFactory.openSession();
        session.beginTransaction();
        Persona p = session.get(Persona.class, dni);
        session.getTransaction().commit();
        session.close();
        return p;
    }

    public static HistoriaClinica mostrarHistoriaClinica(Persona p, String contraseña) {
        Session session = MainSwing.sessionFactory.openSession();
        session.beginTransaction();
        if (habilitar(p, contraseña)) {
            Persona aux = session.get(Persona.class, p.getDni());
            session.getTransaction().commit();
            session.close();
            return aux.getHistoriaClinica();
        }
        session.getTransaction().commit();
        session.close();
        return null;
    }

    public List<Vacuna> mostrarVacunas(Persona p) {
        Session session = MainSwing.sessionFactory.openSession();
        session.beginTransaction();
        Persona aux = session.get(Persona.class, p.getDni());
        session.getTransaction().commit();
        session.close();
        return aux.getHistoriaClinica().getVacunas();
    }
    
    
    public static List<Persona> listarPersonas() {
        List<Persona> list = new ArrayList();
        Session session = MainSwing.sessionFactory.openSession();
        session.beginTransaction();
        CriteriaQuery<Persona> query = session.getCriteriaBuilder().createQuery(Persona.class);
        query.select(query.from(Persona.class));
        list = session.createQuery(query).list();
        session.getTransaction().commit();
        session.close();
        return list;
    }
    public static void enviarAlerta() {
        List<Vacuna> vacunas = listarVacunas();
        List<Persona> personas = listarPersonas();
        for (Vacuna v : vacunas) {
            List<Persona> personasVacunables = listarPersonasVacunables(personas, v);
            for (Persona p : personasVacunables) {
                System.out.println("De esta vacuna se tienen que vacunar");
            }
        }
    }

    private static List<Persona> listarPersonasVacunables(List<Persona> personas, Vacuna v) {
        List<Persona> vacunables = new ArrayList<Persona>();
        for (Persona p : personas) {
            if (devuelveMeses(p) > v.getMeses()) {
                vacunables.add(p);
            }
        }
        return vacunables;
    }

    private static int devuelveMeses(Persona p) {
        Calendar startCalendar = new GregorianCalendar();
        startCalendar.setTime(p.getFechaNacimiento());
        Calendar endCalendar = Calendar.getInstance();

        int diffYear = endCalendar.get(Calendar.YEAR) - startCalendar.get(Calendar.YEAR);
        int diffMonth = diffYear * 12 + endCalendar.get(Calendar.MONTH) - startCalendar.get(Calendar.MONTH);
        return diffMonth;
    }

}
