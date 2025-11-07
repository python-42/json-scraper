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

    private final String PORT = "8080/";

    @GetMapping("/**")
    public String index(HttpServletRequest request) {
        String url = request.getRequestURL().toString() + "?" +request.getQueryString();
        
        url = url.substring(url.indexOf(PORT) + PORT.length());
        logger.trace(url);

        return ScraperController.getInstance().scrape(url);
    }
}
