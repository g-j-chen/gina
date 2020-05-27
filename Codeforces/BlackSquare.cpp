#include <iostream>
#include <string>

int main() {
	int a1, a2, a3, a4;
	std::cin >> a1 >> a2 >> a3 >> a4;
	std::string s;
	std::cin >> s;
	int cal = 0;
	for(int i = 0; i < s.length(); i++) {
		if(s[i] == '1') {
			cal += a1;
		} else if(s[i] == '2') {
			cal += a2;
		} else if(s[i] == '3') {
			cal += a3;
		} else {
			cal += a4;
		}
	}
	std::cout << cal;
	return 0;
}