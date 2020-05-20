#include <iostream>
#include <string>

int main() {
	int n;
	std::cin >> n;
	int a[n];
	bool easy = true;
	for(int i = 0; i < n; i++) {
		std::cin >> a[i];
		if(a[i] == 1) {
			easy = false;
		}
	}
	if(easy) {
		std::cout << "EASY";
	} else {
		std::cout << "HARD";
	}
	return 0;
}