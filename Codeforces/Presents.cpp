#include <iostream>

int main() {
	int n;
	std::cin >> n;
	int g[n];
	for(int i = 0; i < n; i++) {
		std::cin >> g[i];
	}
	int ans[n];
	for(int i = 0; i < n; i++) {
		int giver = g[i] - 1;
		int rec = g[giver] - 1;
		ans[rec] = giver + 1;
	}
	for(int i = 0; i < n; i++) {
		std::cout << ans[i] << " ";
	}
	return 0;
}