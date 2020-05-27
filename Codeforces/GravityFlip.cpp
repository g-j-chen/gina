#include <iostream>
#include <algorithm>

int main() {
	int n;
	std::cin >> n;
	int cubes[n];
	for(int i = 0; i < n; i++) {
		std::cin >> cubes[i];
	}
	std::sort(cubes, cubes + n);
	for(int i = 0; i < n; i++) {
		std::cout << cubes[i] << " ";
	}
	return 0;
}