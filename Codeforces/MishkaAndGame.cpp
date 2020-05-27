#include <iostream>

int main() {
	int n, m, c;
	std::cin >> n;
	int mw = 0;
	int cw = 0;
	for(int i = 0; i < n; i++) {
		std::cin >> m >> c;
		if(m > c) {
			mw++;
		} else if(c > m) {
			cw++;
		}
	}
	if(mw > cw) {
		std::cout << "Mishka";
	} else if(cw > mw) {
		std::cout << "Chris";
	} else {
		std::cout << "Friendship is magic!^^";
	}
	return 0;
}