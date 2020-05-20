#include <iostream>

int main() {
	int t, a, b;
	std::cin >> t;
	for(int i = 0; i < t; i++) {
		std::cin >> a >> b;
		if(a % b == 0) {
			std::cout << 0 << '\n';
		} else {
			int div = a / b;
			int req = (div + 1) * b - a;
			std::cout << req << '\n';
		}
	}
	return 0;
}