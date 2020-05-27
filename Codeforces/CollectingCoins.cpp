#include <iostream>
#include <algorithm>

int main() {
	int t, a, b, c, n;
	std::cin >> t;
	for(int i = 0; i < t; i++) {
		std::cin >> a >> b >> c >> n;
		int max = std::max(a, std::max(b, c));
		int toEven = (max - a) + (max - b) + (max - c);
		if(toEven <= n && (n - toEven) % 3 == 0) {
			std::cout << "YES" << '\n';
		} else {
			std::cout << "NO" << '\n';
		}
	}
	return 0;
}