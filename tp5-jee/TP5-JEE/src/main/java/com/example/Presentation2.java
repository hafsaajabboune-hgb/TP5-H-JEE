package com.example;

import com.example.dao.IDao;
import com.example.entities.Product;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.example.util.HibernateConfig;

public class Presentation2 {
    public static void main(String[] args) {
        ApplicationContext context =
                new AnnotationConfigApplicationContext(HibernateConfig.class);

        IDao<Product> productDao = context.getBean(IDao.class);

        Product product1 = new Product();
        product1.setName("PC Gaming MSI");
        product1.setPrice(1549.99);

        if (productDao.create(product1)) {
            System.out.println(" Produit créé avec succès!");
            System.out.println("ID: " + product1.getId());
            System.out.println("Nom: " + product1.getName());
            System.out.println("Prix: " + product1.getPrice());
        }

        Product product2 = new Product();
        product2.setName("Samsung Galaxy S25");
        product2.setPrice(969.99);

        if (productDao.create(product2)) {
            System.out.println(" Produit créé avec succès!");
            System.out.println("ID: " + product2.getId());
            System.out.println("Nom: " + product2.getName());
            System.out.println("Prix: " + product2.getPrice());
        }

        Product product3 = new Product();
        product3.setName("Casque Bluetooth Sony");
        product3.setPrice(199.99);

        if (productDao.create(product3)) {
            System.out.println(" Produit créé avec succès!");
            System.out.println("ID: " + product3.getId());
            System.out.println("Nom: " + product3.getName());
            System.out.println("Prix: " + product3.getPrice());
        }

        Product product4 = new Product();
        product4.setName("Tablette iPad Pro");
        product4.setPrice(889.99);

        if (productDao.create(product4)) {
            System.out.println(" Produit créé avec succès!");
            System.out.println("ID: " + product4.getId());
            System.out.println("Nom: " + product4.getName());
            System.out.println("Prix: " + product4.getPrice());
        }

        Product product5 = new Product();
        product5.setName("Montre Connectée Apple Watch");
        product5.setPrice(445.99);

        if (productDao.create(product5)) {
            System.out.println(" Produit créé avec succès!");
            System.out.println("ID: " + product5.getId());
            System.out.println("Nom: " + product5.getName());
            System.out.println("Prix: " + product5.getPrice());
        }

        System.out.println("\n Liste des produits:");
        for (Product p : productDao.findAll()) {
            System.out.println("   " + p);
        }

        ((AnnotationConfigApplicationContext) context).close();
    }
}