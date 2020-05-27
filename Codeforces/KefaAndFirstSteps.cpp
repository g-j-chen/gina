#include <iostream>

int main() {
	int n;
	std::cin >> n;
	int profit[n];
	int max = 0;
	int curr = 0;
	for(int i = 0; i < n; i++) {
		std::cin >> profit[i];
		if(i == 0) {
			curr++;
			continue;
		}
		if(profit[i] >= profit[i-1]) {
			curr++;
		} else {
			if(curr > max) {
				max = curr;
			}
			curr = 1;
		}
	}
	if(curr > max) {
		max = curr;
	}
	std::cout << max;
	return 0;
}