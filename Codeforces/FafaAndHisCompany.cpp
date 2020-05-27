#include <iostream>

int main() {
	int n;
	std::cin >> n;
	int count = 0;
	for(int i = 1; i <= n / 2; i++) {
		if((n - i) % i == 0) {
			count++;
		}
	}
	std::cout << count;
	return 0;
}