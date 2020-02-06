#include <stdio.h>
#include <stdlib.h>

int int_pow(int, int);

int main() {
    int a, p;
    printf("Enter an integer: ");
    scanf("%d", &a);
    printf("Enter a positive power to raise integer to: ");
    scanf("%d", &p);
    printf("Result is %d", int_pow(a, p));
    return 0;
}

int int_pow(int a, int p) {
    if (p == 0) {
        return 1;
    }

    if (p == 1) {
        return a;
    }

    int r = a;
    for (int i = 2; i <= p; i++) {
        r *= a;
    }
    return r;
}
