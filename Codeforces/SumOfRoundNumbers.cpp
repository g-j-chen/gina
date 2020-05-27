#include <iostream>
#include <vector>

int main() {
	int t, n;
	std::cin >> t;
	for(int i = 0; i < t; i++) {
		std::cin >> n;
		std::vector<int> ans;
		int power = 1;
		while(n > 0) {
			if(n % 10 != 0) {
				ans.push_back((n % 10) * power);
			}
			power *= 10;
			n /= 10;
		}
		std::cout << ans.size() << '\n';
		for(auto num : ans) std::cout << num << " ";
		std::cout << '\n';
	}
	return 0;
}