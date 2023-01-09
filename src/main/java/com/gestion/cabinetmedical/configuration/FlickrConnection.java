package com.gestion.cabinetmedical.configuration;

import com.flickr4java.flickr.Flickr;
import com.flickr4java.flickr.REST;
import com.flickr4java.flickr.RequestContext;
import com.flickr4java.flickr.auth.Auth;
import com.flickr4java.flickr.auth.Permission;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FlickrConnection {
    @Value("${flickr.apiKey}")
    private String apiKey;
    @Value("${flickr.apiSecret}")
    private String apiSecret;
    @Value("${flickr.appKey}")
    private String appKey;
    @Value("${flickr.appSecret}")
    private String appSecret;

    @Bean
    public Flickr getFlick(){
     Flickr flickr = new Flickr(apiKey, apiSecret, new REST());
     Auth auth = new Auth();
     auth.setToken(appKey);
     auth.setTokenSecret(appSecret);
     auth.setPermission(Permission.DELETE);
     RequestContext requestContext = RequestContext.getRequestContext();
     requestContext.setAuth(auth);
     flickr.setAuth(auth);
     return flickr;
    }
}
