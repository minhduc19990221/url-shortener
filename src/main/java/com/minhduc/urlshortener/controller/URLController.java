package com.minhduc.urlshortener.controller;
// TODO: https://medium.com/hackernoon/url-shortening-service-in-java-spring-boot-and-redis-d2a0f8848a1d

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.minhduc.urlshortener.service.URLConverterService;
import com.minhduc.urlshortener.utils.URLValidator;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import javax.validation.Valid;
import java.io.IOException;
import java.net.URISyntaxException;


@RestController
public class URLController {
    private static final Logger LOGGER = LoggerFactory.getLogger(URLController.class);

    private final URLConverterService urlConverterService;
    public URLController(URLConverterService urlConverterService) {
        this.urlConverterService = urlConverterService;
    }

    @RequestMapping(value = "/shortener", method = RequestMethod.POST, consumes = {"application/json"})
    public String shortenUrl(@RequestBody @Valid final ShortenRequest shortenRequest, HttpServletRequest request) throws Exception {
          String longUrl = shortenRequest.getUrl();
          LOGGER.info("Long url to shorten: " + longUrl);
          if (URLValidator.INSTANCE.validateURL(longUrl)){
              String localURL = request.getRequestURL().toString();
              LOGGER.info("Local url to shorten: " + localURL);
              String shortenedURL = urlConverterService.shortenURL(localURL, longUrl);
              LOGGER.info("Shortened url to: " + shortenedURL);
              return shortenedURL;
          }
          throw new Exception("Please enter a valid URL");
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public RedirectView redirectUrl(@PathVariable String id, HttpServletRequest request, HttpServletResponse response) throws
            IOException, URISyntaxException, Exception {
        LOGGER.debug("Received shortened url to redirect: " + id);
        String redirectUrlString = urlConverterService.getLongURLFromID(id);
        RedirectView redirectView = new RedirectView();
        // Check if redirectUrlString includes http or https
        if (!redirectUrlString.startsWith("http://") && !redirectUrlString.startsWith("https://")){
            redirectUrlString = "http://" + redirectUrlString;
        }
        redirectView.setUrl(redirectUrlString);
        return redirectView;
    }
}
class ShortenRequest{
    private String url;

    @JsonCreator
    public ShortenRequest() {

    }

    @JsonCreator
    public ShortenRequest(@JsonProperty("url") String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}