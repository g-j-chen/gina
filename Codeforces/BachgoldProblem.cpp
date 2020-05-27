#include <iostream>

int main() {
	int n;
	std::cin >> n;
	std::cout << n / 2 << '\n';
	for(int i = 1; i < n/2; i++) {
		std::cout << 2 << " ";
	}
	if(n % 2 == 0) {
		std::cout << 2;
	} else {
		std::cout << 3;
	}
	return 0;
}