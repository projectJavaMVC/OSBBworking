package ua.kiev.prog.services;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import ua.kiev.prog.entity.UserEntity;
import ua.kiev.prog.repositories.UserEntityRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserEntityRepository userEntityRepository;

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        UserEntity user = userEntityRepository.findOneByLogin(login);
        if(null == user) throw new UsernameNotFoundException("User not found");
        Set<GrantedAuthority> roles = new HashSet();

        roles.add(new SimpleGrantedAuthority("ADMIN"));

        UserDetails userDetails =
                new org.springframework.security.core.userdetails.User(user.getLogin(), user.getPass(), roles);

        return userDetails;
    }

}
