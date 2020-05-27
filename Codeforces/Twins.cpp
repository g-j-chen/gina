#include <iostream>
#include <algorithm>

int main() {
	int n;
	std::cin >> n;
	int val[n];
	int total = 0;
	for(int i = 0; i < n; i++) {
		std::cin >> val[i];
		total += val[i];
	}
	std::sort(val, val + n, std::greater<int>());
	int sum = 0;
	int coins = 0;
	while(sum <= total / 2) {
		sum += val[coins];
		coins++;
	}
	std::cout << coins;
	return 0;
}