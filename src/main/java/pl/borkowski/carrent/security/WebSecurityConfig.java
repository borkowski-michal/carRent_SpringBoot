package pl.borkowski.carrent.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import pl.borkowski.carrent.service.MyUserDetailsService;

@EnableWebSecurity
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private MyUserDetailsService myUserDetailsService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(myUserDetailsService)
                .passwordEncoder(bCryptPasswordEncoder);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.authorizeRequests()
                .antMatchers("/carRent").permitAll()
                .antMatchers("/carRent/login").permitAll()
                .antMatchers("/carRent/register").permitAll()
                .antMatchers("/carRent/rent").hasAnyAuthority("user", "admin")
                .antMatchers("/carRent/admin").hasAuthority("admin").anyRequest()
                .authenticated().and().csrf().disable().formLogin().loginPage("/carRent/login")
                .failureUrl("/login?error=true")
                .defaultSuccessUrl("/carRent/rent")
                .usernameParameter("email")
                .passwordParameter("password");
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
            web.ignoring().antMatchers("/resources/**", "/static/**", "/css/**", "/js/**", "/image/**");

    }
}
