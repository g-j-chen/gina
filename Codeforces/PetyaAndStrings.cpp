#include <iostream>
#include <string>

int main() {
	std::string a, b;
	std::cin >> a >> b;
	int answer = 0;

	for(int i = 0; i < a.length(); i++) {
		char aChar = tolower(a[i]);
		char bChar = tolower(b[i]);
		if(aChar < bChar) {
			answer = -1;
			break;
		} else if(aChar > bChar) {
			answer = 1;
			break;
		}
	}

	std::cout << answer;
	
	return 0;
}