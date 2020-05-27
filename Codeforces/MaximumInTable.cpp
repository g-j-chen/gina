#include <iostream>

int main() {
	int n;
	std::cin >> n;
	int m[n][n];
	for(int i = 0; i < n; i++) {
		for(int j = 0; j < n; j++) {
			if(i == 0 || j == 0) {
				m[i][j] = 1;
			} else {
				m[i][j] = m[i-1][j] + m[i][j-1];
			}
		}
	}
	std::cout << m[n-1][n-1];
	return 0;
}