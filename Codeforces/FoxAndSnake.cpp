#include <iostream>
#include <string>

int main() {
	int n, m;
	std::cin >> n >> m;
	for(int r = 1; r <= n; r++) {
		for(int c = 1; c <= m; c++) {
			if(r % 2 != 0) {
				std::cout << '#';
			} else {
				if(r % 4 != 0) {
					if(c == m) {
						std::cout << '#';
					} else {
						std::cout << '.';
					}
				} else {
					if(c == 1) {
						std::cout << '#';
					} else {
						std::cout << '.';
					}
				}
			}
		}
		std::cout << '\n';
	}
	return 0;
}