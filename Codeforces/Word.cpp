#include <iostream>
#include <string>

int main() {
	std::string s;
	std::cin >> s;
	int lower = 0;
	for(int i = 0; i < s.length(); i++) {
		if(islower(s[i])) {
			lower++;
		}
	}

	for(int i = 0; i < s.length(); i++) {
		if(lower >= s.length() - lower) {
			s[i] = tolower(s[i]);
		} else {
			s[i] = toupper(s[i]);
		}
	}

	std::cout << s;
	
	return 0;
}