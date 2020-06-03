#include <iostream>
#include <algorithm>

int main() {
	int n;
	std::cin >> n;
	if(n >= 0) {
		std::cout << n;
	} else {
		int a = n / 10;
		int b = (n / 100) * 10 + (n % 10);
		std::cout << std::max(a, b);
	}
	return 0;
}