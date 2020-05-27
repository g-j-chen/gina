#include <iostream>

	int main() {
	int n;
	std::cin >> n;
	int e[n];
	int count = 0;
	int police = 0;
	for(int i = 0; i < n; i++) {
		std::cin >> e[i];
		if(e[i] == -1) {
			if(police == 0) {
				count++;
			} else {
				police--;
			}
		} else {
			police += e[i];
		}
	}
	std::cout << count;
	return 0;
}