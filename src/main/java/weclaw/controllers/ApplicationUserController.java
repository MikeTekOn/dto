package weclaw.controllers;

import java.text.ParseException;
import java.util.TimeZone;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import weclaw.domain.ApplicationUser;
import weclaw.domain.dto.ApplicationUserDto;
import weclaw.repositories.ApplicationUserRepository;;

@Controller
@RequestMapping(path="/user")
public class ApplicationUserController {
	@Autowired
	private ApplicationUserRepository userRepository;

	@Autowired
    private ModelMapper modelMapper;

	@RequestMapping(path="/save")
	public String saveApplicationUser(@RequestParam Long id, @RequestParam String name, @RequestParam String email, Model model) {
		ApplicationUser applicationUser = userRepository.findOne(id);
		if( applicationUser == null ) {
			applicationUser = new ApplicationUser();
			applicationUser.setId(id);
		}
		applicationUser.setName(name);
		applicationUser.setEmail(email);
		userRepository.save(applicationUser);

		model.addAttribute("users", userRepository.findAll());
		return "home";
	}

	@RequestMapping(path="/delete")
	public String deleteApplicationUser(@RequestParam Long id, Model model) {
		userRepository.delete(id);
		model.addAttribute("users", userRepository.findAll());
		return "home";
	}

	private ApplicationUserDto convertToDto(ApplicationUser applicationUser) {
		ApplicationUserDto applicationUserDto = modelMapper.map(applicationUser, ApplicationUserDto.class);
		applicationUserDto.setLastLoginDate(applicationUser.getLastLogin(), 
			TimeZone.getTimeZone("Europe/Warsaw").toString());
		return applicationUserDto;
	}

	private ApplicationUser convertToEntity(ApplicationUserDto applicationUserDto) throws ParseException {
		ApplicationUser applicationUser = modelMapper.map(applicationUserDto, ApplicationUser.class);
		applicationUser.setLastLogin(applicationUserDto.getLastLoginDateConverted(
			TimeZone.getTimeZone("Europe/Copenhagen").toString()));
	  
		return applicationUser;
	}


}