#include <iostream>
#include <string>

int main() {
	int n;
	std::cin >> n;
	std::string start, combo;
	std::cin >> start >> combo;
	int count = 0;
	for(int i = 0; i < n; i++) {
		int a = (int) start[i];
		int b = (int) combo[i];
		int c = a - b;
		int diff = abs(c);
		if(diff > 5) {
			count += (10 - diff);
		} else {
			count += diff;
		}
	}
	std::cout << count;
	return  0;
}