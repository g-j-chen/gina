#include <array>
#include <iostream>
#include <experimental/string_view>
#include <tuple>
#include <type_traits>
#include <string>
 
 
int main()
{
	std::cout << "Enter a number: "; // ask user for a number
    int x{ }; // define variable x to hold user input (and zero-initialize it)
    std::cin >> x; // get number from keyboard and store it in variable x
    std::cout << "You entered " << x << '\n';
    return 0;
}



//-Wall -Weffc++ -Wextra -Wsign-conversion -Werror -pedantic-errors -std=c++17