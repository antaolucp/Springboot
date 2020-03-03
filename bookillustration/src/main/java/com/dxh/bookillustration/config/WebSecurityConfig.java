package com.dxh.bookillustration.config;

import com.dxh.bookillustration.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private LoginService loginService;
    // 依赖注入用户认证接口
    // 依赖注入加密接口
    @Autowired
    private PasswordEncoder passwordEncoder;

    // 依赖注入用户认证接口
    @Autowired
    private AuthenticationProvider authenticationProvider;

    /*
     *  BCryptPasswordEncoder是Spring Security提供的PasswordEncoder接口是实现类
     *  用来创建密码的加密程序，避免明文存储密码到数据库
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    // DaoAuthenticationProvider是Spring Security提供AuthenticationProvider的实现
    @Bean
    public AuthenticationProvider authenticationProvider() {
        // 创建DaoAuthenticationProvider对象
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        // 不要隐藏"用户未找到"的异常
        provider.setHideUserNotFoundExceptions(false);
        // 通过重写configure方法添加自定义的认证方式。
        provider.setUserDetailsService(loginService);
        // 设置密码加密程序认证
        provider.setPasswordEncoder(passwordEncoder);
        return provider;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        System.out.println("AppSecurityConfigurer configure auth......");
        // 设置认证方式。
        auth.authenticationProvider(authenticationProvider);

    }

    @Configuration
    @Order(1)
    public static class UserConfigurationAdapter extends WebSecurityConfigurerAdapter {
        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http
                    .antMatcher("/user/**")
                    .formLogin().loginPage("/user/login")
                    //设置登陆成功页
                    .successForwardUrl("/user")
                    .and()
                    .logout()
                    .logoutUrl("/user/loginout")
                    .logoutSuccessUrl("/").permitAll()
                    .and()
                    .authorizeRequests() //启用基于 HttpServletRequest 的访问限制，开始配置哪些URL需要被保护、哪些不需要被保护
                    .antMatchers("/user/reset/**","/user/register/**","/","/user","/user/us/**","/user/u/**","/user/hua/**","/user/*","/user/find/**").permitAll()//未登陆用户允许的请求
                    .anyRequest().hasAnyRole("USER")//其他/fore路径下的请求全部需要登陆，获得USER角色
                    .and()
                    .headers().frameOptions().disable()//关闭X-Frame-Options
                    .and()
                    .csrf().disable();

        }
    }

    @Configuration
    @Order(2)
    public static class FormLoginWebSecurityConfigurerAdapter extends WebSecurityConfigurerAdapter {
        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http
                    .antMatcher("/admin/**")
                    .formLogin()
                    .loginPage("/admin/login")
                    .defaultSuccessUrl("/admin/index",true)
                    .failureUrl("/admin/login?error")
                    .permitAll()
                    .and()
                    .authorizeRequests()//启用基于 HttpServletRequest 的访问限制，开始配置哪些URL需要被保护、哪些不需要被保护
                    .antMatchers("/admin/**").hasAnyRole("ADMIN")//其他/admin路径下的请求全部需要登陆，获得USER角色
                    .and()
                    .csrf().disable();
        }
    }

    @Configuration
    @Order(3)
    public static class OtherSecurityConfigurationAdapter extends WebSecurityConfigurerAdapter {
        protected void configure(HttpSecurity http) throws Exception {
            http
                    .authorizeRequests()//启用基于 HttpServletRequest 的访问限制，开始配置哪些URL需要被保护、哪些不需要被保护
                    .antMatchers("/","/dist/**","/css/**", "/imges/**", "/js/**").permitAll()//其他请求放行
                    .and()
                    .csrf()
                    .disable();//未登陆用户允许的请求
        }
    }
}
