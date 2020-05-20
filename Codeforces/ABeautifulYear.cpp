#include <iostream>

int main() {
	int y;
	std::cin >> y;
	y++;

	while(1) {
		bool freq[10] = {false};
		int x = y;
		bool distinct = true;
		while(x > 0) {
			if(freq[x % 10]) {
				distinct = false;
				break;
			}
			freq[x % 10] = true;
			x /= 10;
		}
		if(distinct) {
			std::cout << y;
			break;
		} else {
			y++;
		}
	}
	return 0;
}