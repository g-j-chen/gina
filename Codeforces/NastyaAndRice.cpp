#include <iostream>

int main() {
	int t, n, a, b, c, d;
	std::cin >> t;
	for(int i = 0; i < t; i++) {
		std::cin >> n >> a >> b >> c >> d;
		int grainLower = a - b;
		int grainUpper = a + b;
		int packLower = c - d;
		int packUpper = c + d;
		if(grainUpper * n < packLower || grainLower * n > packUpper) {
			std::cout << "No" << '\n';
		} else {
			std::cout << "Yes" << '\n';
		}
	}
	return 0;
}