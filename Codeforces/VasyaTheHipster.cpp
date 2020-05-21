#include <iostream>

int main() {
	int a, b;
	std::cin >> a >> b;
	if(a <= b) {
		std::cout << a << " " << (b - a) / 2;
	} else {
		std::cout << b << " " << (a - b) / 2;
	}
	return 0;
}