#include <iostream>
#include <string>

int main() {
	int n;
	std::cin >> n;
	int x = 0;
	std::string input;
	for(int i = 0; i < n; i++) {
		std::cin >> input;
		if(input == "X++" || input == "++X") {
			x++;
		} else {
			x--;
		}
	}
	std::cout << x;

	return 0;
}