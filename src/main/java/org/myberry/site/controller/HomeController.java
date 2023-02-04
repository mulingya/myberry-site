package org.myberry.site.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class HomeController {

  @GetMapping("/")
  public ModelAndView index() {
    ModelAndView mv = new ModelAndView();
    mv.setViewName("index");
    return mv;
  }

  @GetMapping("/quickstart")
  public ModelAndView quickStart() {
    ModelAndView mv = new ModelAndView();
    mv.setViewName("quickstart");
    return mv;
  }

  @GetMapping("/docs")
  public ModelAndView documentation() {
    ModelAndView mv = new ModelAndView();
    mv.setViewName("documentation");
    return mv;
  }

  @GetMapping("/license")
  public ModelAndView license() {
    ModelAndView mv = new ModelAndView();
    mv.setViewName("license");
    return mv;
  }

  @GetMapping("/design")
  public ModelAndView design() {
    ModelAndView mv = new ModelAndView();
    mv.setViewName("design");
    return mv;
  }

  @GetMapping("/dev")
  public ModelAndView dev() {
    ModelAndView mv = new ModelAndView();
    mv.setViewName("dev");
    return mv;
  }

  @GetMapping("/ops")
  public ModelAndView ops() {
    ModelAndView mv = new ModelAndView();
    mv.setViewName("ops");
    return mv;
  }

  @GetMapping("/performance")
  public ModelAndView performance() {
    ModelAndView mv = new ModelAndView();
    mv.setViewName("performance");
    return mv;
  }

  @GetMapping("/faq")
  public ModelAndView faq() {
    ModelAndView mv = new ModelAndView();
    mv.setViewName("faq");
    return mv;
  }

  @GetMapping("/thanks")
  public ModelAndView thanks() {
    ModelAndView mv = new ModelAndView();
    mv.setViewName("thanks");
    return mv;
  }
}
