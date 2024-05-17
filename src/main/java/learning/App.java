package learning;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class App {

    public static void main(String[] args) {

        // Setting data in database
        // OLD Method 
        Configuration con = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class);
        SessionFactory sf = con.buildSessionFactory();

        // Session s1 = sf.openSession();
        // s1.beginTransaction();
        // Random r = new Random();
        // for (int i=1;i<=50;i++){
        //     Student st = new Student();
        //     st.setId(i);
        //     st.setMarks(r.nextInt(100));
        //     st.setName("studen " +i);
        //     s1.persist(st);
        // }
        // s1.getTransaction().commit(); 


        // Student st=s1.get(Student.class, 10);
        // System.out.println(st.getName());

        // using HQL

        // Session s1 = sf.openSession();
        // s1.beginTransaction();
        // Query q1 = s1.createQuery("from Student", Student.class);
        // List<Student> students = q1.list();

        // for (Student s : students) {
        //     System.out.println(s);
        // }
        // s1.getTransaction().commit();



        // Session s1 = sf.openSession();
        // s1.beginTransaction();
        // Query q1 = s1.createQuery("from Student where marks>90", Student.class);
        // List<Student> students = q1.list();

        // for (Student s : students) {
        //     System.out.println(s);
        // }
        // s1.getTransaction().commit();



        // Session s1 = sf.openSession();
        // s1.beginTransaction();
        // Query q1 = s1.createQuery("from Student where id=10", Student.class);
        // Student st = (Student)q1.uniqueResult();
        // System.out.println(st.getId() + st.getMarks()+st.getName());
        // s1.getTransaction().commit();

        // Session s1 = sf.openSession();
        // s1.beginTransaction();
        // Query q1 = s1.createQuery(" select id,name, marks from Student where id=50", Student.class);
        //  Student st = (Student)q1.uniqueResult();
        //  System.out.println(st);
        // s1.getTransaction().commit();



        // Session s1 = sf.openSession();
        // s1.beginTransaction();
        // Query q1 = s1.createQuery(" select sum(id) from Student where id <6", Student.class);
        //  Long marks= (Long) q1.uniqueResult();
        //  System.out.println(marks); 
        // s1.getTransaction().commit();




        // int givenid=10;
        // Session s1 = sf.openSession();
        // s1.beginTransaction();
        // //Query q1 = s1.createQuery(" select sum(id) from Student where id <"+givenid, Student.class);
        // Query q1 = s1.createQuery(" select sum(id) from Student where id < :givenid", Student.class);
        // q1.setParameter("givenid", givenid);
        //  Long marks= (Long) q1.uniqueResult();
        //  System.out.println(marks); 
        // s1.getTransaction().commit();


          Session s1 = sf.openSession();
        s1.beginTransaction();
        Query query =s1.createNativeQuery("select * from student where id >40 and marks>70",Student.class);

        List<Student> st = query.list();
        for( Student s: st){
            System.out.println(s);
        }
        s1.getTransaction().commit();

    }
}
