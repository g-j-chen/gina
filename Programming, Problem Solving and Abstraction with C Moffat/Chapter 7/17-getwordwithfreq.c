#include <stdio.h>
#include <string.h>
#include <ctype.h>

#define MAXCHARS 10
#define MAXWORDS 100

typedef char word_t[MAXCHARS + 1];

int getword(char *W, int limit) {
    int c;
    while((c=getchar()) != EOF && !isalpha(c)) {

    }
    if(c == EOF) {
        return EOF;
    }
    *W = c;
    W += 1;
    limit -= 1;
    while(limit != 0 && (c=getchar()) != EOF && isalpha(c)) {
        *W = c;
        W += 1;
        limit -=1;
    }
    *W = '\0';
    return 0;
}

int main(int argc, char **argv) {
    word_t one_word, all_words[MAXWORDS];
    int numdistinct = 0, totwords = 0, i, found;
    int freq[MAXWORDS];
    while(getword(one_word, MAXCHARS) != EOF) {
        totwords += 1;
        found = 0;
        for(i = 0; i < numdistinct && !found; i++) {
            found = (strcmp(one_word, all_words[i]) == 0);
            if(found) {
                freq[i]++;
            }
        }
        if(!found && numdistinct < MAXWORDS) {
            strcpy(all_words[numdistinct], one_word);
            freq[numdistinct] = 1;
            numdistinct += 1;
        }
    }
    printf("%d words read\n", totwords);
    for(i = 0; i < numdistinct; i++) {
        printf("word #%d is \"%s\" and appears %d times\n", i, all_words[i], freq[i]);
    }
    return 0;
}

