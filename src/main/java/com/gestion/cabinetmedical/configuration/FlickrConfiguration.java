package com.gestion.cabinetmedical.configuration;


import com.flickr4java.flickr.Flickr;
import com.flickr4java.flickr.FlickrException;
import com.flickr4java.flickr.REST;
import com.flickr4java.flickr.auth.Auth;
import com.github.scribejava.apis.FlickrApi;
import com.github.scribejava.core.builder.ServiceBuilder;
import com.github.scribejava.core.model.OAuth1AccessToken;
import com.github.scribejava.core.model.OAuth1RequestToken;
import com.github.scribejava.core.oauth.OAuth10aService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.ExecutionException;

//@Configuration
public class FlickrConfiguration {

    @Value("${flickr.apiKey}")
    private String apiKey;
    @Value("${flickr.apiSecret}")
    private String apiSecret;
    @Value("${flickr.appKey}")
    private String appKey;
    @Value("${flickr.appSecret}")
    private String appSecret;

    //@Bean
    public Flickr getFlickr() throws InterruptedException, ExecutionException, IOException, FlickrException {
        Flickr flickr = new Flickr(apiKey, apiSecret, new REST());
        OAuth10aService service = new ServiceBuilder(apiKey).apiSecret(apiSecret).build(
          FlickrApi.instance(FlickrApi.FlickrPerm.DELETE)
        );
        final OAuth1RequestToken requestToken = service.getRequestToken();
        final String authUrl = service.getAuthorizationUrl(requestToken);
        System.out.println(authUrl);
        Scanner scanner = new Scanner(System.in);
        System.out.println("place it here : ");
        final String authVerify = scanner.nextLine();
        OAuth1AccessToken accessToken = service.getAccessToken(requestToken, authVerify);
        Auth auth = flickr.getAuthInterface().checkToken(accessToken);
        System.out.println(auth.getToken());
        System.out.println(auth.getTokenSecret());
        return flickr;
    }


}
