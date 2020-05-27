#include <iostream>

int gcd(int a, int b) {
	return (a == 0) ? b : gcd(b % a, a);
}

int main() {
	int a, b, n;
	std::cin >> a >> b >> n;
	int count = 0;
	while(n >= 0) {
		count++;
		int p = (count & 1) ? a : b;
		n -= gcd(p, n);
	}
	if(count & 1) {
		std::cout << 1;
	} else {
		std::cout << 0;
	}
	return 0;
}