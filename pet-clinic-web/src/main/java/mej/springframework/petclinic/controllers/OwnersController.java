package mej.springframework.petclinic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/owners")
public class OwnersController {
    @RequestMapping({"","/", "/index","/index.html"})
    private String listOwners(){
        return "owners/index";
    }
}
