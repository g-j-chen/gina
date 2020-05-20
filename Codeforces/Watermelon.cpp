#include <iostream>

 
int main()
{
	int w;
	std::cin >> w;
	if(w % 2 != 0) {
		std::cout << "NO";
	} else {
		int i;
		bool found = false;
		for(i = 2; i <= w / 2; i+=2) {
			if((w - i) % 2 == 0) {
				std::cout << "YES";
				found = true;
				break;
			}
		}
		if(!found) {
			std::cout << "NO";
		}
	}
    return 0;
}