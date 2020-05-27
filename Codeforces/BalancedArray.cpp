#include <iostream>

int main() {
	int t;
	std::cin >> t;
	int n;
	for(int i = 0; i < t; i++) {
		std::cin >> n;
		if(n % 4 != 0) {
			std::cout << "NO" << '\n';
		} else {
			std::cout << "YES" << '\n';
			int j;
			for(j = 2; j <= n; j+=2) {
				std::cout << j << " ";
			}
			for(j = 1; j < n - 1; j+=2) {
				std::cout << j << " ";
			}
			std::cout << j + (n/2) << '\n';
		}
	}
	return 0;
}