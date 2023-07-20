package kr.co.jhta.security;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true)
public class SecurityConfig {

	@Bean
	public SecurityFilterChain config(HttpSecurity http) throws Exception{
        return http
                .formLogin(
                        config -> {
                            config.loginPage("/login");
                            config.usernameParameter("id");
                            config.passwordParameter("password");
                            config.loginProcessingUrl("/login"); 
                            config.defaultSuccessUrl("/"); 
                            config.failureUrl("/login?error=fail"); 
                        }
                )
                .logout(
                        config -> {
                            config.logoutUrl("/logout"); 
                            config.logoutSuccessUrl("/");
                            config.invalidateHttpSession(true); 
                        }
                )
                .exceptionHandling(
                        config -> {
                            config.authenticationEntryPoint(
                                    (req, res, handler) -> res.sendRedirect("/login?error=denied")
                            );
                            
                            config.accessDeniedHandler(
                                    (req, res, handler) -> res.sendRedirect("/login?error=forbidden")
                            );
                        }
                )
                .build();
    }
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	} 
}
