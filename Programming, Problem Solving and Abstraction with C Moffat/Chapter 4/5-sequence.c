#include <stdio.h>
#include <stdlib.h>

int main() {
    int next;
    printf("Enter numbers: ");
    while (scanf("%d", &next) == 1) {
        printf("\n%3d |", next);
        for (int i = 0; i < next; i++) {
            printf("*");
        }
    }
    return 0;
}
