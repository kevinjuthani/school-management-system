package com.backend.schoolManagementSystem.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.backend.schoolManagementSystem.dao.LoginRepo;
import com.backend.schoolManagementSystem.model.Login;

@Component
public class LoginService {
	@Autowired
	LoginRepo loginRepository;
	
	public long findPassword(String email,String password)
	{
		return Long.parseLong(this.loginRepository.findPassword(email, password));
	}
	
	public int findRole(long id)
	{
		return Integer.parseInt(this.loginRepository.findRole(id));
	}
	public int findOtl(long id)
	{
		return Integer.parseInt(this.loginRepository.findOtl(id));
	}
	public long findUserEmail(String email)
	{
		return Long.parseLong(this.loginRepository.findEmail(email)); 
	}
	
	public void updatePassword(String password,long id)
	{
		Login user=this.loginRepository.findById(id).orElse(new Login());
		if(user.getId()==0)
		{
			return;
		}
		else
		{
			user.setPassword(password);
			user.setOtl("0");
			this.loginRepository.save(user);
		}
	}
	
}
