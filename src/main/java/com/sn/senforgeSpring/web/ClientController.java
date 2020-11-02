package com.sn.senforgeSpring.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

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
	
	
   @RequestMapping(value="/saveClient")
   public String save(Model model ,Client cl) { 
	 
	   clRepo.save(cl);
	   return "redirect:/clients";
   }
   
}
