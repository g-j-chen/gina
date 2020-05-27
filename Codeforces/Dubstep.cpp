#include <iostream>
#include <string>

int main() {
	std::string s;
	std::cin >> s;
	bool flag = true;
	int i = 0;
	while(i < s.length()) {
		if(s.substr(i, 3) == "WUB") {
			i += 3;
			if(!flag) {
				std::cout << " ";
			}
		} else {
			flag = false;
			std::cout << s[i];
			i++;
		}
	}
	return 0;
}