package com.jlh.json_scraper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ScraperController {
    private static ScraperController instance = null;
    public static ScraperController getInstance() {
        if (instance == null) {
            instance = new ScraperController();
        }
        return instance;
    }

    private final Logger logger = LoggerFactory.getLogger(getClass());
    private final Scraper[] scrapers = new Scraper[5];

    public ScraperController() {
        for (int i = 0; i < scrapers.length; i++) {
            scrapers[i] = new Scraper();
        }
    }

    public String scrape(String url) {
        return getAvailable().getJSON(url);
    }

    private Scraper getAvailable() {
        for (Scraper s : scrapers) {
            if (!s.isBusy()) {
                return s;
            }
        }
        // we are at the end of the list and all scrappers are busy, wait for one to free up
        
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {}
        logger.debug("All scrappers occupied, waiting until one is freed.");
        return getAvailable();
    }
}
