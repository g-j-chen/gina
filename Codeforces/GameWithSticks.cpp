#include <iostream>
#include <algorithm>

int main() {
	int n, m;
	std::cin >> n >> m;
	int min = std::min(n, m);
	if(min % 2 != 0) {
		std::cout << "Akshat";
	} else {
		std::cout << "Malvika";
	}
	return 0;
}