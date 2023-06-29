package com.chintan.FirstSpringRestApi.controller;

import java.util.List;
import java.util.Optional;

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

import com.chintan.FirstSpringRestApi.dao.AlienRepo;
import com.chintan.FirstSpringRestApi.model.Alien;

@RestController
public class AlienController {
	
	@Autowired
	AlienRepo alienrepo;
	
	@GetMapping("/")
	public String home() {
		return "home";
	}
	
	@GetMapping("/addAlien")
	public String addAlien(Alien alien) {
		alienrepo.save(alien);
		return "home";
	}
	
	@GetMapping("/getAlien")
	public ModelAndView getAlien(@RequestParam("aid") String id) {
		ModelAndView mv = new ModelAndView();
		
		Alien a = alienrepo.findById(Integer.parseInt(id)).orElse(new Alien());
		System.out.println(a.toString());
		mv.addObject("aliendata",a);
		mv.setViewName("home");
		return mv;
	}
	
	@GetMapping("/getAlienByName")
	public ModelAndView getAlienByName(@RequestParam("aname") String name) {
		ModelAndView mv = new ModelAndView();
		
		
		System.out.println(alienrepo.findByAname(name));
		System.out.println(alienrepo.findByAidGreaterThan(102));
		System.out.println(alienrepo.anyMethodName(102));
		mv.setViewName("home");
		return mv;
	}
	
	@GetMapping("/aliens")
	public List<Alien> getAliens() {
		return alienrepo.findAll();
	}
	
	@GetMapping(path="/alien/{aid}",produces= {"application/json"})
	public Optional<Alien> getAlienById(@PathVariable("aid") int aid) {
		return alienrepo.findById(aid);
	}
	
	@PostMapping(path="/alien",consumes= {"application/json"})
	public Alien addPostAlien(@RequestBody Alien alien) {
		alienrepo.save(alien);
		return alien;
	}
	
	@DeleteMapping(path="/alien/{aid}")
	public String deleteAlienById(@PathVariable("aid") int aid) {
		Alien a = alienrepo.getOne(aid);
		alienrepo.deleteById(aid);
		return "deleted";
	}
	
	@PutMapping(path="/alien",consumes= {"application/json"})
	public Alien updateAlien(@RequestBody Alien alien) {
		alienrepo.save(alien);
		return alien;
	}
}
