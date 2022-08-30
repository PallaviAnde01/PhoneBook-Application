package com.PallaviAnde.Util;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Getter;
import lombok.Setter;

@Configuration
@EnableConfigurationProperties
@ConfigurationProperties("phonebook")
@Getter
@Setter
public class AppProps {

	private Map<String,String> message=new HashMap<String,String>(); 
	
}
