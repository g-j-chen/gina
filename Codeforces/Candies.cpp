#include <iostream>
#include <cmath>

int main() {
	int t;
	std::cin >> t;
	for(int tc = 0; tc < t; tc++) {
		int n;
		std::cin >> n;
		for(int k = 2; pow(2, k) <= n + 1; k++) {
			int mult = pow(2, k) - 1;
			int x = n / mult;
			if(x * mult == n) {
				std::cout << x << '\n';
				break;
			}
		}
	}
	return 0;
}