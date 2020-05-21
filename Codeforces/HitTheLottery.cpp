#include <iostream>

int main() {
	int n;
	std::cin >> n;
	int count = 0;
	int bills[] = {100, 20, 10, 5, 1};
	for(int i = 0; i < sizeof(bills)/sizeof(bills[0]); i++) {
		count += n/bills[i];
		n = n % bills[i];
	}
	std::cout << count;
	return 0;
}