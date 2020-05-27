#include <iostream>
#include <cmath>

int main() {
	int t, n;
	std::cin >> t;
	for(int i = 0; i < t; i++) {
		std::cin >> n;
		std::cout << std::pow(2, (n/2)+1) - 2 << '\n';
	}
	return 0;
}