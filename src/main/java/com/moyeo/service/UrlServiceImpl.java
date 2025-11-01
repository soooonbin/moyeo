package com.moyeo.service;

import com.moyeo.common.Base62Util;
import com.moyeo.entity.UrlEntity;
import com.moyeo.mapper.UrlMapper;
import com.moyeo.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class UrlServiceImpl implements UrlService {

    private final UrlMapper urlMapper;
    private static final String DOMAIN = "https://moyeo.ly/";
    private static final String PADDING_CHAR = "X";

    // 원본 URL 저장 or 기존 단축 URL 반환
    @Transactional
    public String save(String originalUrl) {
        UrlEntity urlEntity = new UrlEntity();
        urlEntity.setOriginalUrl(originalUrl);

        // 1. 기존 URL 체크
        String existShortUrl = urlMapper.findShortUrlByOriginal(originalUrl);
        if (existShortUrl != null) {
            System.out.println("#####EXIST SHORT URL: " + existShortUrl);
            return DOMAIN + existShortUrl; // 전체 URL 리턴
        }

        // 2. originalUrl insert
        urlMapper.insertOriginalUrl(urlEntity);

        // 3. 생성된 PK 조회
        Random random = new Random();
        int num = random.nextInt() + urlMapper.getLastInsertId();
        System.out.println("#####PK: " + num);

        // 4. 단축 URL 생성
        String shortUrl = generateShortUrl(num);
        System.out.println("#####shoutURL: " + shortUrl);

        // 5. update
        //urlMapper.updateShortUrl(id, shortUrl);
        //String newShortUrl = shortUrl + PADDING_CHAR;
        int result = urlMapper.updateShortUrl(urlMapper.getLastInsertId(), shortUrl);
        if (result != 1) {
            throw new RuntimeException("단축 URL 업데이트 실패: id=" + num);
        }

        System.out.println("#####RESULT: " + DOMAIN + shortUrl);
        return DOMAIN + shortUrl;
    }

    // 단축 URL 조회
    public UrlEntity search(String shortUrl) {
        return urlMapper.findByShortUrl(shortUrl);
    }

    // id 기반 8자리 단축 코드 생성
    private String generateShortUrl(int id) {
        String chars = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        StringBuilder sb = new StringBuilder();

        int num = id;
        while (num > 0) {
            sb.append(chars.charAt(num % 62));
            num /= 62;
        }

        String code = sb.reverse().toString();

        // 8자리 맞추기
        if (code.length() < 8) {
            code = code + PADDING_CHAR.repeat(8 - code.length());
        } else if (code.length() > 8) {
            code = code.substring(0, 8);
        }

        return code;
    }




/*
    private final UrlMapper urlMapper;

    @Override
    public UrlEntity search(String shortUrl) {
        Map<String, String> urlInfo = urlMapper.findByLongUrl(shortUrl);
        UrlEntity urlEntity = new UrlEntity();
        urlEntity.setShortUrl(urlInfo.get("SHORT_URL"));
        urlEntity.setLongUrl(urlInfo.get("ORI_URL"));
        urlEntity.setRegUser(urlInfo.get("REG_USER"));
        return urlEntity;
    }

    @Override
    public String save(String originalUrl) {
        Optional<Map<String,String>> url = Optional.ofNullable(urlMapper.findByLongUrl(originalUrl));
        UrlEntity urlEntity = new UrlEntity();
        urlEntity.setLongUrl(originalUrl);

        if(url.isPresent()) { // 이미 존재하는 경우
            urlEntity.setLongUrl(url.get().get("ORI_URL"));
            return urlEntity.getLongUrl();
        } else {
            // 새로 만들기
            //String shortUrl = this.encode(originalUrl);
            //return shortUrl;

            // 1. 원본 URL 저장 (shortCode는 빈값)
            //ShortUrl entity = new ShortUrl();
            //urlEntity.setOriginalUrl(originalUrl);
            //urlMapper.insertOriginalUrl(urlEntity);  // 여기서 id 자동 채움

            // 2. shortCode 생성
            //String shortCode = ShortUrlGenerator.generate(urlEntity.getId(), originalUrl);

            // 3. DB 업데이트
            //urlEntity.setShortCode(shortCode);
            //urlMapper.updateShortCode(urlEntity);

            return "";
        }
    }

    // oriUrl->shortUrl
    /*
    private String encode(String longUrl) {
        Map<String, String> urlMap = new HashMap<String, String>();
        String base62 = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        String result = "";

        int key = urlMapper.selectUrlSeq();

        byte[] urlBytes = longUrl.getBytes();
        StringBuilder sb = new StringBuilder();
        int sum = rand.hashCode();
        for(int i = 0; i < urlBytes.length; i++) {
            sum += urlBytes[i];
        }

        while(sum > 1) {
            sb.append(base62.charAt(sum % 62));
            sum /= 62;
        }

        if(sb.length() > 8) result = sb.substring(0, 8);
        else if(sb.length() < 8) {
            while(sb.length() < 8) {
                sb.append(base62.charAt(rand.nextInt(62)));
            }
            result = sb.toString();
        }else {
            result = sb.toString();
        }

        urlMap.put(result, url);
        System.out.println(url+" -> "+result);
        return result;

    }*/
}
