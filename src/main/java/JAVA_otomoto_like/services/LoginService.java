package JAVA_otomoto_like.services;


import JAVA_otomoto_like.model.Customer;
import JAVA_otomoto_like.repositories.CustomerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class LoginService implements UserDetailsService {
    private static final Logger LOG = LoggerFactory.getLogger(LoginService.class);

    private final CustomerRepository customerRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public LoginService(CustomerRepository customerRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.customerRepository = customerRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Customer user = customerRepository
                .findByEmail(email)
                .orElseThrow(
                        () -> new UsernameNotFoundException("nie ma takiego użytkownika")
                ); //szukamy użytkownika w bazie po email


        //zwracamy obiekt użytkownika z uzupełnionymi parametrami
        return new org.springframework.security.core.userdetails.User(
                user.getEmail(), user.getHashPassword(),new HashSet<GrantedAuthority>());// to hasło jest zaszyfrowane i wzięte z bazy. Porównywane jest z
        //hasłem, który użytkownik wpisuje na formatce
    }
}
