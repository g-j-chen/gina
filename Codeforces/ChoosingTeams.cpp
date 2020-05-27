#include <iostream>
#include <algorithm>

int main() {
	int n, k;
	std::cin >> n >> k;
	int s[n];
	for(int i = 0; i < n; i++) {
		std::cin >> s[i];
	}
	std::sort(s, s+n);
	int avail = 0;
	for(auto p : s) {
		if(p + k <= 5) {
			avail++;
		}
	}
	std::cout << avail / 3;
	return 0;
}