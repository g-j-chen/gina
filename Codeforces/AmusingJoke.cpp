#include <iostream>
#include <string>

int main() {
	std::string g;
	std::string h;
	std::string p;
	std::cin >> g >> h >> p;
	int a[26] = {0};
	for(int i = 0; i < g.length(); i++) {
		int c = g[i] - 'A';
		a[c]++;
	}
	for(int i = 0; i < h.length(); i++) {
		int c = h[i] - 'A';
		a[c]++;
	}
	bool canUse = true;
	for(int i = 0; i < p.length(); i++) {
		int c = p[i] - 'A';
		a[c]--;
		if(a[c] < 0) {
			canUse = false;
			break;
		}
	}
	for(int x : a) {
		if(x != 0) {
			canUse = false;
		}
	}

	if(canUse) {
		std::cout << "YES";
	} else {
		std::cout << "NO";
	}
	return 0;
}