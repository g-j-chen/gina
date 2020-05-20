#include <iostream>
#include <iomanip>

int main() {
	int n;
	std::cin >> n;
	int p;
	int a = 0;
	for(int i = 0; i < n; i++) {
		std::cin >> p;
		a += p;
	}
	std::cout << std::setprecision(14) << (1.0 * a / n);
	return 0;
}