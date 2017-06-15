package ua.lviv.lgs.dao;

import ua.lviv.lgs.entities.Gest;

/**
 * Created by Max on 25.04.2017.
 */
public interface GestDao {
    void add(Gest gest);

    Gest findById(int id);

    Gest findByLogin(String login);
}
