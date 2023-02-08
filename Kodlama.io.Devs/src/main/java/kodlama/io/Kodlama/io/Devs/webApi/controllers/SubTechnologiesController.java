package kodlama.io.Kodlama.io.Devs.webApi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.Kodlama.io.Devs.business.abstracts.SubTechnologyService;
import kodlama.io.Kodlama.io.Devs.business.requests.subtechnology.CreateSubTechnologyRequest;
import kodlama.io.Kodlama.io.Devs.business.requests.subtechnology.DeleteSubTechnologyRequest;
import kodlama.io.Kodlama.io.Devs.business.requests.subtechnology.UpdateSubTechnologyRequest;
import kodlama.io.Kodlama.io.Devs.business.responses.subtechnology.GetAllSubTechnologiesResponse;
import kodlama.io.Kodlama.io.Devs.business.responses.subtechnology.GetSubTechnologyByIdResponse;

@RestController
@RequestMapping("/api/subtechnologies/")
public class SubTechnologiesController {

	SubTechnologyService subTechnologyService;
    @Autowired
	public SubTechnologiesController(SubTechnologyService subTechnologyService) {
		this.subTechnologyService = subTechnologyService;
	}
	
	@GetMapping("/getall")
	public List<GetAllSubTechnologiesResponse>getAll(){
		return subTechnologyService.getAll();
	}
	@GetMapping("/getById")
	public GetSubTechnologyByIdResponse getById(int id){
		return subTechnologyService.getSubTechnologyByIdResponse(id);
	}
	@GetMapping("/delete")
	public void delete(DeleteSubTechnologyRequest deleteSubTechnologyRequest) throws Exception{
		 subTechnologyService.delete(deleteSubTechnologyRequest);
	}
	@PostMapping("/add")
	public void add(@RequestBody CreateSubTechnologyRequest createSubTechnologyRequest) throws Exception {
		subTechnologyService.add(createSubTechnologyRequest);
	}
	@PostMapping("/update")
	public void add(@RequestBody UpdateSubTechnologyRequest updateSubTechnologyRequest) throws Exception {
		subTechnologyService.update(updateSubTechnologyRequest);
	}
	
	
}
