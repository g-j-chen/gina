#include <iostream>
#include <string>

int main() {
	int n;
	std::cin >> n;
	
	int i;
	std::string words[n];
	for(i = 0; i < n; i++) {
		std::cin >> words[i];
	}

	std::string w;
	for(i = 0; i < n; i++) {
		w = words[i];
		int len = w.length();
		if(len <= 10) {
			std::cout << w << '\n';
		} else {
			std::string answer = w[0] + std::to_string(len - 2) + w[len - 1];
			std::cout << answer << '\n';
		}
	}
	return 0;
}