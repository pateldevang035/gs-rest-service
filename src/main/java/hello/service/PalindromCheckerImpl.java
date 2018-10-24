package hello.service;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hello.model.PalindromeResult;

@Service
public class PalindromCheckerImpl implements PalindromChecker{

	@Autowired
	private AnagramFinder anagramService;
	
	public PalindromeResult getPalindormeForString(String original) {
		PalindromeResult result = new PalindromeResult();
		result.setWord(original);
		result.setPalindrome(checkPalindrom(original));
		result.setAnagramOfPalindrome(checkPalindormInSet(anagramService.anagramsFinder(original)));
		return result;
	}

	private boolean checkPalindrom(String original) {
		String reverse = "";
		boolean result;
		int length = original.length();
		for (int i = length - 1; i >= 0; i--)
			reverse = reverse + original.charAt(i);
		if (original.equals(reverse))
			result = true;
		else
			result = false;
		return result;
	}
	private boolean checkPalindormInSet(Set<String> all) {
		boolean result = false;
		for(String curr : all) {
			result = checkPalindrom(curr);
			if(result) {
				break;
			}
		}
		return result;
	}
}
