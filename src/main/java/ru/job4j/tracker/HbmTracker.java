package ru.job4j.tracker;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.ArrayList;
import java.util.List;

public class HbmTracker implements Store, AutoCloseable {
    private final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
            .configure().build();
    private final SessionFactory sf = new MetadataSources(registry)
            .buildMetadata().buildSessionFactory();

    @Override
    public Item add(Item item) {
        Session session = sf.openSession();
        session.beginTransaction();
        session.save(item);
        session.getTransaction().commit();
        session.close();
        return item;
    }

    @Override
    public boolean replace(int id, Item item) {
        boolean rsl = false;
        Session session = sf.openSession();
        session.beginTransaction();
        int update = session.createQuery(
                "update Item set name = :fName, created = :fCreated where id = :fId")
                        .setParameter("fName", item.getName())
                                .setParameter("fCreated", item.getCreated())
                                        .setParameter("fId", id)
                                                .executeUpdate();
        session.getTransaction().commit();
        rsl = update > 0;
        session.close();
        return rsl;
    }

    @Override
    public boolean delete(int id) {
        boolean rsl;
        Session session = sf.openSession();
        session.beginTransaction();
        int update = session.createQuery(
                "delete Item where id = :fId").setParameter("fId", id).executeUpdate();
        session.getTransaction().commit();
        rsl = update > 0;
        return rsl;
    }

    @Override
    public List<Item> findAll() {
        List<Item> rsl = new ArrayList<>();
        Session session = sf.openSession();
        rsl = session.createQuery(
                "from Item", Item.class).list();
        return rsl;
    }

    @Override
    public List<Item> findByName(String key) {
        List<Item> rsl = new ArrayList<>();
        Session session = sf.openSession();
        rsl = session.createQuery(
                "from Item where name = :fName", Item.class)
                .setParameter("fName", key).list();
        return rsl;
    }

    @Override
    public Item findById(int id) {
        Item rsl = null;
        Session session = sf.openSession();
        rsl = session.createQuery(
                "from Item where id = :fId", Item.class)
                .setParameter("fId", id)
                .uniqueResult();
        return rsl;
    }

    @Override
    public void close() throws Exception {
        StandardServiceRegistryBuilder.destroy(registry);
    }
}
