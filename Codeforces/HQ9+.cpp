#include <iostream>
#include <string>

int main() {
	std::string s;
	std::cin >> s;
	bool print = false;
	for(char &c : s) {
		if(c == 'H' || c == 'Q' || c == '9') {
			print = true;
			break;
		}
	}
	if(print) {
		std::cout << "YES";
	} else {
		std::cout << "NO";
	}
	return 0;
}