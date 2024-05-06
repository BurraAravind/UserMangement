package com.app.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.app.entity.User;
import com.app.service.UserService;
import com.app.service.UserServiceImpl;

@Controller
public class UserController 
{
	@Autowired
	private UserService userService;
	
	@PostMapping("/register")
    public String saveUser(User user)
	{
        userService.saveUser(user);
        return "redirect:/signin";
    }
	 
	 @GetMapping("/register")
	    public String showRegistrationForm(Model model)
	   {
	        model.addAttribute("user", new User());
	        return "register";
	    }
	 @GetMapping("/signin")
	    public String showLoginForm(Model model)
	 {
	        model.addAttribute("user", new User());
	        return "signin";
	    }
	  @PostMapping("/signin")
	    public String loginUser(User user, Model model) {
	        User loggedInUser = userService.getUserByEmailAndPassword(user.getEmail(), user.getPassword());
	        if (loggedInUser != null) {
	            return "redirect:/register";
	        } else {
	            model.addAttribute("error", "Invalid email or password");
	            return "signin";
	        }
	  }
	
	@GetMapping("/")
	public String registerPage(Model model)
	{
		return("register");
	}
	
}
