#include <iostream>

int main() {
	int n, a, b;
	std::cin >> n;
	int numPeople = 0;
	int maxCapacity = 0;
	for(int i = 0; i < n; i++) {
		std::cin >> a >> b;
		numPeople = numPeople - a + b;
		if(numPeople > maxCapacity) {
			maxCapacity = numPeople;
		}
	}
	std::cout << maxCapacity;
	return 0;
}