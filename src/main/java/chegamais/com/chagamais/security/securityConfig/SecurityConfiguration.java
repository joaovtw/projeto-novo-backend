package chegamais.com.chagamais.security.securityConfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

    @Bean
    public SecurityFilterChain filterChain (HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers(HttpMethod.POST, "/api/services/controller/usuario").permitAll()
                .anyRequest().authenticated()
                .and()
                .httpBasic();

        return http.build();


        /* -- Trecho de código com WEBSecurityConfigurerAdapter--
        http.cors().and().authorizeRequests((authorize) -> authorize
                .antMatchers(HttpMethod.POST, "/api/services/controller/user").permitAll() // ALTERAR PADRAO
                .anyRequest().authenticated()
                .and()
                .addFilterBefore(new JWTAuthenticationFilter(authentication -> authentication), JWTAuthorizationFilter.class)
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        return http.build();
         */
    }


    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails usuario = User.builder()
                .username("usuario")
                .password("senha")
                .roles("USER")
                .build();

        return new InMemoryUserDetailsManager(usuario); // TODO: Alterar para banco de dados (JDBC)
    }

}
