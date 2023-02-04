package org.myberry.site;

import java.nio.charset.StandardCharsets;
import java.util.List;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

  @Override
  public void addResourceHandlers(ResourceHandlerRegistry registry) {
    // 将所有/static/** 访问都映射到classpath:/templates/static/ 目录下
    registry.addResourceHandler("/static/**").addResourceLocations("classpath:/templates/static/");
    // 配置favicon.ico映射路径
    registry.addResourceHandler("favicon.ico").addResourceLocations("classpath:/public/");
  }

  @Override
  public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
    // 中文乱码问题
    converters.add(new StringHttpMessageConverter(StandardCharsets.UTF_8));
    // 转换object
    converters.add(new MappingJackson2HttpMessageConverter());
  }

  @Override
  public void addInterceptors(InterceptorRegistry registry) {
    // 这里可以添加多个拦截器
    registry.addInterceptor(new LocaleChangeInterceptor());
  }
}
