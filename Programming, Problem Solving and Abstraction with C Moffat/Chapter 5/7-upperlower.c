#include <stdio.h>
#include <stdlib.h>
#include <ctype.h>

int my_isupper(int);
int my_tolower(int);

int main() {
    char c = 'C';
    printf("Character is %c\n", c);
    printf("Testing my_isupper() against ctype.h's isupper():\n");
    if (my_isupper(c) == isupper(c)) {
        printf("Results match!\n");
    } else {
        printf("Something went wrong :(\n");
    }
    printf("\n");
    printf("Character is %c\n", c);
    printf("Testing my_tolower() against ctype.h's tolower():\n");
    if (my_tolower(c) == tolower(c)) {
        printf("Results match!\n");
    } else {
        printf("Something went wrong :(\n");
    }
    return 0;
}

int my_isupper(int c) {
    if (c >= 65 && c <= 90) {
        return 1;
    }
    return 0;
}

int my_tolower(int c) {
    if (c >= 65 && c <= 90) {
        return c + 32;
    }
    return c;
}
