package com.noni.noni;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;

public class SearchAPI {

  
  public static  ArrayList<String> search(String query) {
    ArrayList<String> resultList = new ArrayList<>();
    // 구글 검색 상위 10개 결과를 가져오기
    String requestUrl = "https://www.google.com/search?q=" + query + "&num=10";

    try {
      Document doc = Jsoup.connect(requestUrl).userAgent("Mozilla/5.0").get();
      Elements results = doc.select("h3");

      for (Element result : results) {
        String title = result.text();
        resultList.add(title);
        if (resultList.size() >= 10) {
          break;
        }
      }
    } catch (IOException e) {
      e.printStackTrace();
    }

    return resultList;
  }
}