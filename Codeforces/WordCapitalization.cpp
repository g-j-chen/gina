#include <iostream>
#include <stdio.h>
#include <string>
#include <ctype.h>

int main() {
	std::string s;
	std::cin >> s;
	if(islower(s[0])) {
		char c = toupper(s[0]);
		s = c + s.substr(1, (s.length()-1));
	}
	std::cout << s;
	return 0;
}