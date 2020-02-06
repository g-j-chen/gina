#include <stdio.h>
#include <stdlib.h>

int max_4_ints(int, int, int, int);
int max_2_ints(int, int);

int main() {
    int a, b, c, d;
    printf("Enter 4 integers: ");
    scanf("%d %d %d %d", &a, &b, &c, &d);
    printf("The max of those 4 numbers is %d", max_4_ints(a, b, c, d));
    return 0;
}

int max_4_ints(int a, int b, int c, int d) {
    int max_a_b = max_2_ints(a, b);
    int max_c_d = max_2_ints(c, d);
    return max_2_ints(max_a_b, max_c_d);
}


int max_2_ints(int a, int b) {
    if (a >= b) {
        return a;
    } else {
        return b;
    }
}
