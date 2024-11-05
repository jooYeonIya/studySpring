package org.example.filter_test;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class SpringConfig implements WebMvcConfigurer {
  @Override
  public void addInterceptors(InterceptorRegistry registry) {
    registry.addInterceptor(new LogInterceptor())
        .addPathPatterns("/**") // /** 는 모든 경로와 하위 경로까지 포함 /member/login 도 가능하다는 의미
        .order(1);
    registry.addInterceptor(new LoginIntercepotr())
        .addPathPatterns("/**")
        .excludePathPatterns("/members/register", "/members/login") // 이 주소는 제외시켜줘
        .order(2);
  }
  //  @Bean
//  public FilterRegistrationBean logFilterRegistrationBean() {
//    FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
//    filterRegistrationBean.setFilter(new LogFilter()); // setter 주입 방식
//    filterRegistrationBean.addUrlPatterns("/*"); // 모든 URL에 적용
//    filterRegistrationBean.setOrder(1); // 몇 번째에 실행할 필터냐
//    return filterRegistrationBean;
////    return new FilterRegistrationBean(new LogFilter()); 생성자 주입 방식
//  }
//
//  @Bean
//  public FilterRegistrationBean loginFilterRegistrationBean() {
//    FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean(new LoginFilter());
//    filterRegistrationBean.addUrlPatterns("/*");
//    filterRegistrationBean.setOrder(2);
//    return filterRegistrationBean;
//  }
}
