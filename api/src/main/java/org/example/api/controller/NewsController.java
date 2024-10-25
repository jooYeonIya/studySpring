package org.example.api.controller;

import lombok.extern.slf4j.Slf4j;
import org.example.api.domain.News;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/news")
public class NewsController {

  @GetMapping
  public List<News> getNews() {
    List<News> newsList = new ArrayList<>();
    News news = new News();
    news.setAid(1);
    news.setTitle("test");
    news.setContent("test contetn");
    news.setImg("img webbbb");
    news.setDate("2020-20-00");
    newsList.add(news);
    return newsList;
  }

  @PostMapping
  public String addNews(@RequestBody News news) {
    log.info(news.toString());
    return "success";
  }
}
