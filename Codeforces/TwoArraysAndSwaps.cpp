#include <iostream>
#include <algorithm>
#include <numeric>

int main() {
	int t, n, k;
	std::cin >> t;
	
	for(int tc = 0; tc < t; tc++) {
		std::cin >> n >> k;
		int a[n];
		for(int i = 0; i < n; i++) {
			std::cin >> a[i];
		}
		
		int b[n];
		for(int i = 0; i < n; i++) {
			std::cin >> b[i];
		}

		std::sort(a, a + n);
		std::sort(b, b + n);
		int i = 0;
		int j = n - 1;
		while(i < k) {
			if(a[i] < b[j]) {
				a[i] = b[j];
				i++;
				j--;
			} else {
				break;
			}
		}
		
		std::cout << std::accumulate(a, a + n, 0) << '\n';
	}

	return 0;
}