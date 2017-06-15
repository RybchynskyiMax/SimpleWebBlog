package ua.lviv.lgs.services.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ua.lviv.lgs.dao.GestDao;
import ua.lviv.lgs.entities.Gest;
import ua.lviv.lgs.services.GestService;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by Max on 25.04.2017.
 */
@Service
public class GestServiceImpl implements GestService, UserDetailsService {
    @Autowired
    private GestDao gestDao;

    public void add(String login, String name, String secondName, String email, String phone, String password) {
        Gest gest = new Gest(login, name, secondName, email, phone, password);
        gestDao.add(gest);
    }

    public Gest findById(int id) {
        return gestDao.findById(id);

    }

    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        Gest gest = gestDao.findByLogin(login);
        Collection<GrantedAuthority> grantedAuthorityCollation = new ArrayList<GrantedAuthority>();
        grantedAuthorityCollation.add(new SimpleGrantedAuthority("ROLE_USER"));
        return new User(gest.getLogin(), gest.getPassword(), grantedAuthorityCollation);
    }

    public String getLoginOfAutUser() {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return user.getUsername();
    }

    public Gest findByLogin(String login) {
        return gestDao.findByLogin(login);
    }

    public int getLoginId(String login) {
        return gestDao.findByLogin(login).getId();
    }
}
