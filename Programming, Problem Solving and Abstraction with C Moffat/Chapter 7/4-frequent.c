#include <stdio.h>
#include <stdlib.h>

#define MAX_SIZE 1000

void frequency(int[], int);
void bubblesort(int[], int);
void int_swap(int*, int*);

int main(int argc, char **argv) {
    printf("Enter as many as 1000 values, ^D to end\n");
    int n = 0;
    int next;
    int A[MAX_SIZE];
    while (scanf("%d", &next) == 1) {
        A[n] = next;
        n++;
    }
    frequency(A, n);
    return 0;
}

void frequency(int A[], int n) {
    bubblesort(A, n);
    printf("%d values read into array\n", n);
    printf("Value    Freq\n");
    int f = 1;
    int *p = &A[0];
    for (int i = 1; i < n; i++) {
        if (A[i] == *p) {
            f++;
        } else {
            printf("%4d    %4d\n", *p, f);
            f = 1;
            *p = A[i];
        }
    }
    printf("%4d    %4d\n", *p, f);
}

void bubblesort(int A[], int n) {
    int didswaps = 1;
    int i;
    while(didswaps) {
        didswaps = 0;
        for (i = 0; i < n - 1; i++) {
            if (A[i] > A[i + 1]) {
                int_swap(&A[i], &A[i + 1]);
                didswaps = 1;
            }
        }
    }
}

void int_swap(int *x, int *y) {
    int t = *x;
    *x = *y;
    *y = t;
}
