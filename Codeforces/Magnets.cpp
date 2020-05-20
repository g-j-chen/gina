#include <iostream>

int main() {
	int n;
	std::cin >> n;
	std::string prev = "";
	int groups = 1;
	for(int i = 0; i < n; i++) {
		std::string m;
		std::cin >> m;
		if(!prev.empty() && prev != m) {
			groups++;
		}
		prev = m;
	}
	std::cout << groups;
	return 0;
}