package com.pnc.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:application.yml")
@ConfigurationProperties(prefix = "app")
public class GlobalProperties {

    private String url;
    private String basedn;
    private String username;
    private String password;
    private String userdnpattern;
    
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getBasedn() {
		return basedn;
	}
	public void setBasedn(String basedn) {
		this.basedn = basedn;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUserdnpattern() {
		return userdnpattern;
	}
	public void setUserdnpattern(String userdnpattern) {
		this.userdnpattern = userdnpattern;
	}
    
    
}
