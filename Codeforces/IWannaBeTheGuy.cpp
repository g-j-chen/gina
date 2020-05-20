#include <iostream>
#include <string>

int main() {
	int n;
	std::cin >> n;
	bool levels[n] = {false};
	int p;
	std::cin >> p;
	int a;
	for(int i = 0; i < p; i++) {
		std::cin >> a;
		levels[a - 1] = true;
	}
	std::cin >> p;
	for(int i = 0; i < p; i++) {
		std::cin >> a;
		levels[a - 1] = true;
	}
	bool pass = true;
	for(int i = 0; i < n; i++) {
		if(!levels[i]) {
			pass = false;
			break;
		}
	}
	if(pass) {
		std::cout << "I become the guy.";
	} else {
		std::cout << "Oh, my keyboard!";
	}
	return 0;
}