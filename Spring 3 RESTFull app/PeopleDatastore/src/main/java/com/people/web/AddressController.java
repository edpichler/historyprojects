package com.people.web;

import org.springframework.roo.addon.web.mvc.controller.RooWebScaffold;
import com.people.service.geolocation.Address;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;

@RooWebScaffold(path = "address", automaticallyMaintainView = true, formBackingObject = Address.class)
@RequestMapping("/address/**")
@Controller
public class AddressController {
}
