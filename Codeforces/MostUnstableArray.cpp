#include <iostream>
#include <algorithm>

int main() {
	int t, n, m;
	std::cin >> t;
	for(int i = 0; i < t; i++) {
		std::cin >> n >> m;
		if(n == 1) {
			std::cout << 0 << '\n';
		} else {
			std::cout << std::min(2, n - 1) * m << '\n';
		}
	}
	return 0;
}