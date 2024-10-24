package com.example.student.ch07;

import jakarta.servlet.ServletContextAttributeEvent;
import jakarta.servlet.ServletContextAttributeListener;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.http.HttpSessionAttributeListener;
import jakarta.servlet.http.HttpSessionBindingEvent;
import jakarta.servlet.http.HttpSessionEvent;
import jakarta.servlet.http.HttpSessionListener;
import lombok.extern.slf4j.Slf4j;

@WebListener
@Slf4j
public class ListenerExam implements
    ServletContextListener,
    ServletContextAttributeListener,
    HttpSessionListener,
    HttpSessionAttributeListener {

  // context 관련
  @Override
  public void attributeAdded(ServletContextAttributeEvent scae) {
    ServletContextAttributeListener.super.attributeAdded(scae);
    log.info("attributedAdded ++++++ {}", scae);
  }

  @Override
  public void contextInitialized(ServletContextEvent sce) {
    ServletContextListener.super.contextInitialized(sce);
    log.info("contextInitialized ++++++ {}", sce);
  }

  @Override
  public void contextDestroyed(ServletContextEvent sce) {
    ServletContextListener.super.contextDestroyed(sce);
    log.info("contextDestroyed ++++++ {}", sce);
  }

  // session 관련
  @Override
  public void sessionCreated(HttpSessionEvent se) {
    HttpSessionListener.super.sessionCreated(se);
    log.info("sessionCreated ++++++ {}", se);
  }

  @Override
  public void attributeAdded(HttpSessionBindingEvent se) {
    HttpSessionAttributeListener.super.attributeAdded(se);
    log.info("HttpSessionAttributeListener ++++++ {}", se);
  }
}
