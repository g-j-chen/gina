#include <iostream>
#include <string>

int main() {
	int n;
	std::cin >> n;
	std::string seats[n];
	std::string row;
	bool foundSeats = false;
	for(int i = 0; i < n; i++) {
		std::cin >> row;
		if(!foundSeats) {
			if(row[0] == 'O' && row[1] == 'O') {
				foundSeats = true;
				row[0] = '+';
				row[1] = '+';
			} else if(row[3] == 'O' && row[4] == 'O') {
				foundSeats = true;
				row[3] = '+';
				row[4] = '+';
			}
		}
		seats[i] = row;
	}
	if(foundSeats) {
		std::cout << "YES" << '\n';
		for(std::string r : seats) {
			std::cout << r << '\n';
		}
	} else {
		std::cout << "NO";
	}
	return 0;
}