#include <iostream>
#include <algorithm>

int main() {
	int k;
	int months[12];
	std::cin >> k;

	for (int i = 0; i < 12; ++i)
	{
		std::cin >> months[i];
	}

	std::sort(months, months + 12, std::greater<int>());
	int answer = 0;
	int growth = 0;
	for(int i = 0; i < 12; i++) {
		if(growth >= k) {
			break;
		} else {
			growth += months[i];
			answer++;
		}
	}

	if(growth < k) {
		std::cout << -1;
	} else {
		std::cout << answer;
	}
	return 0;
}