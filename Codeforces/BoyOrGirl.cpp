#include <iostream>
#include <string>
#include <set>

int main() {
	std::string name;
	std::cin >> name;
	std::set<char> set;
	for(char c : name) {
		set.insert(c);
	}
	if(set.size() % 2 == 0) {
		std::cout << "CHAT WITH HER!";
	} else {
		std::cout << "IGNORE HIM!";
	}
	return 0;
}