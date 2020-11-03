package com.sn.senforgeSpring.web;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sn.senforgeSpring.dao.VillageRepository;
import com.sn.senforgeSpring.entities.Village;

@Controller
public class VillageController {

	@Autowired
	VillageRepository vRepo;
	
	@RequestMapping(value = "/villages")
	public String allclients(Model model){
	   List<Village> listeVillages = vRepo.findAll();
	   model.addAttribute("listeVillages", listeVillages);
	   return  "village/index";	
	}
	@RequestMapping(value = "/deleteV")
	public String delete(Long id) {
		vRepo.deleteById(id);
		return "redirect:/villages";
	}
	
	@RequestMapping(value = "/ajoutVillage")
	public String ajoutClient(Model model){ 
	   model.addAttribute("vil", new Village());
	   return  "village/add";	
	}
	
	
   @RequestMapping(value="/saveVillage" ,method = RequestMethod.POST)
   public String save(Model model , @Valid Village vil, BindingResult bindingResult) { 

	  if(bindingResult.hasErrors()) 
		  return "redirect:/ajoutClient"; 
		 
	   vRepo.save(vil);
	   return "redirect:/villages";
   }
   
}
