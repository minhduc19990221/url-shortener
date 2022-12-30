package com.minhduc.urlshortener.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class URLValidator {
    public static final URLValidator INSTANCE = new URLValidator();
    private static final String URL_REGEX = "^(http|https)://(www\\.)?[a-zA-Z0-9]+([\\-\\.]{1}[a-zA-Z0-9]+)*\\.[a-zA-Z]{2,5}(:[0-9]{1,5})?(\\/.*)?$";
    private static final Pattern URL_PATTERN = Pattern.compile(URL_REGEX);

    // Regex to check if a string is a valid URL.


    private URLValidator() {

    }

    public boolean validateURL(String url){
        Matcher m = URL_PATTERN.matcher(url);
        return m.matches();
    }
}
