#include <iostream>
#include <string>
#include <set>

int main() {
	std::string s;
	std::getline(std::cin, s);
	std::set<char> set;
	for(int i = 1; i < s.length() - 1; i++) {
		if(isalpha(s[i])) {
			set.insert(s[i]);
		}
	}
	std::cout << set.size();
	return 0;
}