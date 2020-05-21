#include <iostream>
#include <cmath>

bool isComposite(int x) {
	for(int i = 2; i <= std::sqrt(x); i++) {
		if(x % i == 0) {
			return true;
		}
	}
	return false;
}

int main() {
	int n;
	std::cin >> n;
	bool iComp = false;
	bool dComp = false;
	for(int i = 4; i < n; i++) {
		if(i % 2 != 0) {
			iComp = isComposite(i);
		} else {
			iComp = true;
		}
		int d = n - i;
		dComp = isComposite(d);
		if(iComp && dComp) {
			std::cout << i << " " << d;
			break;
		}
	}
	return 0;
}