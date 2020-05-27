#include <iostream>

int main() {
	int a, b, c;
	std::cin >> a >> b >> c;
	int temp;
	if(a > c) {
		temp = a;
		a = c;
		c = temp;
	}
	if(a > b) {
		temp = a;
		a = b;
		b = temp;
	}
	if(b > c) {
		temp = b;
		b = c;
		c = temp;
	}
	std::cout << (b-a)+(c-b);
	return 0;
}