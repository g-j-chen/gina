#include <stdio.h>

int main() {
    int day = 3;
    int numSpores;
    int prevDay = 1;
    int prevPrevDay = 1;

    printf("Number of spores on day 1 is 1\nNumber of spores on day 2 is 1\n");

    while (numSpores < 10000000) {
        numSpores = prevDay + prevPrevDay;
        printf("Number of spores on day %d is %d\n", day, numSpores);
        prevPrevDay = prevDay;
        prevDay = numSpores;
        day++;
    }
    return 0;
}
