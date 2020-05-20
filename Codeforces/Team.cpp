#include <iostream>

int main() {
	int t;
	std::cin >> t;
	int a, b, c;
	int count = 0;
	int i;
	for(i = 1; i <= t; i++) {
		std::cin >> a >> b >> c;
		if(a + b + c >= 2) {
			count++;
		}
	}
	std::cout << count;

	return 0;
}