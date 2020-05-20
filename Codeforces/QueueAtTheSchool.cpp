#include <iostream>
#include <string>

int main() {
	int n, t;
	std::cin >> n >> t;
	std::string line;
	std::cin >> line;

	for(int i = 0; i < t; i++) {
		int j = 0;
		while(j < n) {
			if(line[j] == 'B') {
				if(j + 1 < n && line[j + 1] == 'G') {
					line[j] = 'G';
					line[j + 1] = 'B';
					j++;
				}
			}
			j++;
		}
	}
	std::cout << line;
	return 0;
}