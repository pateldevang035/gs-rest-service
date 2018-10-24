package hello.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Service;

@Service
public class AnagramFinderImpl implements AnagramFinder {

	public Set<String> anagramsFinder(String str) {
		Set<String> anag = new HashSet<String>();
		if (str == null) {
			return null;
		} else if (str.length() == 0) {
			anag.add("");
			return anag;
		}
		char initial = str.charAt(0);
		String rem = str.substring(1);
		Set<String> words = anagramsFinder(rem);
		for (String strNew : words) {
			for (int i = 0; i <= strNew.length(); i++) {
				anag.add(charInsert(strNew, initial, i));
			}
		}
		return anag;
	}

	private String charInsert(String s, char a, int i) {
		String begin = s.substring(0, i);
		String end = s.substring(i);
		return begin + a + end;
	}
}
