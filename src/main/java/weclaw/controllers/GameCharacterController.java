package weclaw.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import weclaw.domain.ApplicationUser;
import weclaw.domain.GameCharacter;
import weclaw.repositories.ApplicationUserRepository;
import weclaw.repositories.GameCharacterRepository;;

@Controller
@RequestMapping(path="/character")
public class GameCharacterController {
    @Autowired
	private ApplicationUserRepository userRepository;

	@Autowired
	private GameCharacterRepository characterRepository;

	@RequestMapping(path="/save")
    public String saveGameCharacter(@RequestParam Long userId, @RequestParam Long id, @RequestParam String name, @RequestParam Integer level, 
    @RequestParam String characterClass, Model model) {
        GameCharacter character = characterRepository.findOne(id);
        if( character == null ) {
            character = new GameCharacter();
            character.setId(id);
        }
        character.setName(name);
        character.setLevel(level);
        character.setCharacterClass(characterClass);
		character.setUser(userRepository.findOne(userId));
		characterRepository.save(character);
		model.addAttribute("users", userRepository.findAll());
		return "home";
	}

	@RequestMapping(path="/delete")
	public String deleteGameCharacter(@RequestParam Long id, Model model) {
		characterRepository.delete(id);
		model.addAttribute("users", userRepository.findAll());
		return "home";
	}

}