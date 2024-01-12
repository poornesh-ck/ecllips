package edu.training.MavenDemo;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import org.hibernate.Session;


/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
       Employeee emp =new Employeee(101,"abc",50000.0);
       Configuration config= new Configuration().configure().addAnnotatedClass(Employeee.class);
       SessionFactory sf=config.buildSessionFactory();
       Session s=sf.openSession();
       Transaction tx= s.beginTransaction();
       s.save(emp);
       tx.commit();
       
    }
}
