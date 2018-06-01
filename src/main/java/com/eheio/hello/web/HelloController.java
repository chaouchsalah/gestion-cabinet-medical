package com.eheio.hello.web;

import com.eheio.hello.service.IMesureConsultationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloController {
    @Autowired
    IMesureConsultationService mesureConsultationService;
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public final String hello(@RequestParam(value="name", required=false, defaultValue="World") String name, Model model) {
        //mesureConsultationService.findAll();
        model.addAttribute("name", name);
        return "hello";
    }
}
