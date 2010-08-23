package com.people.web;

import org.springframework.roo.addon.web.mvc.controller.RooWebScaffold;
import com.people.Individual;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;

@RooWebScaffold(path = "individual", automaticallyMaintainView = true, formBackingObject = Individual.class)
@RequestMapping("/individual/**")
@Controller
public class IndividualController {
}
