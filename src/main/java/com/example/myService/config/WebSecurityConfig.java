package com.example.myService.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private DataSource dataSource; //application properties 내용을 사용가능하게.
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                    .antMatchers("/", "/account/login", "/accountcss/**", "/account/register", "/api/**").permitAll()
                    .anyRequest().authenticated()  //페이지를 login 하나로만 쓰더라도 POST 방식에 대한 권한을 줘야한다..이 에러로 하루가 지나갔다..
                .and()
                    .formLogin()
                    .loginPage("/account/login")
                    .permitAll()
                .and()
                    .logout()
                    .permitAll();
    }

    @Autowired  //https://www.baeldung.com/spring-security-jdbc-authentication 에서 활용
    public void configureGlobal(AuthenticationManagerBuilder auth)
            throws Exception {
        auth.jdbcAuthentication()
                .dataSource(dataSource)
                .passwordEncoder(passwordEncoder())
                .usersByUsernameQuery("select username, password, enabled "      //로그인
                        + "from user "
                        + "where username = ?")   //유저네임이 알아서 들어가는 파라미터 '?'
                .authoritiesByUsernameQuery("select u.username, r.name "       //권한
                        + "from user_role ur inner join user u on ur.user_id = u.id "
                        + "inner join role r on ur.role_id = r.id "
                        + "where u.username = ?"); //권한처리  Many to Many
        }                                               //https://www.baeldung.com/spring-security-jdbc-authentication
    @Bean
    public static PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
