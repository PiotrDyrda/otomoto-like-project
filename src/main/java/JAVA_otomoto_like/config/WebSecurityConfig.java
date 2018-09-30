package JAVA_otomoto_like.config;

import JAVA_otomoto_like.services.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * Klasa konfiguracyjna dla modułu security
 */
@EnableWebSecurity //włącza konfigurację security
@Configuration //Mówi springowi, ze ta klasa będzie konfiguracyjna
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private LoginService loginService;
//
//    /**
//     * Bean z szyfratorem
//     *
//     * @return
//     */
//    @Bean
//    public BCryptPasswordEncoder bCryptPasswordEncoder() {
//        return new BCryptPasswordEncoder();
//    }

    /**
     * Ta metoda jest najważniejsza przy ustalaniu dostępów do zasobów.
     * W jednym łańcuchu http security ustalane są dostępy w następujący sposób
     *
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()//wyłączone zabezpieczenie csrf https://pl.wikipedia.org/wiki/Cross-site_request_forgery
                .authorizeRequests() //autoryzuj żądania wg następujacych reguł:
                .antMatchers("/css/**", "/assets/**", "/js/**","/vehicle/list","/","/customer/register").permitAll() //dla requestóww /css/**", "/js/**" pozwalaj wszystkim bez wyjątku
                .antMatchers("/customer/**").hasAnyRole("USER")
                .anyRequest().authenticated()// wymagaj by wszystkie żądania były poddane autentykacji
                .and() // i...
                .formLogin() //
                .loginPage("/login")
                .permitAll() //wyświetl formę logowania pod adresem /login
                .and() // i
                .logout().logoutUrl("/logout").permitAll(); // pozwól na wylogowanie wszystkim pod adresem /logout

    }

//    /**
//     * Metoda wymusza ustawienie metody szyfrowania hasła w userDetailsService
//     * @param auth
//     * @throws Exception
//     */
//    @Autowired
//    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//        auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder());
//    }

}
