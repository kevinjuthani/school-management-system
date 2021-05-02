package com.backend.schoolManagementSystem.controller;

import java.net.http.HttpRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import com.backend.schoolManagementSystem.dao.LoginRepo;
import com.backend.schoolManagementSystem.dao.StudentRepo;
import com.backend.schoolManagementSystem.dao.TeacherRepo;
import com.backend.schoolManagementSystem.model.Login;
import com.backend.schoolManagementSystem.model.Student;
import com.backend.schoolManagementSystem.model.Teacher;

@Controller
public class LoginController {
	@Autowired
	LoginRepo l_repo;
	@Autowired
	StudentRepo s_repo;
	@Autowired
	TeacherRepo t_repo;
	
	@RequestMapping("/")
	public String Index() {
		return "index.jsp";
	}
	@RequestMapping(value="/login", method = RequestMethod.POST)
	public String login(Login user,HttpServletRequest request) {
		try {
			if(user.getEmail().equals("admin@admin.com")&&(user.getPassword().equals("admin")))
				return "admin.jsp";
				String id=l_repo.findPassword(user.getEmail(), user.getPassword());
				String role=l_repo.findRole(id);
				if(role.equals("1"))
				{  
					HttpSession session=request.getSession();
					session.setAttribute("name",s_repo.findName(id));
					return "student.jsp";
				}
				else {
					HttpSession session=request.getSession();
					session.setAttribute("name",t_repo.findName(id));
					return "teacher.jsp";
				}
		}
		catch(Exception e)
		{
			return "index.jsp";
		}
		
	}
}
