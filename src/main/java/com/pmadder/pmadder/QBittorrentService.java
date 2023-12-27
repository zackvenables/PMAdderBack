package com.pmadder.pmadder;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

@Service
public class QBittorrentService {
    private final String QBITTORRENT_BASE_URL = "http://192.168.50.94:8080/api/v2/torrents";

    private final RestTemplate restTemplate;

    public QBittorrentService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public String info(){
        String base = QBITTORRENT_BASE_URL + "/info";
        return this.restTemplate.getForObject(base, String.class);
    }

    public String add(String url) {
        String base = QBITTORRENT_BASE_URL + "/add";
        String savepath = "\\\\desktop-9jpgckm\\Media\\temp";

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        MultiValueMap<String, String> map= new LinkedMultiValueMap<String, String>();
        map.add("urls", url);
        map.add("savepath", savepath);

        HttpEntity<MultiValueMap<String, String>> request =
                new HttpEntity<MultiValueMap<String, String>>(map, headers);

        return this.restTemplate.postForObject(base, request, String.class);
    }

    public String pause (String hash){
        String base = QBITTORRENT_BASE_URL + "/pause";

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        MultiValueMap<String, String> map= new LinkedMultiValueMap<String, String>();
        map.add("hashes", hash);

        HttpEntity<MultiValueMap<String, String>> request =
                new HttpEntity<MultiValueMap<String, String>>(map, headers);

        return this.restTemplate.postForObject(base, request, String.class);
    }

    public String resume (String hash){
        String base = QBITTORRENT_BASE_URL + "/resume";

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        MultiValueMap<String, String> map= new LinkedMultiValueMap<String, String>();
        map.add("hashes", hash);

        HttpEntity<MultiValueMap<String, String>> request =
                new HttpEntity<MultiValueMap<String, String>>(map, headers);

        return this.restTemplate.postForObject(base, request, String.class);
    }

    public String delete (String hash){
        String base = QBITTORRENT_BASE_URL + "/delete";

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        MultiValueMap<String, String> map= new LinkedMultiValueMap<String, String>();
        map.add("hashes", hash);

        HttpEntity<MultiValueMap<String, String>> request =
                new HttpEntity<MultiValueMap<String, String>>(map, headers);

        return this.restTemplate.postForObject(base, request, String.class);
    }
}
