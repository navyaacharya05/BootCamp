package bootcamp.basic.react.DlitheJavaBootCamp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import bootcamp.basic.react.DlitheJavaBootCamp.entity.Corporate;
import bootcamp.basic.react.DlitheJavaBootCamp.service.CorporateService;

@RestController
@RequestMapping("/rest")
//inform the back end and accept the requests from url of react
@CrossOrigin(origins="http://localhost:3000")
public class APIController 
{
	@Autowired
	CorporateService service;
	
	//'/rest/new
	//infosys has successfully inserted
	@PostMapping("/new")
	public String happy(@RequestBody Corporate corp)
	{
		return service.interact(corp).getOrg()+"has successfully inserted";
	}
	@PutMapping("/up")
	public String evans(@RequestBody Corporate corp)
	{
		return service.interact(corp).getOrg()+"has successfully updated";
	}
	@GetMapping("/")
	public List <Corporate> hogan()
	{
		return service.readEverything();
	}
	
	//localhost:8080//DlitheBootCamp/rest/Microsoft
	@GetMapping("/{comp}")
	public Corporate downey(@PathVariable("comp") String comp)
	{
		return service.readOne(comp);
	}
	
	//localhost:8080//DlithBootCamp/restremove/Infosys
	@DeleteMapping("/remove/{id}")
	public String hemsworth(@PathVariable("id") String id)
	{
		return service.eraseOne(id);
	}
	
}
