#include <iostream>
#include <string>
		
int main() {
	int t;
	std::cin >> t;
	for(int tc = 0; tc < t; tc++) {
		int n, a, b;
		std::cin >> n >> a >> b;
		std::string s = "";
		int j = 0;
		for(int i = 0; i < n; i++) {
			s += (char) (j + 'a');
			j++;
			j = j % b;
		}
		std::cout << s << '\n';
	}
	return 0;
}