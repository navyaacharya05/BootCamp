package bootcamp.basic.react.DlitheJavaBootCamp.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
//util,io,sql,swing,lang
//17jdk>>5000+inbuilt classes:String,List,Integer,Double
import javax.persistence.Id;

//Org locations,services,benchmarks,employees,basic

@Entity
public class Corporate
{
	@Id
	private String org;
	
	@ElementCollection
	private List<String> locations=new ArrayList<String>();
	@ElementCollection
	private List<String> services=new ArrayList<String>();
	@ElementCollection
	private List<String> benchmarks=new ArrayList<String>();
	
	private Integer employees;
	private Double basic;
	
	//right click>>source>>generate getter and setter
	public String getOrg() {
		return org;
	}
	public void setOrg(String org) {
		this.org = org;
	}
	public List<String> getLocations() {
		return locations;
	}
	public void setLocations(List<String> locations) {
		this.locations = locations;
	}
	public List<String> getServices() {
		return services;
	}
	public void setServices(List<String> services) {
		this.services = services;
	}
	public List<String> getBenchmarks() {
		return benchmarks;
	}
	public void setBenchmarks(List<String> benchmarks) {
		this.benchmarks = benchmarks;
	}
	public Integer getEmployees() {
		return employees;
	}
	public void setEmployees(Integer employees) {
		this.employees = employees;
	}
	public Double getBasic() {
		return basic;
	}
	public void setBasic(Double basic) {
		this.basic = basic;
	}
	
	
	
}