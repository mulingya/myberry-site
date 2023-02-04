package org.myberry.site.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RobotsController {

  private StringBuffer robotsBuffer = new StringBuffer();

  @Value("${domain}")
  private String baseUrl;

  @GetMapping(
      value = "/robots.txt",
      produces = {"text/plain"})
  public String robots() {
    if (robotsBuffer.length() > 0) {
      return robotsBuffer.toString();
    }

    robotsBuffer.append("User-agent: ").append("Baiduspider").append(System.lineSeparator());
    robotsBuffer.append("Allow: ").append("/").append(System.lineSeparator());
    robotsBuffer.append(System.lineSeparator());
    robotsBuffer.append("User-agent: ").append("Googlebot").append(System.lineSeparator());
    robotsBuffer.append("Allow: ").append("/").append(System.lineSeparator());
    robotsBuffer.append(System.lineSeparator());
    robotsBuffer.append("User-agent: ").append("Bytespider").append(System.lineSeparator());
    robotsBuffer.append("Allow: ").append("/").append(System.lineSeparator());
    robotsBuffer.append(System.lineSeparator());
    robotsBuffer.append("User-agent: ").append("MSNBot").append(System.lineSeparator());
    robotsBuffer.append("Allow: ").append("/").append(System.lineSeparator());
    robotsBuffer.append(System.lineSeparator());
    robotsBuffer.append("User-agent: ").append("YoudaoBot").append(System.lineSeparator());
    robotsBuffer.append("Allow: ").append("/").append(System.lineSeparator());
    robotsBuffer.append(System.lineSeparator());
    robotsBuffer.append("User-agent: ").append("360spider").append(System.lineSeparator());
    robotsBuffer.append("Allow: ").append("/").append(System.lineSeparator());
    robotsBuffer.append(System.lineSeparator());
    robotsBuffer.append("User-agent: ").append("Sogou web spider").append(System.lineSeparator());
    robotsBuffer.append("Allow: ").append("/").append(System.lineSeparator());
    robotsBuffer.append(System.lineSeparator());
    robotsBuffer.append("User-agent: ").append("Twitterbot").append(System.lineSeparator());
    robotsBuffer.append("Allow: ").append("/").append(System.lineSeparator());
    robotsBuffer.append(System.lineSeparator());
    robotsBuffer.append("User-agent: ").append("bingbot").append(System.lineSeparator());
    robotsBuffer.append("Allow: ").append("/").append(System.lineSeparator());
    robotsBuffer.append(System.lineSeparator());
    robotsBuffer.append("User-agent: ").append("*").append(System.lineSeparator());
    robotsBuffer.append("Disallow: ").append("/").append(System.lineSeparator());
    robotsBuffer.append(System.lineSeparator());
    robotsBuffer.append("Sitemap: ").append(baseUrl).append("/sitemap.xml");
    return robotsBuffer.toString();
  }
}
