package com.backend.schoolManagementSystem.controller;

import java.net.http.HttpRequest;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import com.backend.schoolManagementSystem.dao.LoginRepo;
import com.backend.schoolManagementSystem.dao.StudentRepository;
import com.backend.schoolManagementSystem.dao.TeacherRepository;
import com.backend.schoolManagementSystem.model.Login;
import com.backend.schoolManagementSystem.model.Student;
import com.backend.schoolManagementSystem.model.Teacher;
import com.backend.schoolManagementSystem.service.LoginService;
import com.backend.schoolManagementSystem.service.StudentService;
import com.backend.schoolManagementSystem.service.TeacherService;
import com.backend.schoolManagementSystem.util.Constants;
import com.backend.schoolManagementSystem.util.MailSender;

@RestController
public class LoginController {
	@Autowired
	LoginService loginService;
	@Autowired
	StudentService studentService;
	@Autowired
	TeacherService teacherService; 
	
	@GetMapping("/")
	public ModelAndView Index() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("index");
		return mv;
	}
	@GetMapping("/forgot.html")
	public ModelAndView forgot() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("forgot");
		return mv;
	}
	@PostMapping("/login")
	public ModelAndView login(Login user,HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		try {
				
				System.out.println(user.getEmail()+" - "+user.getPassword());
				if(user.getEmail().equals("admin@admin.com")&&(user.getPassword().equals("admin")))
				{
					mv.setViewName("admin");
					return mv;
				}
				long id=this.loginService.findPassword(user.getEmail(), user.getPassword());
				int role=this.loginService.findRole(id);
				int otl=this.loginService.findOtl(id);
				if(role==1)
				{  
					String name=this.studentService.findName(id);
					HttpSession session=request.getSession();
					if(otl==1)
					{
						session.setAttribute("id",id);
						mv.setViewName("NewPassword");
						return mv;
					}
					else
					{
						session.setAttribute("name",name);
						mv.setViewName("student");
						mv.addObject("name",name);
					}
					return mv;
				}
				else {
					String name=this.teacherService.findName(id);
					HttpSession session=request.getSession();
					session.setAttribute("name",name);
					mv.setViewName("teacher");
					mv.addObject("name",name);
					return mv;
				}
		}
		catch(Exception e)
		{
			mv.setViewName("index");
			return mv;
		}
		
	}
	@SuppressWarnings("unused")
	@PostMapping("/forgotpassword")
	public ModelAndView forgotPassword(@RequestParam("email") String email,HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		try {
			String name;
			System.out.println(email);
			long id=this.loginService.findUserEmail(email);
			Long user_id=id;
			if(user_id!=null) {
				int role=this.loginService.findRole(id);
				if(role==1) {
					name=this.studentService.findName(id);
				}
				else
				{
					name=this.teacherService.findName(id);
				}
			    Random rnd = new Random();
			    int number = rnd.nextInt(999999);
				String vcode=String.format("%06d", number);
				System.out.println(vcode);
				HttpSession session=request.getSession();
				MailSender.send(email,"Verfication code for your password recovery","Dear "+name+",<br>Provided below is the verification "
						+ "code for recovering your password.<br><h1>"
						+ vcode
						+"</h1><br>Enter this to set a new password.<br>Thank you.");
				session.setAttribute("id",id);
				session.setAttribute("vcode", vcode);
				mv.setViewName("recover");
				return mv;
			}
			else {
				mv.setViewName("forgot");
				return mv;
			}
		}
		catch(Exception e)
		{
			mv.setViewName("forgot");
			return mv;
		}
	}
	
	@PostMapping("/recoverpassword")
	public ModelAndView recoverPassword(@RequestParam("code") String code,HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		try {
			
			System.out.println("user entered:"+code);
			HttpSession session=request.getSession(false);
			if(session!=null) {
				String vcode=(String)session.getAttribute("vcode");
				if(vcode.equals(""))
				{
					mv.setViewName("forgot");
					return mv;
				}
				System.out.println("in session:"+vcode);
				if(code.equals(vcode))
				{
					session.setAttribute("vcode","");
					mv.setViewName("NewPassword");
					return mv;
				}
				else {
					mv.setViewName("recover");
					return mv;
				}
			}
			else {
				mv.setViewName("forgot");
				return mv;
			}
		}
		catch(Exception e)
		{
			mv.setViewName("forgot");
			return mv;
		}
	}
	
	@PostMapping("/setpassword")
	public ModelAndView setPassword(@RequestParam("newpassword") String npassword,@RequestParam("confirmpassword") String cpassword,HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();	
		try{
				
				HttpSession session=request.getSession(false);
				if(npassword.equals(cpassword))
				{
					long id=(long) session.getAttribute("id");
					loginService.updatePassword(npassword,id);
					mv.setViewName("index");
					return mv;
				}
				else {
					
					mv.setViewName("NewPassword");
					return mv;
				}
			}
			catch(Exception e)
			{
				mv.setViewName("NewPassword");
				return mv;
			}
		
	}
}
