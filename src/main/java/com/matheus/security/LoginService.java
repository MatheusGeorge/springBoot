package com.matheus.security;

import com.matheus.model.Usuario;
import org.springframework.security.authentication.AccountStatusUserDetailsChecker;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Service
public class LoginService implements UserDetailsService{

    @PersistenceContext
    private EntityManager manager;

    private final AccountStatusUserDetailsChecker detailsChecker;

    public LoginService() {
        detailsChecker = new AccountStatusUserDetailsChecker();
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        try {
            return manager.createQuery("SELECT u FROM Usuario u WHERE u.email = :email", Usuario.class)
                    .setParameter("email", s)
                    .getSingleResult();
        } catch (UsernameNotFoundException e) {
            throw e;
        }
    }
}
