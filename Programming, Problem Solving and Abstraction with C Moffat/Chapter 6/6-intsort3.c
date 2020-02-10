#include <stdio.h>
#include <stdlib.h>

void int_sort3(int*, int*, int*);
void int_sort2(int*, int*);

int main(int agrc, char **argv) {
    int a, b, c;
    printf("Enter in 3 integers: ");
    scanf("%d %d %d", &a, &b, &c);
    int_sort3(&a, &b, &c);
    printf("After sorting:\na = %d\nb = %d\nc = %d", a, b, c);
    return 0;
}

void int_sort3(int *ap, int *bp, int *cp) {
    int_sort2(ap, bp);
    int_sort2(bp, cp);
    int_sort2(ap, bp);
}

void int_sort2(int *ap, int *bp) {
    if (*ap > *bp) {
        int t = *ap;
    *ap = *bp;
    *bp = t;
    }
}
