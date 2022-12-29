package com.minhduc.urlshortener.controller;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.minhduc.urlshortener.service.URLConverterService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;


@RestController
public class URLController {
    private static final Logger LOGGER = LoggerFactory.getLogger(URLController.class);

    private final URLConverterService urlConverterService;
    public URLController(URLConverterService urlConverterService) {
        this.urlConverterService = urlConverterService;
    }

    @RequestMapping(value = "/shortener", method = RequestMethod.POST, consumes = {"application/json"})
    public String shortenUrl(@RequestBody @Valid final ShortenRequest shortenRequest) {
        LOGGER.info("");
        return "TODO: https://medium.com/hackernoon/url-shortening-service-in-java-spring-boot-and-redis-d2a0f8848a1d";
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