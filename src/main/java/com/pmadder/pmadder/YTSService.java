package com.pmadder.pmadder;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class YTSService {
    private final String YTS_BASE_URL = "https://yts.mx/api/v2";

    private final RestTemplate restTemplate;

    public YTSService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public String list(String query) {
        String url = YTS_BASE_URL + "/list_movies.json?query_term=" + query;
        return this.restTemplate.getForObject(url, String.class);
    }
}
