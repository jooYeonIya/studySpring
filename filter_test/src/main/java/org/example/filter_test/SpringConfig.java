package org.example.filter_test;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {
  @Bean
  public FilterRegistrationBean logFilterRegistrationBean() {
    FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
    filterRegistrationBean.setFilter(new LogFilter()); // setter 주입 방식
    filterRegistrationBean.addUrlPatterns("/*"); // 모든 URL에 적용
    filterRegistrationBean.setOrder(1); // 몇 번째에 실행할 필터냐
    return filterRegistrationBean;
//    return new FilterRegistrationBean(new LogFilter()); 생성자 주입 방식
  }
}
