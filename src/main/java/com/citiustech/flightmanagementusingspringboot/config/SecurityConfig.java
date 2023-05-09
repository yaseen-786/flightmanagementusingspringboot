/*
 * package com.citiustech.flightmanagementusingspringboot.config;
 * 
 * import org.springframework.context.annotation.Bean; import
 * org.springframework.context.annotation.Configuration; import
 * org.springframework.security.config.annotation.web.builders.HttpSecurity;
 * import org.springframework.security.config.annotation.web.configuration.
 * EnableWebSecurity; import
 * org.springframework.security.config.annotation.web.configuration.
 * WebSecurityConfiguration; import
 * org.springframework.security.core.userdetails.User; import
 * org.springframework.security.core.userdetails.UserDetails; import
 * org.springframework.security.core.userdetails.UserDetailsService; import
 * org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder; import
 * org.springframework.security.crypto.password.PasswordEncoder; import
 * org.springframework.security.provisioning.InMemoryUserDetailsManager; import
 * org.springframework.security.web.SecurityFilterChain;
 * 
 * import jakarta.servlet.Filter;
 * 
 * @Configuration
 * 
 * @EnableWebSecurity public class SecurityConfig extends
 * WebSecurityConfiguration {
 * 
 * //Authentication
 * 
 * @Bean public UserDetailsService userdetailservic(PasswordEncoder encoder) {
 * UserDetails admin = User.withUsername(encoder.encode("admin"))
 * .password("admin123"). roles("ADMIN"). build(); return new
 * InMemoryUserDetailsManager(admin); }
 * 
 * @Bean public PasswordEncoder passwordEncoder() { return new
 * BCryptPasswordEncoder(); }
 * 
 * //Authorisation
 * 
 * @Bean public SecurityFilterChain securityFilterChai(HttpSecurity http) throws
 * Exception { return
 * http.csrf().disable().authorizeHttpRequests().requestMatchers("/users/**").
 * permitAll().
 * and().authorizeHttpRequests().requestMatchers("/admin/**").authenticated().
 * and().formLogin().and() .build(); }
 * 
 * }
 */