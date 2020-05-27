#include <iostream>

int main() {
	int t, a, b;
	std::cin >> t;
	for(int i = 0; i < t; i++) {
		std::cin >> a >> b;
		int count = 0;
		int diff = a - b;
		if(diff > 0) {
			if(diff % 2 == 0) {
				count = 1;
			} else {
				count = 2;
			}
		} else if(diff < 0) {
			if(diff % 2 == 0) {
				count = 2;
			} else {
				count = 1;
			}
		}
		std::cout << count << '\n';
	}
	return 0;
}