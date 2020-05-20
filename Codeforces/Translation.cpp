#include <iostream>
#include <string>

int main() {
	std::string s, t;
	std::cin >> s >> t;
	bool same = true;
	if(s.length() == t.length()) {
		for(int i = 0; i < s.length(); i++) {
			if(s[i] != t[t.length() - 1 - i]) {
				same = false;
				break;
			}
		}
	} else {
		same = false;
	}
	
	if(same) {
		std::cout << "YES";
	} else {
		std::cout << "NO";
	}
	return 0;
}