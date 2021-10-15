package com.globallabs.springwebmvc.controller;

import com.globallabs.springwebmvc.model.Jedi;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class JadiController {

    @GetMapping("/jedi")
    public ModelAndView Jedi()
    {
        final ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("jedi");
        final Jedi felipe = new Jedi("Felipe", "D. Santos");
        modelAndView.addObject("allJedi", List.of(felipe));
        return modelAndView;
    }

}
