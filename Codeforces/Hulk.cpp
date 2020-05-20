#include <iostream>
#include <string>

int main() {
	int n;
	std::cin >> n;
	std::string s = "I hate";
	for(int i = 2; i <= n; i++) {
		if(i % 2 == 0) {
			s.append(" that I love");
		} else {
			s.append(" that I hate");
		}
	}
	s.append(" it");
	std::cout << s;
	return 0;
}