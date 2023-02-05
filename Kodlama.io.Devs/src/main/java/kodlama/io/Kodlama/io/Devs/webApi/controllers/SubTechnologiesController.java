package kodlama.io.Kodlama.io.Devs.webApi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.Kodlama.io.Devs.business.abstracts.SubTechnologyService;
import kodlama.io.Kodlama.io.Devs.entities.SubTechnology;

@RestController
@RequestMapping("/api/subtechnologies/")
public class SubTechnologiesController {

	SubTechnologyService subTechnologyService;
    @Autowired
	public SubTechnologiesController(SubTechnologyService subTechnologyService) {
		this.subTechnologyService = subTechnologyService;
	}
	
	@GetMapping("/getall")
	public List<SubTechnology>getAll(){
		return subTechnologyService.getAll();
	}
	@PostMapping("/add")
	public void add(@RequestBody SubTechnology subTechnology) {
		subTechnologyService.add(subTechnology);
	}
	
}
