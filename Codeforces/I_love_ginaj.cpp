#include <iostream>

int main() {
	int n;
	std::cin >> n;
	int points[n];
	for(int i = 0; i < n; i++) {
		std::cin >> points[i];
	}
	int amazing = 0;
	int min, max;
	min = max = points[0];
	for(int i = 1; i < n; i++) {
		if(points[i] > max) {
			amazing++;
			max = points[i];
		} else if(points[i] < min) {
			amazing++;
			min = points[i];
		}
	}
	std::cout << amazing;
	return 0;
}