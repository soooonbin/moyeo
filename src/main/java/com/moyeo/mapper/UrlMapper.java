package com.moyeo.mapper;

import com.moyeo.VO.UrlVO;
import com.moyeo.entity.UrlEntity;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.springframework.data.repository.query.Param;

import java.util.Map;

@Mapper
public interface UrlMapper {

    // 원본 URL → 단축 URL 조회
    String findShortUrlByOriginal(String originalUrl);

    // 단축 URL → 엔티티 조회
    UrlEntity findByShortUrl(String shortUrl);

    // originalUrl insert (short_url은 null로 저장)
    int insertOriginalUrl(UrlEntity urlEntity);

    // insert 직후 생성된 id 조회
    int getLastInsertId();

    // shortUrl update
    int updateShortUrl(@Param("id") int id, @Param("shortUrl") String shortUrl);




    //Map<String,String> findByLongUrl(String longUrl);
    //UrlVO save(UrlVO urlVO);
    //int selectUrlSeq();
    //@Insert("INSERT INTO URL_MAST (original_url, short_code) VALUES (#{originalUrl}, '')")
    //@Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    //int insertOriginalUrl(String shortUrl);
}
