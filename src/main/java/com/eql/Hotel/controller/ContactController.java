package com.eql.Hotel.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ContactController {

    @RequestMapping(value = {"/contact"}, method = RequestMethod.GET)
    public static String about() {return "contact";}
}

