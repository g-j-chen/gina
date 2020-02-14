#include <stdio.h>
#include <stdlib.h>

#define MAX_SIZE 1000

void order_marks(int[], int[], int);
void int_swap(int*, int*);

int main(int argc, char **argv) {
    int students[MAX_SIZE], marks[MAX_SIZE], s, m;
    int i = 0;
    int n = 0;
    printf("Enter student number followed by mark:\n");
    while (scanf("%d %d", &s, &m) == 2) {
        students[i] = s;
        marks[i] = m;
        i++;
        n++;
    }
    order_marks(students, marks, n);

    for (int j = 0; j < n; j++) {
        printf("%d  %d\n", students[j], marks[j]);
    }
    return 0;
}

void order_marks(int students[], int marks[], int n) {
    int didswaps = 1;
    int i;
    while(didswaps) {
        didswaps = 0;
        for (i = 0; i < n - 1; i++) {
            if (students[i] > students[i + 1]) {
                int_swap(&students[i], &students[i + 1]);
                int_swap(&marks[i], &marks[i + 1]);
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
