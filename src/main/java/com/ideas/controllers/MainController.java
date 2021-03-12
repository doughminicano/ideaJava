package com.ideas.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ideas.models.Ideas;
import com.ideas.models.User;
import com.ideas.services.IdeasService;
import com.ideas.services.UserServices;
import com.ideas.validator.UserValidator;

@Controller
public class MainController {
    private final UserServices userServ;
    private final UserValidator userValidator;
    private final IdeasService IdeasService;

    public MainController(UserServices userServ, UserValidator userValidator, IdeasService IdeasService ) {
        this.userServ = userServ;
        this.userValidator = userValidator;
        this.IdeasService = IdeasService;
        
    }

    @RequestMapping("/")
    public String baseRoute(@ModelAttribute("user") User user) {
        return "loginReg.jsp";
    }

    @RequestMapping("/registration")
    public String registerUser(@Valid @ModelAttribute("user") User user, BindingResult result, HttpSession session, Model model) {
    	 userValidator.validate(user, result);
    	if(result.hasErrors()) {
			return "loginReg.jsp";
		} 
    	boolean isDuplicate = userServ.duplicateUser(user.getEmail());
        if(isDuplicate) {
            model.addAttribute("error", "Email already in use! Please try again with a different email address!");
            return "loginReg.jsp";
        }
        User u = userServ.registerUser(user);
        session.setAttribute("user", u.getId());
        return "redirect:/ideas";
		}



    @RequestMapping(value="/login", method=RequestMethod.POST)
    public String loginUser(@RequestParam("email") String email, @RequestParam("password") String password, Model model, HttpSession session, RedirectAttributes redirectAttributes) {
            if (userServ.authenticateUser(email, password)) {
                session.setAttribute("user", (Long) userServ.findByEmail(email).getId());
                session.setAttribute("login", true);
                return "redirect:/ideas";
            } else {
                redirectAttributes.addFlashAttribute("error",  "Are you sure you are registered");
                model.addAttribute("error", "Not authenticated");
                return "redirect:/";
            }
    }


    @RequestMapping("/ideas")
    public String home(HttpSession session, Model model) {
        model.addAttribute("user", userServ.findUserById((Long) session.getAttribute("user")));
        model.addAttribute("allIdeas", IdeasService.retrieveAll());
        return "ideas.jsp";
    }

    @RequestMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }
    
    
	@RequestMapping("/new/ideas")
	public String newIdea(@ModelAttribute("content") Ideas ideas, Model model) {
		model.addAttribute("user", "newC");
		return "new.jsp";
	}
	
	@PostMapping("/new/idea")
	public String processNewIdea(@Valid @ModelAttribute("content") Ideas content, BindingResult result, Model model) {
		if(result.hasErrors()) {
			return "new.jsp";
		}
		else {
			IdeasService.create(content);
			return "redirect:/ideas";
		}
	}	
	
	@RequestMapping(value = "/ideas/{id}", method = RequestMethod.GET)
    public String show(@PathVariable("id") Long id, Model model) {
        Ideas idea = IdeasService.retrieve(id);
        model.addAttribute("user", idea);
        return "show.jsp";
    }
	
    @RequestMapping("/ideas/{id}/edit")
    public String edit(@PathVariable("id") Long id, Model model) {
        Ideas idea = IdeasService.retrieve(id);
        model.addAttribute("user", idea);
        return "edit.jsp";
    }
    
    @RequestMapping(value = "/ideas/{id}", method = RequestMethod.PUT)
    public String update(@Valid @ModelAttribute("user") Ideas ideas, BindingResult result) {
        if (result.hasErrors()) {
            return "/books/edit.jsp";
        } else {
            IdeasService.update(ideas.getId());
            return "redirect:/ideas";
        }
    }
    
//    @RequestMapping(value = "/ideas/{id}", method = RequestMethod.DELETE)
//    public String destroy(@PathVariable("id") Long id) {
//        IdeasService.delete(id);
//        return "redirect:/books";
//    }
}

