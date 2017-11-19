package weclaw.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import weclaw.repositories.ApplicationUserRepository;


@Controller
public class MainController {
    @Autowired
	private ApplicationUserRepository userRepository;

	@RequestMapping(path="/")
    public String mainPage(Model model) {
		model.addAttribute("users", userRepository.findAll());
		return "home";
	}

}