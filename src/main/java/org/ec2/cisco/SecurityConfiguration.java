package org.ec2.cisco;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@EnableWebSecurity
@Configuration
//@PropertySource("classpath:application.properties")
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

  @Override
  protected void configure(HttpSecurity http) throws Exception {
	  
      http
              .csrf()
              .disable()
              .antMatcher("/**")
              .authorizeRequests()
              .antMatchers( "/static/**", "/js/**", "/css/**", 
                			 "/login**", "/")
                  .permitAll()
                  .anyRequest()           
                  .authenticated().and()
                  .exceptionHandling().accessDeniedPage("/login_error")
                  .and()
              .formLogin()
	              .loginPage("/login")
	              .defaultSuccessUrl("/listAllec2s")
	              .permitAll()
	          .and()
              .logout()
	            .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
	            .clearAuthentication(true)
	            .logoutSuccessUrl("/").deleteCookies("JSESSIONID")
	            .invalidateHttpSession(true);
              
      http.headers().frameOptions().disable();
      

	  
  }
  
  @Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth
			.inMemoryAuthentication()
				.withUser("user").password("password").roles("USER");
	}

}
