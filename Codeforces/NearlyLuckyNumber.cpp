#include <iostream>

int main() {
	unsigned long long n;
	std::cin >> n;
	int luckyNums = 0;
	while(n > 0) {
		int d = n % 10;
		if(d == 4 || d == 7) {
			luckyNums++;
		}
		n /= 10;
	}
	bool nearlyLucky = true;
	if(luckyNums == 0) {
		nearlyLucky = false;
	}

	while(luckyNums > 0) {
		int d = luckyNums % 10;
		if(d != 4 && d != 7) {
			nearlyLucky = false;
			break;
		}
		luckyNums /= 10;
	}

	if(nearlyLucky) {
		std::cout << "YES";
	} else {
		std::cout << "NO";
	}
	return 0;
}