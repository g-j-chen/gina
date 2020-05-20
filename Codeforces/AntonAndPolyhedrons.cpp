#include <iostream>
#include <string>

int main() {
	int n;
	std::cin >> n;
	std::string s;
	int sides = 0;
	for(int i = 0; i < n; i++) {
		std::cin >> s;
		if(s == "Tetrahedron") {
			sides += 4;
		} else if(s == "Cube") {
			sides += 6;
		} else if(s == "Octahedron") {
			sides += 8;
		} else if(s == "Dodecahedron") {
			sides += 12;
		} else {
			sides += 20;
		}
	}
	std::cout << sides;
	return 0;
}