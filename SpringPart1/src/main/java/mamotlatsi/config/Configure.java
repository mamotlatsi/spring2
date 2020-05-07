package mamotlatsi.config;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class Configure extends WebSecurityConfigurerAdapter {

    PasswordEncoder passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception{
        auth.inMemoryAuthentication()
                .passwordEncoder(passwordEncoder)
                .withUser("mamotlatsi")
                .password(passwordEncoder.encode("mathatha"))
                .roles("user");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/user")
                .authenticated()
                .antMatchers("/user")
                .permitAll()
                .and()
                .httpBasic();
    }
}


