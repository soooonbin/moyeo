package com.moyeo.VO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UrlVO {
    private Long id;
    private String shortUrl;
    private String originalUrl;
    private String regUser;
}
