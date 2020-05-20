#include <iostream>

int main() {
	int n;
	std::cin >> n;
	int h[n];
	int min = 100;
	int minIndex;
	int max = 1;
	int maxIndex = n - 1;
	for(int i = 0; i < n; i++) {
		std::cin >> h[i];
		if(h[i] <= min) {
			min = h[i];
			minIndex = i;
		}
		if(h[i] > max) {
			max = h[i];
			maxIndex = i;
		}
	}
	int swaps = 0;
	if(min != max) {
		while(maxIndex != 0) {
			h[maxIndex] = h[maxIndex - 1];
			h[maxIndex - 1] = max;
			maxIndex--;
			if(maxIndex == minIndex) {
				minIndex++;
			}
			swaps++;
		}
		while(minIndex != n - 1) {
			h[minIndex] = h[minIndex + 1];
			h[minIndex + 1] = min;
			minIndex++;
			swaps++;
		}
	}

	std::cout << swaps;

	return 0;
}