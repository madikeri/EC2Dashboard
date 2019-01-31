package org.ec2.cisco;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {
    
	
	    @RequestMapping("/")
	    String index(){
	        return "login";
	    }

	  @RequestMapping(value="/login", method = RequestMethod.GET)
	  public String printUser(ModelMap model) {

	      Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	      return "login";

	  }
	  
	  @RequestMapping(value="/logout", method = RequestMethod.GET)
	  public String logoutPage (HttpServletRequest request, HttpServletResponse response) {
	      Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	      if (auth != null){    
	          new SecurityContextLogoutHandler().logout(request, response, auth);
	      }
	      return "redirect:/";//You can redirect wherever you want, but generally it's a good practice to show login screen again.
	  }
	  
	  @RequestMapping(value="/logout_with_error", method = RequestMethod.GET)
	  public String logoutErrorPage (HttpServletRequest request, HttpServletResponse response) {
	      Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	      if (auth != null){    
	          new SecurityContextLogoutHandler().logout(request, response, auth);
	      }
	      return "login_error";//You can redirect wherever you want, but generally it's a good practice to show login screen again.
	  }
}
  