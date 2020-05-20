#include <iostream>
#include <string>

int main() {
	std::string s;
	std::cin >> s;
	if(s.length() == 1) {
		std::cout << s;
		return 0;
	}

	int count[3] = { };
	for(char& c : s) {
		if(c == '1') {
			count[0]++;
		} else if(c == '2') {
			count[1]++;
		} else if(c == '3') {
			count[2]++;
		}
	}

	std::string answer = "";
	bool start = true;
	for(int i = 0; i < 3; i++) {
		while(count[i] > 0) {
			if(start) {
				answer.append(std::to_string(i + 1));
				start = false;
			} else {
				answer.append("+" + std::to_string(i + 1));
			}			
			count[i]--;
		}
	}
	std::cout << answer;
	return 0;
}