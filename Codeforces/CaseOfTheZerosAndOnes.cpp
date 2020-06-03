#include <iostream>
#include <string>
#include <algorithm>

int main() {
	int n;
	std::cin >> n;
	std::string s;
	std::cin >> s;
	int zeros = 0, ones = 0;
	for(char c : s) {
		if(c == '0') {
			zeros++;
		} else {
			ones++;
		}
	}
	std::cout << s.length() - (2 * std::min(zeros, ones));

	return 0;
}