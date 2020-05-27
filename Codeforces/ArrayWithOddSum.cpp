#include <iostream>

int main() {
	int t, n;
	std::cin >> t;
	for(int i = 0; i < t; i++) {
		std::cin >> n;
		int a;
		int even = 0;
		int odd = 0;
		for(int j = 0; j < n; j++) {
			std::cin >> a;
			if(a % 2 == 0) {
				even++;
			} else {
				odd++;
			}
		}
		if((odd == 0) || (even == 0 && odd % 2 == 0)) {
			std::cout << "NO" << '\n';
		} else {
			std::cout << "YES" << '\n';
		}

	}
	return 0;
}