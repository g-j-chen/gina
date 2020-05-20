#include <iostream>

int main() {
	int n;
	std::cin >> n;
	int home[n];
	int awayColours[101] = {0};
	for(int i = 0; i < n; i++) {
		int h, a;
		std::cin >> h >> a;
		home[i] = h;
		awayColours[a]++;
	}
	int answer = 0;
	for(int i = 0; i < n; i++) {
		int n = home[i];
		answer += awayColours[n];
	}
	std::cout << answer;
	return 0;
}