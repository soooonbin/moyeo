package com.moyeo.service;

import com.moyeo.entity.UrlEntity;

public interface UrlService {
    UrlEntity search(String shortUrl);
    String save(String longUrl);
}
