#include <iostream>

int main() {
	int n, m;
	std::cin >> n >> m;
	char p;
	bool colour = false;
	for(int i = 0; i < n; i++) {
		for(int j = 0; j < m; j++) {
			std::cin >> p;
			if(p == 'C' || p == 'Y' || p == 'M') {
				colour = true;
			}
		}
	}
	if(colour) {
		std::cout << "#Color";
	} else {
		std:: cout << "#Black&White";
	}
	return 0;
}