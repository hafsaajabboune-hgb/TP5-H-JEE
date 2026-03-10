package com.example.metier;


import com.example.dao.IDao;
import com.example.entities.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class ProductDaoImpl implements IDao<Product> {

    @Autowired
    private SessionFactory sessionFactory;

    protected Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public boolean create(Product product) {
        try {
            getCurrentSession().persist(product);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean delete(Product product) {
        try {
            getCurrentSession().remove(product);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean update(Product product) {
        try {
            getCurrentSession().merge(product);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Product findById(int id) {
        return getCurrentSession().get(Product.class, id);
    }

    @Override
    public List<Product> findAll() {
        Query<Product> query = getCurrentSession().createQuery("from Product", Product.class);
        return query.list();
    }
}