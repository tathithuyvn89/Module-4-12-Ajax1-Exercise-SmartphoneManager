package com.codegym.controller;

import com.codegym.model.SmartPhone;
import com.codegym.service.SmartPhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping(value = "/smartphones")
public class PhoneController {
    @Autowired
    private SmartPhoneService smartPhoneService;
   @GetMapping("/createnewphone")
    public String showCreatePhoneForm(Model model){
       model.addAttribute("newPhone", new SmartPhone());
       return "phone/create";
   }
   @PostMapping(value = "/createnewphone",produces = MediaType.APPLICATION_JSON_VALUE,consumes =MediaType.APPLICATION_JSON_VALUE )
   @ResponseBody
    public SmartPhone saveNewPhone(@RequestBody SmartPhone newphone){
       return smartPhoneService.save(newphone);
   }
   @GetMapping(value = "",produces = MediaType.APPLICATION_JSON_VALUE,consumes =MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Iterable<SmartPhone> allPhones(){
       return smartPhoneService.findAll();
   }
   @GetMapping("")
    public String showAllPhone(Model model){
       model.addAttribute("allphones",allPhones());
       return "phone/list";
   }
   @PostMapping(value = "/delete/{id}",produces = MediaType.APPLICATION_JSON_VALUE,consumes =MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public SmartPhone deleteSmartphone(@PathVariable Integer id) {
       return smartPhoneService.remove(id);
   }
   @GetMapping(value = "/edit/{id}")
    public String editPhonePage(@PathVariable Integer id, Model model){
       SmartPhone smartPhone = smartPhoneService.findPhoneById(id);
       model.addAttribute("smartphone",smartPhone);
       return "phone/edit";
   }
    @PostMapping(value = "/edit/{id}",produces = MediaType.APPLICATION_JSON_VALUE,consumes =MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public SmartPhone editSmartphone(@PathVariable Integer id, @RequestBody SmartPhone smartPhone){
       smartPhone.setId(id);
       smartPhoneService.save(smartPhone);
       return smartPhone;
    }


}

