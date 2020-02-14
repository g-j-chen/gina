#include <stdio.h>
#include <stdlib.h>

#define MAX_SIZE 1000

void bubblesort(int[], int);
void int_swap(int*, int*);

int main(int argc, char **argv) {
    printf("Enter as many as 1000 values, ^D to end\n");
    int A[MAX_SIZE];
    int B[MAX_SIZE];
    int num_A = 0;
    int num_B = 0;
    int next;
    while (scanf("%d", &next) == 1) {
        A[num_A] = next;
        num_A++;
        int found = 0;
        for (int i = 0; i < num_B; i++) {
            if (B[i] == next) {
                found = 1;
            }
        }
        if (!found) {
            B[num_B] = next;
            num_B++;
        }
    }
    bubblesort(A, num_A);
    printf("%d values read into array\n");
    printf("Before: ");
    for (int i = 0; i < num_A; i++) {
        printf("%d ", A[i]);
    }
    bubblesort(B, num_B);
    printf("\nAfter: ");
    for (int i = 0; i < num_B; i++) {
        printf("%d ", B[i]);
    }
    return 0;
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
