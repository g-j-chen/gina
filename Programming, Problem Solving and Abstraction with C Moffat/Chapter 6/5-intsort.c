#include <stdio.h>
#include <stdlib.h>

void int_sort2(int*, int*);

int main(int argc, char **argv) {
    int a, b;
    printf("Enter 2 numbers: ");
    scanf("%d %d", &a, &b);
    printf("a = %d\nb = %d\n", a, b);
    int_sort2(&a, &b);
    printf("After sorting:\na = %d\nb = %d", a, b);
    return 0;
}

void int_sort2(int *ap, int *bp) {
    int a = *ap;
    int b = *bp;
    if (a > b) {
        *ap = b;
        *bp = a;
    }
}
