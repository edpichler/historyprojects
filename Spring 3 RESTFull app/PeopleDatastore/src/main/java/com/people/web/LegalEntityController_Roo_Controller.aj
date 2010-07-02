package com.people.web;

import com.people.LegalEntity;
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

privileged aspect LegalEntityController_Roo_Controller {
    
    @RequestMapping(value = "/legalentity", method = RequestMethod.POST)
    public String LegalEntityController.create(@Valid LegalEntity legalEntity, BindingResult result, ModelMap modelMap) {
        if (legalEntity == null) throw new IllegalArgumentException("A legalEntity is required");
        if (result.hasErrors()) {
            modelMap.addAttribute("legalEntity", legalEntity);
            modelMap.addAttribute("addresses", Address.findAllAddresses());
            return "legalentity/create";
        }
        legalEntity.persist();
        return "redirect:/legalentity/" + legalEntity.getId();
    }
    
    @RequestMapping(value = "/legalentity/form", method = RequestMethod.GET)
    public String LegalEntityController.createForm(ModelMap modelMap) {
        modelMap.addAttribute("legalEntity", new LegalEntity());
        modelMap.addAttribute("addresses", Address.findAllAddresses());
        return "legalentity/create";
    }
    
    @RequestMapping(value = "/legalentity/{id}", method = RequestMethod.GET)
    public String LegalEntityController.show(@PathVariable("id") Long id, ModelMap modelMap) {
        if (id == null) throw new IllegalArgumentException("An Identifier is required");
        modelMap.addAttribute("legalEntity", LegalEntity.findLegalEntity(id));
        return "legalentity/show";
    }
    
    @RequestMapping(value = "/legalentity", method = RequestMethod.GET)
    public String LegalEntityController.list(@RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size, ModelMap modelMap) {
        if (page != null || size != null) {
            int sizeNo = size == null ? 10 : size.intValue();
            modelMap.addAttribute("legalentitys", LegalEntity.findLegalEntityEntries(page == null ? 0 : (page.intValue() - 1) * sizeNo, sizeNo));
            float nrOfPages = (float) LegalEntity.countLegalEntitys() / sizeNo;
            modelMap.addAttribute("maxPages", (int) ((nrOfPages > (int) nrOfPages || nrOfPages == 0.0) ? nrOfPages + 1 : nrOfPages));
        } else {
            modelMap.addAttribute("legalentitys", LegalEntity.findAllLegalEntitys());
        }
        return "legalentity/list";
    }
    
    @RequestMapping(method = RequestMethod.PUT)
    public String LegalEntityController.update(@Valid LegalEntity legalEntity, BindingResult result, ModelMap modelMap) {
        if (legalEntity == null) throw new IllegalArgumentException("A legalEntity is required");
        if (result.hasErrors()) {
            modelMap.addAttribute("legalEntity", legalEntity);
            modelMap.addAttribute("addresses", Address.findAllAddresses());
            return "legalentity/update";
        }
        legalEntity.merge();
        return "redirect:/legalentity/" + legalEntity.getId();
    }
    
    @RequestMapping(value = "/legalentity/{id}/form", method = RequestMethod.GET)
    public String LegalEntityController.updateForm(@PathVariable("id") Long id, ModelMap modelMap) {
        if (id == null) throw new IllegalArgumentException("An Identifier is required");
        modelMap.addAttribute("legalEntity", LegalEntity.findLegalEntity(id));
        modelMap.addAttribute("addresses", Address.findAllAddresses());
        return "legalentity/update";
    }
    
    @RequestMapping(value = "/legalentity/{id}", method = RequestMethod.DELETE)
    public String LegalEntityController.delete(@PathVariable("id") Long id, @RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size) {
        if (id == null) throw new IllegalArgumentException("An Identifier is required");
        LegalEntity.findLegalEntity(id).remove();
        return "redirect:/legalentity?page=" + ((page == null) ? "1" : page.toString()) + "&size=" + ((size == null) ? "10" : size.toString());
    }
    
}
