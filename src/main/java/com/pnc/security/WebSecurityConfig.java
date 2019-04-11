package com.pnc.security;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 *
 */
@Configuration
public class WebSecurityConfig  extends WebSecurityConfigurerAdapter   {
	
	@Value("${ldap.urls}")
	private String ldapUrls;
	
	@Value("${ldap.base}")
	private String ldapBaseDn;
	
	@Value("${ldap.username}")
	private String ldapSecurityPrincipal;
	
	@Value("${ldap.password}")
	private String ldapPrincipalPassword;
	
	@Value("${ldap.pattern}")
	private String ldapUserDnPattern;
	
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
        System.out.println("http security");
		/*http
        	.authorizeRequests()
        		.antMatchers("/catalog/book")
        		.fullyAuthenticated()
        		.and().formLogin().and().csrf().disable();*/
        http
    	.authorizeRequests()
    		.antMatchers("/catalog/book","/sendHeaders.do")
    		.fullyAuthenticated()
    		.and().httpBasic().and().csrf().disable();
	}
	
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		auth
				.ldapAuthentication()
				.contextSource()
					.url(ldapUrls + ldapBaseDn)
						.managerDn(ldapSecurityPrincipal)
						.managerPassword(ldapPrincipalPassword)
					.and()
						.userDnPatterns(ldapUserDnPattern);
		
	}
}