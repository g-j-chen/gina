#include <iostream>

int main() {
	int t;
	std::cin >> t;
	int n;
	for(int i = 0; i < t; i++) {
		std::cin >> n;
		if(n % 2 == 0) {
			n--;
		}
		std::cout << n / 2 << '\n';;
	}
	return 0;
}