package com.people.web;

import com.people.service.geolocation.Address;
import java.lang.Long;
import java.lang.String;
import javax.validation.Valid;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

privileged aspect AddressController_Roo_Controller {
    
    @RequestMapping(value = "/address", method = RequestMethod.POST)
    public String AddressController.create(@Valid Address address, BindingResult result, ModelMap modelMap) {
        if (address == null) throw new IllegalArgumentException("A address is required");
        if (result.hasErrors()) {
            modelMap.addAttribute("address", address);
            return "address/create";
        }
        address.persist();
        return "redirect:/address/" + address.getId();
    }
    
    @RequestMapping(value = "/address/form", method = RequestMethod.GET)
    public String AddressController.createForm(ModelMap modelMap) {
        modelMap.addAttribute("address", new Address());
        return "address/create";
    }
    
    @RequestMapping(value = "/address/{id}", method = RequestMethod.GET)
    public String AddressController.show(@PathVariable("id") Long id, ModelMap modelMap) {
        if (id == null) throw new IllegalArgumentException("An Identifier is required");
        modelMap.addAttribute("address", Address.findAddress(id));
        return "address/show";
    }
    
    @RequestMapping(value = "/address", method = RequestMethod.GET)
    public String AddressController.list(@RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size, ModelMap modelMap) {
        if (page != null || size != null) {
            int sizeNo = size == null ? 10 : size.intValue();
            modelMap.addAttribute("addresses", Address.findAddressEntries(page == null ? 0 : (page.intValue() - 1) * sizeNo, sizeNo));
            float nrOfPages = (float) Address.countAddresses() / sizeNo;
            modelMap.addAttribute("maxPages", (int) ((nrOfPages > (int) nrOfPages || nrOfPages == 0.0) ? nrOfPages + 1 : nrOfPages));
        } else {
            modelMap.addAttribute("addresses", Address.findAllAddresses());
        }
        return "address/list";
    }
    
    @RequestMapping(method = RequestMethod.PUT)
    public String AddressController.update(@Valid Address address, BindingResult result, ModelMap modelMap) {
        if (address == null) throw new IllegalArgumentException("A address is required");
        if (result.hasErrors()) {
            modelMap.addAttribute("address", address);
            return "address/update";
        }
        address.merge();
        return "redirect:/address/" + address.getId();
    }
    
    @RequestMapping(value = "/address/{id}/form", method = RequestMethod.GET)
    public String AddressController.updateForm(@PathVariable("id") Long id, ModelMap modelMap) {
        if (id == null) throw new IllegalArgumentException("An Identifier is required");
        modelMap.addAttribute("address", Address.findAddress(id));
        return "address/update";
    }
    
    @RequestMapping(value = "/address/{id}", method = RequestMethod.DELETE)
    public String AddressController.delete(@PathVariable("id") Long id, @RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size) {
        if (id == null) throw new IllegalArgumentException("An Identifier is required");
        Address.findAddress(id).remove();
        return "redirect:/address?page=" + ((page == null) ? "1" : page.toString()) + "&size=" + ((size == null) ? "10" : size.toString());
    }
    
}
