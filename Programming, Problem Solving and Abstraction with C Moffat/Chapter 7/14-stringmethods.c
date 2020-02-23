#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int mystrlen(char *s) {
    int len = 0;
    int i = 0;
    while(s[i] != '\0') {
        len++;
        i++;
    }
    return len;
}

char *mystrcat(char *to, char *from) {
    int to_len = mystrlen(to);
    int i = 0;
    while(from[i] != '\0') {
        to[to_len + i] = from[i];
        i++;
    }
    to[to_len + i] = '\0';
    return to;
}

int main(int argc, char **argv) {
    char s[100], from[100], cp[100];
    printf("Enter a string: ");
    scanf("%s", s);
    printf("My method: string length is %d\n", mystrlen(s));
    printf("Built in string length is %d\n", strlen(s));

    printf("Enter another string: ");
    scanf("%s", from);

    strcpy(cp, s);
    printf("My method adding 2nd string to 1st one: %s\n", mystrcat(s, from));
    printf("Built in adding 2nd string: %s\n", strcat(cp, from));
    return 0;
}
