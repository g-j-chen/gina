#include <iostream>

int main() {
	int n, p, q;
	std::cin >> n;
	int answer = 0;
	for(int i = 0; i < n; i++) {
		std::cin >> p >> q;
		if(q - p >= 2) {
			answer++;
		}
	}
	std::cout << answer;
	return 0;
}