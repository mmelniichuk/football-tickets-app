package spring.web.config;

import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    private final UserDetailsService userDetailsService;
    private final PasswordEncoder passwordEncoder;

    public SecurityConfig(UserDetailsService userDetailsService, PasswordEncoder passwordEncoder) {
        this.userDetailsService = userDetailsService;
        this.passwordEncoder = passwordEncoder;
    }

    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder);
    }

    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/register", "/inject").permitAll()
                .antMatchers(HttpMethod.GET, "/games", "/stadiums",
                        "/matches/*").hasAnyRole("USER", "ADMIN")
                .antMatchers(HttpMethod.GET, "/admin", "/users/by-email").hasRole("ADMIN")
                .antMatchers(HttpMethod.POST, "/games", "/stadiums", "/matches").hasRole("ADMIN")
                .antMatchers(HttpMethod.PUT, "/matches/*").hasRole("ADMIN")
                .antMatchers(HttpMethod.DELETE, "/matches/*").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET, "/index", "/orders",
                        "/shopping-carts/by-user").hasRole("USER")
                .antMatchers(HttpMethod.POST, "/orders/complete",
                        "/shopping-carts/matches").hasRole("USER")
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .permitAll()
                .and()
                .httpBasic()
                .and()
                .csrf().disable();
    }
}
