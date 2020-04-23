package utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

	private static Session session;
	private HibernateUtil() {
		
	}
    public static Session getHibernateSession() {
    	if(session == null) {
    		final SessionFactory sf = new Configuration()
    	            .configure("./config/Hibernate.cfg.xml").buildSessionFactory();
    		session = sf.openSession();
    		return session;
    	}else {
    		return session;
    	}
        

        // factory = new Configuration().configure().buildSessionFactory();
       
        
    }
}