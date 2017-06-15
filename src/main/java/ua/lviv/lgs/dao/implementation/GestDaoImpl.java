package ua.lviv.lgs.dao.implementation;

import org.springframework.stereotype.Repository;
import ua.lviv.lgs.dao.GestDao;
import ua.lviv.lgs.entities.Gest;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

/**
 * Created by Max on 25.04.2017.
 */
@Repository
public class GestDaoImpl implements GestDao {
    @PersistenceContext(unitName = "Main")
    private EntityManager entityManager;

    @Transactional
    public void add(Gest gest) {
        entityManager.persist(gest);
    }

    @Transactional
    public Gest findById(int id) {
        Gest gest = (Gest) entityManager.createQuery("SELECT g FROM Gest g WHERE g.id=:id").setParameter("id", id).getSingleResult();
        return gest;
    }

    @Transactional

    public Gest findByLogin(String login) {
        Gest gest = (Gest) entityManager.createQuery("SELECT g FROM Gest g WHERE g.login=:login").setParameter("login", login).getSingleResult();
        return gest;
    }
}
