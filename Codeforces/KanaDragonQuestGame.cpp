#include <iostream>

int main() {
	int t;
	std::cin >> t;
	for(int i = 0; i < t; i++) {
		int x, n, m;
		std::cin >> x >> n >> m;
		
		while(n > 0 && x > 20) {
			x = (x / 2) + 10;
			n--;
		}
		while(m > 0) {
			x -= 10;
			m--;
		}
		if(x > 0) {
			std::cout << "NO" << '\n';
		} else {
			std::cout << "YES" << '\n';
		}
	}
	return 0;
}