package com.moyeo.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class UrlEntity {
    private int id;
    private String originalUrl;
    private String shortUrl;
    private String regUser;
}
