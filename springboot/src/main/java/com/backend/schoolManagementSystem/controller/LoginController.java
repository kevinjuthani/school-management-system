package com.backend.schoolManagementSystem.controller;

import java.net.http.HttpRequest;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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

@Controller
public class LoginController {
	@Autowired
	LoginService loginService;
	@Autowired
	StudentService studentService;
	@Autowired
	TeacherService teacherService; 
	
	@RequestMapping("/")
	public String Index() {
		return "index.jsp";
	}
	@RequestMapping(value="/login", method = RequestMethod.POST)
	public String login(Login user,HttpServletRequest request) {
		try {
			System.out.println(user.getEmail()+" - "+user.getPassword());
			if(user.getEmail().equals("admin@admin.com")&&(user.getPassword().equals("admin")))
				return "admin.jsp";
				long id=this.loginService.findPassword(user.getEmail(), user.getPassword());
				int role=this.loginService.findRole(id);
				if(role==1)
				{  
					HttpSession session=request.getSession();
					session.setAttribute("name",this.studentService.findName(id));
					return "student.jsp";
				}
				else {
					HttpSession session=request.getSession();
					session.setAttribute("name",this.teacherService.findName(id));
					return "teacher.jsp";
				}
		}
		catch(Exception e)
		{
			return "index.jsp";
		}
		
	}
	@SuppressWarnings("unused")
	@RequestMapping(value="/forgotpassword",method={RequestMethod.POST,RequestMethod.GET})
	public String forgotPassword(@RequestParam("email") String email,HttpServletRequest request) {
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
				return "recover.jsp";
			}
			else {
				return "forgot.jsp";
			}
		}
		catch(Exception e)
		{
			return "forgot.jsp";
		}
	}
	
	@RequestMapping(value="/recoverpassword",method={RequestMethod.POST,RequestMethod.GET})
	public String recoverPassword(@RequestParam("code") String code,HttpServletRequest request) {
		try {
			System.out.println("user entered:"+code);
			HttpSession session=request.getSession(false);
			if(session!=null) {
				String vcode=(String)session.getAttribute("vcode");
				if(vcode.equals(""))
					return "forgot.jsp";
				System.out.println("in session:"+vcode);
				if(code.equals(vcode))
				{
					session.setAttribute("vcode","");
					return "NewPassword.jsp";
				}
				else {
					return "recover.jsp";
				}
			}
			else {
				return "forgot.jsp";
			}
		}
		catch(Exception e)
		{
			return "forgot.jsp";
		}
	}
	
	@RequestMapping(value="/setpassword",method={RequestMethod.POST,RequestMethod.GET})
	public String setPassword(@RequestParam("newpassword") String npassword,@RequestParam("confirmpassword") String cpassword,HttpServletRequest request) {
			try{
				HttpSession session=request.getSession(false);
				if(npassword.equals(cpassword))
				{
					long id=(long) session.getAttribute("id");
					loginService.updatePassword(npassword,id);
					return "index.jsp";
				}
				else {
					System.out.println("hi");
				return "Newpassword.jsp";
				}
			}
			catch(Exception e)
			{
				return "Newpassword.jsp";
			}
		
	}
}
