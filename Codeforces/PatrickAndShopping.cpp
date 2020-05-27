#include <iostream>
#include <algorithm>

int main() {
	int d1, d2, d3;
	std::cin >> d1 >> d2 >> d3;
	int a = d1 + d2 + d3;
	int b = (d1 * 2) + (d2 * 2);
	int c = (d1 * 2) + (d3 * 2);
	int d = (d2 * 2) + (d3 * 2);
	std::cout << std::min(a, std::min(b, std::min(c, d)));
	return 0;
}