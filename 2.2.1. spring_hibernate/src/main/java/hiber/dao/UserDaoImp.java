package hiber.dao;

import hiber.model.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void add(User user) {
        sessionFactory.getCurrentSession().persist(user);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<User> listUsers() {
        TypedQuery<User> query = sessionFactory.getCurrentSession().createQuery("from User");
        return query.getResultList();
    }

    @Override
    public User getUserByCar(String model, int series) {
        String hql = "from User u where u.car.model = :model and u.car.series = :series";
        Session session = sessionFactory.getCurrentSession();
        Query<User> query = session.createQuery(hql, User.class);
        query.setParameter("model", model);
        query.setParameter("series", series);
        return query.uniqueResult();
    }
}
