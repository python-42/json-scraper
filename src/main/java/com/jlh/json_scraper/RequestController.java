package com.jlh.json_scraper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;

@RestController
@CrossOrigin(origins = "*")
public class RequestController {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @GetMapping("/**")
    public String index(HttpServletRequest request) {
        String url = request.getRequestURL().toString() + "?" +request.getQueryString();
        
        url = url.substring(url.lastIndexOf("https://"));
        logger.trace(url);

        return ScraperController.getInstance().scrape(url);
    }
}
