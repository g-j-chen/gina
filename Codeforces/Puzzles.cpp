#include <iostream>
#include <algorithm>
#include <climits>

int main() {
	int n, m;
	std::cin >> n >> m;
	int f[m];
	for(int i = 0; i < m; i++) {
		std::cin >> f[i];
	}
	std::sort(f, f+m);
	int diff = INT_MAX;
	for(int i = 0; i <= m - n; i++) {
		diff = std::min(diff, f[n - 1 + i] - f[i]);
	}
	if(n == m) {
		diff = f[m - 1] - f[0];
	}
	std::cout << diff;
	return 0;
}