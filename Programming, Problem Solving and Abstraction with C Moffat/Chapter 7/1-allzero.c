#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int all_zero(int[], int);

int main(int argc, char **argv) {
    int n = 10;
    int A[] = {5, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    int b = all_zero(A, n);
    printf("%s", b ? "true" : "false");
}

int all_zero(int A[], int n) {
    int i;
    for (i = 0; i < n; i++) {
        if (A[i] != 0) {
            return 0;
        }
    }
    return 1;
}
