package ua.lviv.lgs.services;

import ua.lviv.lgs.entities.Gest;

/**
 * Created by Max on 25.04.2017.
 */
public interface GestService {
    void add(String login,String name,String secondName,String email,String phone,String password);

    Gest findById(int id);

    String getLoginOfAutUser();

    Gest findByLogin(String login);

    int getLoginId(String login);

}
