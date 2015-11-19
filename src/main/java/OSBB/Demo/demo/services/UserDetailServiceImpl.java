package OSBB.Demo.demo.services;

import OSBB.Demo.demo.Types;
import OSBB.Demo.demo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Created by Пользователь on 19.11.2015.
 */
@Service
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    private UserService userService;


    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {

        User user = userService.getUserByLogin("login");
        // указываем роли для этого пользователя
        Set<GrantedAuthority> roles = new HashSet();
        for (Types type : Types.getAll()) {
            roles.add(new SimpleGrantedAuthority(type.name()));
        }

        UserDetails userDetails = new org.springframework.security.core.userdetails.User(user.getUser_login(),
                        user.getUser_password(),
                        roles);

        return userDetails;
    }
}
