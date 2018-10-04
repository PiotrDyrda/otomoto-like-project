package JAVA_otomoto_like.config;

import JAVA_otomoto_like.services.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * Klasa konfiguracyjna dla modułu security
 */
@Configuration //Mówi springowi, ze ta klasa będzie konfiguracyjna
@EnableWebSecurity //włącza konfigurację security
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private LoginService loginService;

    /**
     * Bean z szyfratorem
     *
     * @return
     */
    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }




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
                .antMatchers("/resources/**","/css/**", "/assets/**", "/js/**","/","/customer/**").permitAll() //dla requestóww /css/**", "/js/**" pozwalaj wszystkim bez wyjątku
                .antMatchers().hasAnyRole()
                .anyRequest().authenticated()// wymagaj by wszystkie żądania były poddane autentykacji
                .and() // i...
                .formLogin() //
                .loginPage("/login").defaultSuccessUrl("/",true).usernameParameter("email").passwordParameter("hashPassword")
                .permitAll() //wyświetl formę logowania pod adresem /login
                .and() // i
                .logout().logoutUrl("/logout").logoutSuccessUrl("/").permitAll(); // pozwól na wylogowanie wszystkim pod adresem /logout

    }

//    @Override
//    public void configure(WebSecurity web) throws Exception {
//        web.ignoring().antMatchers("/javax.faces.resource/**", "/custom.css", "/img/**","/resources/**");
//    }

   /**
    * Metoda wymusza ustawienie metody szyfrowania hasła w userDetailsService
    * @param auth
    * @throws Exception
    */
   @Autowired
   public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
       auth.userDetailsService(loginService).passwordEncoder(bCryptPasswordEncoder());
  }

}
