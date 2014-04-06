package com.san.enverse.example;

import org.hibernate.Session;

import com.san.enverse.persistence.HibernateUtil;



/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	System.out.println("Maven + Hibernate + MySQL");
        Session session = HibernateUtil.getSessionFactory().openSession();
        
        session.beginTransaction();
        Store store = new Store();
        
        store.setStoreName("Store-"+System.currentTimeMillis());
        Beam beam1 = new Beam();
        beam1.setBeamToolCat("CarpetCleaners");
        Beam beam2 = new Beam();
        beam2.setBeamToolCat("PressureWashers");
        
        store.addBeam(beam1);
        store.addBeam(beam2);
        
        session.save(store);
       
        
        
        //session.delete(stock);
        
        session.getTransaction().commit();
        session.close();
    }
}
