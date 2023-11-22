package com.tup.buensabor.Config;


import com.tup.buensabor.JWT.JwtAuthenticationFilter;

import lombok.RequiredArgsConstructor;

import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.HeadersConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    private final JwtAuthenticationFilter jwtAuthenticationFilter;
    private final AuthenticationProvider authProvider;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception
    {
        return http
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(authRequest ->
                                authRequest
                                        //Autenticacion
                                        .requestMatchers(new AntPathRequestMatcher("/auth/**")).permitAll()
                                        .requestMatchers(new AntPathRequestMatcher("/auth/register")).permitAll()


                                        //Consola H2:
                                        .requestMatchers(PathRequest.toH2Console()).permitAll()

                                        //Autorizacion de acceso a la url:

                                        .requestMatchers(new AntPathRequestMatcher("/api/demoAdmin/**")).hasAuthority("ADMIN")
                                        .requestMatchers(new AntPathRequestMatcher("/api/demoUser/**")).hasAuthority("USER")

                                        .requestMatchers(new AntPathRequestMatcher("/auth/login")).hasAnyAuthority("ADMIN","USER")
                                        .requestMatchers(new AntPathRequestMatcher("/api/clientes/**")).hasAnyAuthority("ADMIN")
                                        .requestMatchers(new AntPathRequestMatcher("/api/domicilios/**")).hasAnyAuthority("ADMIN")
                                        .requestMatchers(new AntPathRequestMatcher("/api/rubrosarticulo/**")).hasAnyAuthority("ADMIN")
                                        .requestMatchers(new AntPathRequestMatcher("/api/rubrosarticulomanufacturados/**")).hasAnyAuthority("ADMIN")
                                        .requestMatchers(new AntPathRequestMatcher("/api/facturas/**")).hasAnyAuthority("ADMIN")
                                        .requestMatchers(new AntPathRequestMatcher("/api/articulosmanufacturado/**")).hasAnyAuthority("ADMIN")
                                        .requestMatchers(new AntPathRequestMatcher("/api/articulosinsumo/**")).hasAnyAuthority("ADMIN")

                )
                .cors(Customizer.withDefaults())
                .headers(headers -> headers.frameOptions(HeadersConfigurer.FrameOptionsConfig::disable)) //H2
                .sessionManagement(sessionManager ->
                        sessionManager
                                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                )
                .authenticationProvider(authProvider)
                .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class)
                .build();
    }

    @Bean
    CorsConfigurationSource corsConfigurationSource() {

        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(Arrays.asList("*"));
        configuration.setAllowedMethods(Arrays.asList("*"));
        configuration.setAllowedHeaders(Arrays.asList("*"));
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }


}