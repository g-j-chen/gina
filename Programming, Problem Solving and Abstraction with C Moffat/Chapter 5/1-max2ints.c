#include <stdio.h>
#include <stdlib.h>

int max_2_ints(int, int);

int main() {
    int a, b;
    printf("Enter 2 integers: ");
    scanf("%d %d", &a, &b);
    printf("The max of those 2 numbers is %d", max_2_ints(a, b));
    return 0;
}

int max_2_ints(int a, int b) {
    if (a >= b) {
        return a;
    } else {
        return b;
    }
}
