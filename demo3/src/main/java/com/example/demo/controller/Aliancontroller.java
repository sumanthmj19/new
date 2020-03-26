package com.example.demo.controller;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.dao.AlianRepo;
import com.example.demo.model.Alian;

import antlr.collections.List;

@RestController
public class Aliancontroller {
	
	@Autowired
	AlianRepo repo;
	
	@RequestMapping("/")
	public String home() {
		return "File.jsp";
	}
	
	@DeleteMapping("/alian/{aid}")
	public String deleteAlian(@PathVariable int aid) {
		Alian a=repo.getOne(aid);
		repo.delete(a);
		return "deleted";
		
	}
	
	@PostMapping("/alian")
	public Alian addalian(@RequestBody Alian alian){
		repo.save(alian);
		return alian;
	}
	
	@PutMapping("/alian")
	public Alian putalian(@RequestBody Alian alian){
		repo.save(alian);
		return alian;
	}
	
//	@RequestMapping("/getalian")
//	public String getalian(HttpServletRequest req){
//		HttpSession session=req.getSession();
//     	int aid=Integer.parseInt(req.getParameter("aid"));
//		ModelAndView mv=new ModelAndView();
//		Alian alian=repo.findById(aid).orElse(new Alian());
//		System.out.println(alian);
//		session.setAttribute("obj", alian);
//		mv.addObject("obj",alian);
//		mv.setViewName("Showalian.jsp");
//		return "Showalian.jsp";
//	}
	

//	@RequestMapping("/getalian")
//	public ModelAndView getalian(int aid){
//		
//		ModelAndView mv=new ModelAndView("Showalian.jsp");
//		Alian alian=repo.findById(aid).orElse(new Alian());
//		mv.addObject("obj",alian);
//	    System.out.println(repo.findByAname("navin"));
//	    System.out.println(repo.findByAidGreaterThan(101));
//	    System.out.println(repo.findByOrder("navin"));
//	    System.out.println(repo.findByOrder1());
//		return mv;
//	}
	
	@GetMapping("/alians/{aid}")
//	@ResponseBody
	public Optional<Alian> getalian(@PathVariable("aid") int aid){
		
//	return repo.findAll().toString();
		return repo.findById(aid);
	}
	

//	@GetMapping(path="/alians", produces= {"application/xml"})
	@GetMapping("/alians")
//	@ResponseBody
	public  java.util.List<Alian> getalian(){
		
	return repo.findAll();
}

}