#include <iostream>

int main() {
	int n;
	std::cin >> n;
	int level = 0;
	int cubes = 1;
	while(n - cubes >= 0) {
		n -= cubes;
		level++;
		cubes += (level + 1);
	}
	std::cout << level;
	return 0;
}