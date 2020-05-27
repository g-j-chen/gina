#include <iostream>

int main() {
	unsigned long long n, k, half, ans;
	std::cin >> n >> k;
	half = n / 2;
	if(n & 1) {
		half++;
	}

	if(k <= half) {
		ans = 2 * k - 1;
	} else {
		ans = 2 * k - n;
		if(n & 1) {
			ans--;
		}
	}

	std::cout << ans;
	return 0;
}