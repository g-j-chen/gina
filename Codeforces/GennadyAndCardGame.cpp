#include <iostream>
#include <string>
#include <set>

int main() {
	std::string table;
	std::cin >> table;
	std::set<char> set;
	std::string hand;
	for(int i = 0; i < 5; i++) {
		std::cin >> hand;
		set.insert(hand[0]);
		set.insert(hand[1]);
	}
	auto sRank = set.find(table[0]);
	auto sSuit = set.find(table[1]);
	if(sRank!= set.end() || sSuit != set.end()) {
		std::cout << "YES";
	} else {
		std::cout << "NO";
	}
	return 0;
}