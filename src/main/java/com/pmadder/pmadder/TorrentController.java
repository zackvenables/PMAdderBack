package com.pmadder.pmadder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TorrentController {
    @Autowired
    YTSService ytsService;

    @Autowired
    QBittorrentService qBittorrentService;

//    @Autowired
//    FileService fileService;

    @GetMapping("/search")
    public String searchByName(@RequestParam String query) {
        return ytsService.list(query);
    }

    @GetMapping("/info")
    public String info(){
        return qBittorrentService.info();
    }

    @PostMapping("/add")
    public String add(@RequestParam String url){
        return qBittorrentService.add(url);
    }

    @PostMapping("/pause")
    public String pause(@RequestParam String hash){
        return qBittorrentService.pause(hash);
    }

    @PostMapping("/resume")
    public String resume(@RequestParam String hash){
        return qBittorrentService.resume(hash);
    }

    @PostMapping("/delete")
    public String delete(@RequestParam String hash){
        return qBittorrentService.delete(hash);
    }

//    @GetMapping("/validate")
//    public boolean validate(@RequestParam String title){
//        return fileService.validate(title);
//    }
}
