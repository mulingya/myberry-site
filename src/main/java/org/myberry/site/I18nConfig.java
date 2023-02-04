package org.myberry.site;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

@Configuration
public class I18nConfig {

  /** 国际化文件路径 */
  @Value("${spring.messages.basename}")
  public String basename;
  /** 找不到指定语言，调用默认messages.properties */
  @Value("${spring.messages.fallbackToSystemLocale}")
  public boolean fallbackToSystemLocale;

  /**
   * 用于解析消息的策略接口，支持这些消息的参数化和国际化。
   *
   * @return
   */
  @Bean
  public MessageSource messageSource() {
    ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
    messageSource.setBasename(basename);
    messageSource.setFallbackToSystemLocale(fallbackToSystemLocale);
    return messageSource;
  }

  @Bean(name = "localeResolver")
  public LocaleResolver localeResolverBean() {
    return new SessionLocaleResolver();
  }
}
