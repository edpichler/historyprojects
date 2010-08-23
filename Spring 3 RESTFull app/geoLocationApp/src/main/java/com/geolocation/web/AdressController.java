package com.geolocation.web;

import org.springframework.roo.addon.web.mvc.controller.RooWebScaffold;
import com.geolocation.Address;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;

@RooWebScaffold(path = "address", exposeFinders=true,  automaticallyMaintainView = true, formBackingObject = Address.class)
@RequestMapping("/address/**")
@Controller
public class AdressController {
}
