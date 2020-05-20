#include <iostream>

int main() {
	int x;
	std::cin >> x;
	int step = x / 5;
	int remainder = x % 5;
	std::cout << step + (remainder > 0 ? 1 : 0);
	return 0;
}