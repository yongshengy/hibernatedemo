package local.test.hibernate;

import local.test.hibernate.entity.School;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.ArrayList;
import java.util.List;

public class CrudTest {

    /**
     * 下面都是按照对象的方式进行CRUD；
     * 步骤:
     *  加载配置文件
     *  创建会话工厂
     *  创建会话session
     *  开启事务
     *  持久化操作
     *  提交事务
     *  关闭事务
     *  关闭会话
     */
    @Test
    public void findOne() {
        Configuration configuration = new Configuration().configure("hibernate.cfg.xml");
        SessionFactory sessionFactory = configuration.buildSessionFactory();

        Session session = sessionFactory.openSession();
        School school = session.get(School.class, 1);
        System.out.println(school.getAddress());
    }

    @Test
    public void saveOne(){
        Configuration configuration = new Configuration().configure("hibernate.cfg.xml");
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();

        Transaction transaction = session.beginTransaction();

        School school = new School();
        school.setScname("Java一中");
        school.setAddress("Java三路");

        session.save(school);
        transaction.commit();
        session.close();
        sessionFactory.close();
    }

    @Test
    public void updateOne(){
        Configuration configuration = new Configuration().configure("hibernate.cfg.xml");
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();

        Transaction transaction = session.beginTransaction();
        School school = session.get(School.class, 1);
        school.setScname("西安4中");

        transaction.commit();
        session.close();
        sessionFactory.close();
    }

    @Test
    public void deleteOne() {
        Configuration configuration = new Configuration().configure("hibernate.cfg.xml");
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();

        Transaction transaction = session.beginTransaction();
        School school = session.get(School.class, 1);
       session.delete(school);

        transaction.commit();
        session.close();
        sessionFactory.close();
    }

    @Test
    public void find1() {
        Configuration configuration = new Configuration().configure("hibernate.cfg.xml");
        SessionFactory sessionFactory = configuration.buildSessionFactory();

        Session session = sessionFactory.openSession();
//        School school = new School();
//        List<String> matches = new ArrayList<String>();
//        school.setAddress("aaa");
//        matches.add("address");
//        school.setScname("a");
//        matches.add("scname");
//        String[] matchProperties = matches.toArray(new String[] {});
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<School> criteriaQuery = criteriaBuilder.createQuery(School.class);
//        criteriaQuery.from

//        System.out.println(school.getAddress());
    }

}
