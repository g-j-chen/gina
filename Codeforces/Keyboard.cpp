#include <iostream>
#include <string>

int main() {
	std::string shift, message;
	std::cin >> shift >> message;
	std::string a = "qwertyuiop";
	std::string b = "asdfghjkl;";
	std::string c = "zxcvbnm,./";
	std::string answer = "";
	int ind = (shift == "R") ? -1 : 1;
	for(char ch : message) {
		int n = a.find(ch);
		if(n != std::string::npos) {
			answer += a[n + ind];
			continue;
		}
		int m = b.find(ch);
		if(m != std::string::npos) {
			answer += b[m + ind];
			continue;
		}
		int o = c.find(ch);
		if(o != std::string::npos) {
			answer += c[o + ind];
		}
	}
	std::cout << answer;
	return 0;
}