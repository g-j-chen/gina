#include <iostream>
#include <algorithm>

bool comp(int a, int b) {
	return a < b;
}

int main() {
	int x[4];
	int t;
	std::cin >> x[0] >> x[1] >> x[2] >> x[3];
	t = std::max({x[0], x[1], x[2], x[3]}, comp);
	for(int z : x) {
		if(t - z > 0) {
			std::cout << t - z << " ";
		}
	}
	return 0;
}