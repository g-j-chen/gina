#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int is_anagram(char *a, char *b) {
    /*
    if(strlen(a) != strlen(b)) {
        return 0;
    }
    */
    int array[26] = {0};
    int i = 0;
    char c;
    int n;
    while(a[i] != '\0') {
        c = tolower(a[i]);
        n = c - 'a';
        if(n < 0) {
            i++;
            continue;
        }
        array[n]++;
        i++;
    }

    printf("\n");
    i = 0;
    while(b[i] != '\0') {
        c = tolower(b[i]);
        n = c - 'a';
        if(n < 0) {
            i++;
            continue;
        }
        array[n]--;
        if(array[n] < 0) {
            return 0;
        }
        i++;
    }

    for(i = 0; i < 26; i++) {
        if(array[i] != 0) {
            return 0;
        }
    }

    return 1;
}

int main(int argc, char **argv) {
    printf("Enter a word: ");
    char a[100];
    fgets(&a, 100, stdin);
    printf("Enter another word: ");
    char b[100];
    fgets(&b, 100, stdin);
    if(is_anagram(a, b)) {
        printf("The 2 words are anagrams!\n");
    } else {
        printf("They are not anagrams.\n");
    }

    return 0;
}
