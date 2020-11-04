package com.sn.senforgeSpring.web;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sn.senforgeSpring.dao.ClientRepository;
import com.sn.senforgeSpring.dao.VillageRepository;
import com.sn.senforgeSpring.entities.Client;
import com.sn.senforgeSpring.entities.Village;

@Controller
public class ClientController {
	
	@Autowired
	ClientRepository clRepo;
	@Autowired
	VillageRepository vRepo;
	
	@RequestMapping(value = "/clients")
	public String allclients(Model model){
	   List<Client> listeClients = clRepo.findAll();
	   model.addAttribute("listeClients", listeClients);
	   return  "client/index";	
	}
	@RequestMapping(value = "/delete")
	public String delete(Long id) {
		clRepo.deleteById(id);
		return "redirect:/clients";
	}
	
	@RequestMapping(value = "/ajoutClient")
	public String ajoutClient(Model model){ 
	   List<Village> villages = vRepo.findAll();
	   model.addAttribute("villages", villages);
	   model.addAttribute("cl", new Client());
	   return  "client/add";	
	}
	
	
	@RequestMapping(value = "/editClient")
	public String editClient(Model model, Long id){
		
	 List<Village> villages = vRepo.findAll();
	   model.addAttribute("villages", villages);
	   model.addAttribute("cl",clRepo.getOne(id)); 
	   return  "client/edit";	
	}
	
	
   @RequestMapping(value="/saveClient" ,method = RequestMethod.POST)
   public String save(Model model , @Valid Client cl, BindingResult bindingResult) { 

	  if(bindingResult.hasErrors()) 
		  return  "client/add";	
	
		 
	   clRepo.save(cl);
	   return "redirect:/clients";
   }
   
   @RequestMapping(value="/")
   public String home() { 
	   return "redirect:/clients";
	
   }
   
   @RequestMapping(value="/403")
   public String accessDenied() { 
	   return "/403";
	
   }
   
}
