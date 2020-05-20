#include <iostream>
#include <set>

int main() {
	int a, b, c, d;
	std::cin >> a >> b >> c >> d;
	std::set<int> s;
	s.insert(a);
	s.insert(b);
	s.insert(c);
	s.insert(d);
	std::cout << 4 - s.size();

	return 0;
}