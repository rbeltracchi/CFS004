/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sidc.main;

import com.sidc.clases.Persona;
import java.util.Date;
import com.sidc.clases.HistoriaClinica;
import com.sidc.clases.Vacuna;
import static com.sidc.controllers.ControllerPersona.insertarPersona;
import static com.sidc.controllers.ControllerVacuna.addVacuna;
import static com.sidc.controllers.ControllerVacuna.eliminarVacuna;
import static com.sidc.controllers.ControllerVacuna.listarVacunas;
import java.util.List;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

/**
 *
 * @author User
 */
public class MainSwing {

    public static SessionFactory sessionFactory = null;

    public static void main(String[] args) {

        try {
            StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                    .configure() // obtiene los valores de hibernate.cfg.xml
                    .build();
            sessionFactory = new MetadataSources(registry)
                    .buildMetadata().buildSessionFactory();

            Date fNac = new Date(1987,1, 2);
            Persona p = new Persona("jose", "perez", 12345674, fNac, "154668877", "juanitoterere6@gmail.com", "password", "Falsa", 123, 1, "A");
           // Vacuna v =new Vacuna("tetanos",12,fNac);
           // Vacuna v2=new Vacuna("rabia",36,fNac);
                //addVacuna(v);
                //eliminarVacuna(v2);
             //System.out.println( listarVacunas());
                //insertarPersona(p);
                 Vacuna b = new Vacuna("BCG", 6, fNac, 1);
                 //addVacuna(b);
                 eliminarVacuna(b);
            /*Date fechaVencimiento = new Date(1, 2, 2030);
          Vacuna b = new Vacuna("BCG", 6, fechaVencimiento, 2);
                      
          
            List<Vacuna> vacunas = listarVacunas();
            for (Vacuna s : vacunas) {
                System.out.println(s);
            }
  
            eliminarVacuna(b);
           
            List<Vacuna> vacunas2 = listarVacunas();         
            for (Vacuna s : vacunas2) {
                System.out.println(s);
            }*/
        } catch (Exception e) {
            System.err.println("Exception: " + e);
            throw new ExceptionInInitializerError(e);
        }

    }
}
