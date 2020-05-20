#include <iostream>

int main() {
	int n, k;
	std::cin >> n >> k;
	int nums[n];
	int i;
	for(i = 0; i < n; i++) {
		std::cin >> nums[i];
	}

	int scoreCutOff = nums[k - 1];
	int count = 0;
	for(i = 0; i < n; i++) {
		if(nums[i] < scoreCutOff) {
			break;
		}
		if(nums[i] > 0) {
			count++;
		}
	}
	std::cout << count;
	return 0;
}