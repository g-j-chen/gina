#include <iostream>

int main() {
	long long n, lastEven, lastOdd, evens, odds;
	std::cin >> n;
	if(n % 2 == 0) {
		lastEven = n;
		lastOdd = n - 1;
	} else {
		lastEven = n - 1;
		lastOdd = n;
	}
	evens = (2 + lastEven) / 2 - 1;
	evens *= (evens + 1);
	odds = ((1 + lastOdd) / 2);
	odds *= odds;
	std::cout << evens - odds;
	return 0;
}