package hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hello.model.PalindromeResult;
import hello.service.PalindromChecker;

@RestController
public class WordController {

	@Autowired
	private PalindromChecker palindromChecker;
	
	@RequestMapping(path = "/words/{word}")
	public PalindromeResult checkPalindrome(@PathVariable(name = "word") String word) {
		PalindromeResult result = palindromChecker.getPalindormeForString(word);
		return result;
	}
}
