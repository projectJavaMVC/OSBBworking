package OSBB.Demo.demo.services;

import OSBB.Demo.demo.entity.Types;
import OSBB.Demo.demo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

/**
 * Created by Пользователь on 19.11.2015.
 */
@Service
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    private UserService userService;


    @Transactional
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {

        User user = userService.getUserByLogin(login);

        Set<GrantedAuthority> roles = new HashSet<>();
        for (Types type : Types.getAll()) {
            roles.add(new SimpleGrantedAuthority(type.name()));
        }
        UserDetails userDetails = new org.springframework.security.core.userdetails.User(user.getUser_login(),
                        user.getUser_password(),
                        roles);
        return userDetails;
    }
}
