package org.myberry.site.controller;

import com.redfin.sitemapgenerator.ChangeFreq;
import com.redfin.sitemapgenerator.WebSitemapGenerator;
import com.redfin.sitemapgenerator.WebSitemapUrl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SitemapController {

  private static final Logger log = LoggerFactory.getLogger(SitemapController.class);

  private StringBuffer sitemapBuffer = new StringBuffer();

  @Value("${domain}")
  private String baseUrl;

  @GetMapping(
      value = "/sitemap.xml",
      produces = {"application/xml"})
  public String sitemap() {
    if (sitemapBuffer.length() > 0) {
      return sitemapBuffer.toString();
    }

    WebSitemapGenerator wsg = null;
    try {
      wsg = new WebSitemapGenerator(baseUrl);
      // uri = /
      WebSitemapUrl indexUrl =
          new WebSitemapUrl.Options(baseUrl + "/")
              .lastMod("2022-4-21")
              .priority(1.0)
              .changeFreq(ChangeFreq.MONTHLY)
              .build();
      wsg.addUrl(indexUrl);

      // uri = /quickstart
      WebSitemapUrl quickstartUrl =
          new WebSitemapUrl.Options(baseUrl + "/quickstart")
              .lastMod("2022-3-8")
              .priority(1.0)
              .changeFreq(ChangeFreq.MONTHLY)
              .build();
      wsg.addUrl(quickstartUrl);

      // uri = /docs
      WebSitemapUrl docs =
          new WebSitemapUrl.Options(baseUrl + "/docs")
              .lastMod("2022-3-8")
              .priority(1.0)
              .changeFreq(ChangeFreq.MONTHLY)
              .build();
      wsg.addUrl(docs);

      // uri = /license
      WebSitemapUrl licenseUrl =
          new WebSitemapUrl.Options(baseUrl + "/license")
              .lastMod("2021-12-11")
              .priority(1.0)
              .changeFreq(ChangeFreq.MONTHLY)
              .build();
      wsg.addUrl(licenseUrl);

      // uri = /design
      WebSitemapUrl overviewUrl =
          new WebSitemapUrl.Options(baseUrl + "/design")
              .lastMod("2021-12-11")
              .priority(1.0)
              .changeFreq(ChangeFreq.MONTHLY)
              .build();
      wsg.addUrl(overviewUrl);

      // uri = /dev
      WebSitemapUrl dev =
          new WebSitemapUrl.Options(baseUrl + "/dev")
              .lastMod("2022-3-8")
              .priority(1.0)
              .changeFreq(ChangeFreq.MONTHLY)
              .build();
      wsg.addUrl(dev);

      // uri = /ops
      WebSitemapUrl ops =
          new WebSitemapUrl.Options(baseUrl + "/ops")
              .lastMod("2022-3-8")
              .priority(1.0)
              .changeFreq(ChangeFreq.MONTHLY)
              .build();
      wsg.addUrl(ops);

      // uri = /performance
      WebSitemapUrl codecUrl =
          new WebSitemapUrl.Options(baseUrl + "/performance")
              .lastMod("2021-12-11")
              .priority(1.0)
              .changeFreq(ChangeFreq.MONTHLY)
              .build();
      wsg.addUrl(codecUrl);

      // uri = /faq
      WebSitemapUrl faqUrl =
          new WebSitemapUrl.Options(baseUrl + "/faq")
              .lastMod("2022-4-21")
              .priority(1.0)
              .changeFreq(ChangeFreq.MONTHLY)
              .build();
      wsg.addUrl(faqUrl);

      // uri = /thanks
      WebSitemapUrl thanksUrl =
          new WebSitemapUrl.Options(baseUrl + "/thanks")
              .lastMod("2021-12-11")
              .priority(1.0)
              .changeFreq(ChangeFreq.MONTHLY)
              .build();
      wsg.addUrl(thanksUrl);

    } catch (Exception e) {
      log.error("create sitemap xml error:", e);
    }

    sitemapBuffer.append(String.join("", wsg.writeAsStrings()));
    return sitemapBuffer.toString();
  }
}
