package org.ekonopaka.crm.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HttpErrorController {

    @RequestMapping(value="/errors/404")
    public String handle404() {
    	return "404";
    }
    
}
