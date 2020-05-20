#include <iostream>
#include <string>

int main() {
	int n;
	std::cin >> n;
	std::string s;
	std::cin >> s;
	int a = 0;
	int d = 0;
	for(int i = 0; i < n; i++) {
		if(s[i] == 'A') {
			a++;
		} else {
			d++;
		}
	}

	if(a > d) {
		std::cout << "Anton";
	} else if(d > a) {
		std::cout << "Danik";
	} else {
		std::cout << "Friendship";
	}
	return 0;
}