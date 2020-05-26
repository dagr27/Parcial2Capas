package com.uca.capas.parcial2.controller;

import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.uca.capas.parcial2.service.categoriaService;
import com.uca.capas.parcial2.service.libroService;
import com.uca.capas.parcial2.domain.libro;
import com.uca.capas.parcial2.domain.categoria;

@Controller
public class MainController {
	@Autowired
	private libroService libroS;
	@Autowired
	private categoriaService categoriaS;
	
	private List<libro> libroList = null;
	private List<categoria> categoriaList = null;
	
	/*Cargadores de vista*/
	@RequestMapping("/index")
	public ModelAndView index() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("index");
		return mav;
	}
	@RequestMapping("/category")
	public ModelAndView showCat() {
		ModelAndView mav = new ModelAndView();
		categoria category = new categoria();
		mav.addObject("categoria", category);
		mav.setViewName("category");
		return mav;
	}
	@RequestMapping("/book")
	public ModelAndView showBook() {
		ModelAndView mav = new ModelAndView();
		libro book = new libro();
		try {
			categoriaList = categoriaS.findAll() ;
		} catch(Exception e) {
			e.printStackTrace();
		}
		mav.addObject("categories", categoriaList);
		mav.addObject("libro", book);
		mav.setViewName("book");
		return mav;
	}
	@RequestMapping("/allBooks")
	public ModelAndView showBooks() {
		ModelAndView mav = new ModelAndView();
		try {
			libroList = libroS.findAll();
		} catch(Exception e) {
			e.printStackTrace();
		}
		mav.addObject("libros", libroList);
		mav.setViewName("allBooks");
		return mav;
	}
	
	/*Cargadores de datos a BD*/
	@RequestMapping("/saveCat")
	public ModelAndView saveCategory(@Valid @ModelAttribute categoria cat, BindingResult result) {
		ModelAndView mav = new ModelAndView();
		if(result.hasErrors()) {
			try {
				categoriaList = categoriaS.findAll() ;
			} catch(Exception e) {
				e.printStackTrace();
			}
			mav.addObject("categories",categoriaList);
			mav.setViewName("category");
		}else {
			categoriaS.insert(cat);
			mav.addObject("success","¡Categoria ingresada con exito!");
			mav.setViewName("index");
		}
		return mav;
	}
	
	@RequestMapping("/saveBook")
	public ModelAndView saveBook(@Valid @ModelAttribute libro book, BindingResult result) {
		ModelAndView mav = new ModelAndView();
		if(result.hasErrors()) {
			mav.setViewName("book");
		}else {
			Date dateToday = new Date();
			book.setF_ingreso(dateToday);
			libroS.insert(book);
			mav.addObject("success","¡Libro insertado con exito!");
			mav.setViewName("index");
		}
		return mav;
	}
}





