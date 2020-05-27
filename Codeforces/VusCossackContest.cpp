#include <iostream>

int main() {
	int n, m, k;
	std::cin >> n >> m >> k;
	if(m >= n && k >= n) {
		std::cout << "Yes";
	} else {
		std::cout << "No";
	}
	return 0;
}