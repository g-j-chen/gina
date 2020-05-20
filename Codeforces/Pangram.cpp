#include <iostream>
#include <string>
#include <set>

int main() {
	int n;
	std::cin >> n;
	std::string s;
	std::cin >> s;
	std::set<char> set;
	for(int i = 0; i < n; i++) {
		set.insert(tolower(s[i]));
	}
	if(set.size() >= 26) {
		std::cout << "YES";
	} else {
		std::cout << "NO";
	}
	return 0;
}