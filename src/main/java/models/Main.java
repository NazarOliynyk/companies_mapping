package models;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        Configuration configuration= new Configuration().configure();

        configuration
                .addAnnotatedClass(Company.class)
                .addAnnotatedClass(Department.class)
                .addAnnotatedClass(Worker.class);
        SessionFactory sessionFactory= configuration.buildSessionFactory();
        Session manager = sessionFactory.openSession();

        // manager.getTransaction().begin();
        manager.beginTransaction();

        Worker worker1= new Worker("Petro", 2343.88);
        Worker worker2= new Worker("Danylo", 1555.12);
        Worker worker3= new Worker("Gavrylo", 3009.44);
        Worker worker4= new Worker("Vasyl", 1778.02);
        Worker worker5= new Worker("Yura", 2178.67);
        Worker worker6= new Worker("Zoriana", 1890.55);
        Worker worker7= new Worker("Pavlo", 4009.44);
        Worker worker8= new Worker("Mykola", 2678.00);
        Worker worker9= new Worker("Sergiy", 4123.88);
        List<Worker> wor1 = new ArrayList<Worker>();
        List<Worker> wor2 = new ArrayList<Worker>();
        List<Worker> wor3 = new ArrayList<Worker>();
        wor1.add(worker1);
        wor1.add(worker2);
        wor1.add(worker3);
        wor2.add(worker4);
        wor2.add(worker5);
        wor2.add(worker6);
        wor3.add(worker7);
        wor3.add(worker8);
        wor3.add(worker9);
        Department department1 = new Department("department1");
        Department department2 = new Department("department2");
        Department department3 = new Department("department3");
        department1.setWorkers(wor1);
        department2.setWorkers(wor2);
        department3.setWorkers(wor3);
        List<Department> dep1 = new ArrayList<Department>();
        List<Department> dep2 = new ArrayList<Department>();
        dep1.add(department1);
        dep1.add(department2);
        dep2.add(department3);
        Company alfa = new Company("Alfa");
        Company beta = new Company("Beta");
        alfa.setDepartments(dep1);
        beta.setDepartments(dep2);
        System.out.println(alfa);
        System.out.println(beta);
        manager.save(alfa);
        manager.save(beta);
        //department1.setCompany(alfa);
       // department2.setCompany(alfa);
        department3.setCompany(beta);
        manager.getTransaction().commit();
        manager.close();
        sessionFactory.close();
    }
}
