package com.people.web;

import org.springframework.roo.addon.web.mvc.controller.RooWebScaffold;
import com.people.LegalEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;

@RooWebScaffold(path = "legalentity", automaticallyMaintainView = true, formBackingObject = LegalEntity.class)
@RequestMapping("/legalentity/**")
@Controller
public class LegalEntityController {
}
