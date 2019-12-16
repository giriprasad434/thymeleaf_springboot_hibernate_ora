package com.giri.studyapplication.controllercfg;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.giri.studyapplication.repositoryCfg.materialDAO.BannerService;
import com.giri.studyapplication.repositoryCfg.materialDAO.MaterialsService;

@RestController
public class RestController12 implements ErrorController {

	private MaterialsService materialsSer;
	private BannerService bannerservice;

	@Autowired
	public RestController12(MaterialsService materialsSer, BannerService bannerService) {
		this.materialsSer = materialsSer;
		this.bannerservice = bannerService;
	}
	@GetMapping(path = "/index")
	public ModelAndView getName() {
		return new ModelAndView("/index.html");
	}
	
	@GetMapping(path = "/material", produces = MediaType.APPLICATION_JSON_VALUE)
	public Collection<?> getname() {
		return this.materialsSer.getMaterial();
	}

	@GetMapping(path = "/bannerdetai", produces = MediaType.APPLICATION_JSON_VALUE)
	public Collection<?> getBannerNames() {
		return this.bannerservice.getBannerNames();

	}

	@GetMapping(path = "/Photos")
	@PreAuthorize("hasRole('GIRI')")
	public ModelAndView getPhotos() {

		ModelAndView mav = new ModelAndView("photogellery.html");
		Map<String, String> m1 = new HashMap<String, String>();
		m1.put("first", "images/image.jpg");
		m1.put("Second", "images/0.2_image.jpg");
		m1.put("third", "images/0.3_image.jpg");
		Map<String, String> m2 = new HashMap<String, String>();
		m2.put("first", "images/0.4_image.jpg");
		m2.put("Second", "images/0.5_image.jpg");
		m2.put("third", "images/0.6_image.jpg");
		Map<String, String> m3 = new HashMap<String, String>();
		m3.put("first", "images/0.7_image.jpg");
		m3.put("Second", "none");
		m3.put("third", "none");
		List<Map<String, String>> m = new ArrayList<Map<String, String>>();
		m.add(m1);
		m.add(m2);
		m.add(m3);
		mav.addObject("names", m);
		return mav;
	}

	// Login form
	@GetMapping(path = "/login")
	public ModelAndView login(Model m) {
		return new ModelAndView("/login.html").addObject(m);
	}

	// Login form
	@GetMapping(path = "/logout")
	public ModelAndView logout(Model m) {
		return new ModelAndView("/login.html").addObject(m);
	}

	// Login form with error
	@RequestMapping("/login-error")
	public ModelAndView loginError(Model model) {
		model.addAttribute("loginError", true);
		return new ModelAndView("/login.html").addObject(model);
	}

	@RequestMapping("/error")
	@ResponseBody
	public String handleError(HttpServletRequest request) {
		Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
		Exception exception = (Exception) request.getAttribute("javax.servlet.error.exception");
		return String.format(
				"<html><body><h2>giri error page</h2><div>Status code: <b>%s</b></div>"
						+ "<div>Exception Message: <b>%s</b></div><body></html>",
				statusCode, exception == null ? "N/A" : exception.getMessage());
	}

	@Override
	public String getErrorPath() {
		return "/error";
	}
}
