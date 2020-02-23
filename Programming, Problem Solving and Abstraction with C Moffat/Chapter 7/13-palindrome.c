#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int is_palindrome(char*);

int main(int argc, char **argv) {
    char *s = "rats live on no evil star";
    int boolean = is_palindrome(s);
    printf("%d\n", boolean);
    if(boolean) {
        printf("This string is a palindrome!\n");
    } else {
        printf("This is not a palindrome...\n");
    }
}

int is_palindrome(char *s) {
    int len = strlen(s);
    char *end = s + len - 1;
    for(int i = 0; i < len / 2; i++) {
        if(*s == *end) {
            end--;
            s++;
        } else {
            return 0;
        }
    }
    return 1;
}
