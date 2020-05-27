#include <iostream>

int main() {
	int t, h, m;
	std::cin >> t;
	for(int i = 0; i < t; i++) {
		std::cin >> h >> m;
		int answer = 0;
		if(m == 0) {
			answer = (24 - h) * 60;
		} else {
			answer = 60 - m + (23 - h) * 60;
		}
		std::cout << answer << '\n';
	}
	return 0;
}