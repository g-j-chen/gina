#include <stdio.h>
#include <stdlib.h>

void int_divide(int, int, int*, int*);

int main(int argc, char **argv) {
    int n, d, q, r;
    q = r = 0;
    int *qp = &q;
    int *rp = &r;
    printf("Enter a numerator: ");
    scanf("%d", &n);
    printf("Enter a denominator: ");
    scanf("%d", &d);
    int_divide(n, d, qp, rp);
    printf("%d / %d is %d remainder %d", n, d, *qp, *rp);
    return 0;
}

void int_divide(int numerator, int denominator, int *quotient, int *remainder) {
    *quotient = numerator / denominator;
    *remainder = numerator % denominator;
}
