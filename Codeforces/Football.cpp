#include <iostream>
#include <string>

int main() {
	std::string s;
	std::cin >> s;
	int prev = s[0];
	int count = 1;
	bool danger = false;

	for(int i = 1; i < s.length(); i++) {
		if(s[i] == prev) {
			count++;
		} else {
			count = 1;
			prev = s[i];
		}
		if(count == 7) {
			danger = true;
			break;
		}
	}

	if(danger) {
		std::cout << "YES";
	} else {
		std::cout << "NO";
	}
	return 0;
}