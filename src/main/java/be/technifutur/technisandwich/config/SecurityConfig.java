package be.technifutur.technisandwich.config;

import be.technifutur.technisandwich.jwt.JwtFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {
        return configuration.getAuthenticationManager();
    }

    @Bean
    public PasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http, JwtFilter jwtFilter) throws Exception {

        http.csrf().disable();

        http.httpBasic().disable();

        http.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);
        http.sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        http.authorizeHttpRequests((authorize) -> {
            authorize
                    .requestMatchers(HttpMethod.POST, "/auth/*").anonymous()
                    .requestMatchers(request -> request.getRequestURI().length() > 50).hasRole(("ADMIN"))

//                    .requestMatchers(HttpMethod.GET, "/sand/*")
//                    .hasAnyRole("USER", "ADMIN")
//                    .requestMatchers(HttpMethod.POST).hasRole("ADMIN")
//                    .requestMatchers( HttpMethod.PUT ).hasRole("ADMIN")
//                    .requestMatchers( HttpMethod.PATCH ).hasRole("ADMIN")
//                    .requestMatchers( HttpMethod.DELETE ).hasRole("ADMIN")
                    .anyRequest().permitAll();
        });

        return http.build();
    }
}