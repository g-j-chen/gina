#include <stdio.h>
#include <stdlib.h>
#include <limits.h>

#define MAX_SIZE 1000

void selection_sort(int[], int);
void int_swap(int*, int*);
void rec_selection_sort(int[], int);

int main(int argc, char **argv) {
    int A[MAX_SIZE], next;
    int i = 0;
    int n = 0;
    printf("Enter up to 1000 integers:\n");
    while (scanf("%d", &next) == 1) {
        A[i] = next;
        i++;
        n++;
    }
    printf("Before sorting:\n");
    for (int j = 0; j < n; j++) {
        printf("%d ", A[j]);
    }
    printf("\n");
    //selection_sort(A, n);
    rec_selection_sort(A, n);
    printf("After sorting:\n");
    for (int j = 0; j < n; j++) {
        printf("%d ", A[j]);
    }
    return 0;
}

void selection_sort(int A[], int n) {
    int end = n - 1;
    while (end >= 0) {
        int max = INT_MIN;
        int index = -1;
        for (int i = end; i >= 0; i--) {
            if (A[i] > max) {
                max = A[i];
                index = i;
            }
        }
        int_swap(&A[index], &A[end]);
        end--;
    }

}

void rec_selection_sort(int A[], int n) {
    if (n >= 0) {
        int max = A[n - 1];
        int index = n - 1;
        for (int i = n - 1; i >= 0; i--) {
            if (A[i] > max) {
                max = A[i];
                index = i;
            }
        }
        int_swap(&A[index], &A[n - 1]);
        rec_selection_sort(A, n - 1);
    }
}

void int_swap(int *x, int *y) {
    int t = *x;
    *x = *y;
    *y = t;
}
