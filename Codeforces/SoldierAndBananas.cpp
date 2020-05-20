#include <iostream>

int main() {
	int k, n, w;
	std::cin >> k >> n >> w;
	int total = (k * w * (w + 1)) / 2;
	int borrow = total - n;
	if(borrow > 0) {
		std::cout << borrow;
	} else {
		std::cout << 0;
	}
	
	return 0;
}