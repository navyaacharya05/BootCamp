package bootcamp.basic.react.DlitheJavaBootCamp.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bootcamp.basic.react.DlitheJavaBootCamp.entity.Corporate;
import bootcamp.basic.react.DlitheJavaBootCamp.repository.CorporateRepository;


/*
 * save(object) //new/update>>if primary key/id object already there it will update else add the new entity
 *findAll() ??list<entity>
 *findbyId(id)json/xml/getById>>xml>>dataformat.xml //emtity/ corporate
 *deleteById(id)/delete(object) >>void
 */

@Service
public class CorporateService 
{
	@Autowired //get the instance and memory of the component
	CorporateRepository repo;
	
	public Corporate interact(Corporate object)
	{
		return repo.save(object); //pass the entity object that can be converted as record in the table
	}
	
	public List<Corporate> readEverything()
	{
		return repo.findAll();
	}
	
	public Corporate readOne(String id)
	{
		return repo.findById(id).orElse(new Corporate());
	}
	
	//started delete module
	public String eraseOne(String id)
	{
		String name=readOne(id).getOrg()+" "+readOne(id).getBasic()+" has deleted\n";
		repo.deleteById(id);
		return name;
	}
}