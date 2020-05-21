#include <iostream>

int main() {
	int n, k;
	std::cin >> n >> k;
	int time = 240 - k;
	for(int i = 1; i <= n; i++) {
		if(time - (5 * i) < 0) {
			std::cout << i - 1;
			return 0;
		}
		time -= (5 * i);
	}
	std::cout << n;
	return 0;
}