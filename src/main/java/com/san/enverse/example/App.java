package com.san.enverse.example;

import java.util.Set;

import org.hibernate.Session;
import org.hibernate.envers.AuditReader;
import org.hibernate.envers.AuditReaderFactory;

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
        modifyEntities(session);
        readAuditEntries(session);
        session.close();
    }
    
    public static void modifyEntities(Session session){
    	session.beginTransaction();
        //saveNewRecords(session);
        Store store5=(Store) session.load(Store.class, 5);
        Set<Beam> beams=store5.getBeams();
        store5.setStoreName("NewStore-five");
        long i=System.currentTimeMillis();
        for(Beam beam:beams){
            	System.out.println(beam);
            	beam.setBeamToolCat("Trailers"+i++);
            	break;
        }
        Beam newBeam  = new Beam();
        newBeam.setStore(store5);
        newBeam.setBeamToolCat("Carpet Cleaners "+i++);
        beams.add(newBeam);
        session.saveOrUpdate(store5);
        session.getTransaction().commit();
    }
    
    public static void readAuditEntries(Session session){
    	System.out.println("Reading Audit entries");
       
        session.beginTransaction();
        AuditReader reader = AuditReaderFactory.get(session);
        Store store = reader.find(Store.class, 5, 13);
        System.out.println(store);
        store = reader.find(Store.class, 5, 12);
        System.out.println(store);
        session.getTransaction().commit();       
    	
    }
    
    public static void saveNewRecords(Session session){
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
        session.getTransaction().commit();
        
        
        //session.delete(stock);
        
        
    }
}
