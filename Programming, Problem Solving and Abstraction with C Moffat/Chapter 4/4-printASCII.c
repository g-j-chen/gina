#include <stdio.h>

int main() {
    for (int i = 0; i < 8; i++) {
        if (i == 0) {
            printf("     ");
        }
        printf("  +%d", i);
    }
    printf("\n    +--------------------------------");
    for (int i = 32; i < 127; i++) {
        if (i % 8 == 0) {
            printf("\n%3d |", i);
        }
        printf("%4c", i);
    }
    return 0;
}
