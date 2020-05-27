#include <iostream>
#include <vector>
#include <algorithm>

int main() {
	int n, c;
	std::cin >> n;
	std::vector<int> prog, math, pe;
	for(int i = 0; i < n; i++) {
		std::cin >> c;
		if(c == 1) {
			prog.push_back(i+1);
		} else if(c == 2) {
			math.push_back(i+1);
		} else {
			pe.push_back(i+1);
		}
	}

	int min = std::min(prog.size(), std::min(math.size(), pe.size()));
	std::cout << min << '\n';
	if(min != 0) {
		for(int i = 0; i < min; i++) {
			std::cout << prog[i] << " " << math[i] << " " << pe[i] << '\n';
		}
	}

	return 0;
}