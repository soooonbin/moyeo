package com.moyeo.controller;

import com.moyeo.dto.UrlDTO;
import com.moyeo.entity.UrlEntity;
import com.moyeo.service.UrlService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/url")
public class UrlController {
    private final UrlService urlService;

    // 단축 URL 생성 요청 (원본 URL을 JSON으로 받음)
    @PostMapping("/shorten")
    public ResponseEntity<String> save(@RequestBody Map<String, String> request) {
        String originalUrl = request.get("oriUrl");
        String shortUrl = urlService.save(originalUrl);
        return ResponseEntity.ok(shortUrl);
    }

    // 단축 URL 접근 → 원본으로 redirect
    @GetMapping("/{shortUrl}")
    public ResponseEntity<Void> redirect(@PathVariable String shortUrl) {
        UrlEntity entity = urlService.search(shortUrl);
        System.out.println("entity = " + entity);
        if (entity == null || entity.getOriginalUrl() == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.status(HttpStatus.MOVED_PERMANENTLY) // 302 redirect
                .location(URI.create(entity.getOriginalUrl()))
                .build();
    }





    /**
     * 단축Url -> 원본 Url redirect

    @GetMapping("/{shortUrl}")
    public ResponseEntity<String> move(@PathVariable String shortUrl) {
        UrlEntity url = urlService.search(shortUrl);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(URI.create(url.getLongUrl()));
        return new ResponseEntity<>(headers, HttpStatus.MOVED_PERMANENTLY);
    }*/

    /**
     * 단축Url 생성

    @PostMapping("/shorten")
    public ResponseEntity<String> create(@RequestBody UrlDTO urlDTO) {
        String shortUrl = urlService.save(urlDTO.getOriUrl());
        return ResponseEntity.ok(shortUrl);
    }*/

}
