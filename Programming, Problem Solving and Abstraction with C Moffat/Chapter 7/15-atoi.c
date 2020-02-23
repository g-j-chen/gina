#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int my_atoi(char *s) {
    int len;
    for(len = 0; s[len] >= '0' && s[len] <= '9'; len++);

    int i, j, multiplier, my_int = 0;
    for(i = 0; s[i] >= '0' && s[i] <= '9'; i++) {
        multiplier = 1;
        for(j = 1; j < len - i; j++) {
            multiplier *= 10;
        }
        my_int += multiplier * (s[i] - '0');
        printf("int so far: %d\n", my_int);
    }
    return my_int;
}

int main(int argc, char **argv) {
    char n[100];
    int i = 0;
    char c;
    printf("Enter number: ");
    while(scanf("%c", &c) == 1) {
        if(c == '\n') {
            break;
        }
        n[i] = c;
        i++;
    }
    n[i] = '\0';
    printf("My atoi: %d\n", my_atoi(n));
    printf("Built in atoi: %d\n", atoi(n));


    return 0;
}
