#include <iostream>

int main() {
	int n, m;
	std::cin >> n >> m;
	int s = n + n/(m - 1);
	if(n % (m - 1) == 0) {
		s--;
	}

	std::cout << s;
	return 0;
}