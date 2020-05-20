#include <iostream>

int main() {
	int n, h;
	std::cin >> n >> h;
	int p[n];
	int w = 0;
	for(int i = 0; i < n; i++) {
		std::cin >> p[i];
		if(p[i] > h) {
			w += 2;
		} else {
			w++;
		}
	}
	std::cout << w;

	return 0;
}