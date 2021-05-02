#include <stdio.h>
#include <cs50.h>
#include <string.h>
#include <ctype.h>


int main(void)
{
//receive the string
     
    string input = get_string("Please input the text: ");
    int word = 0, letter = 0, sentence = 0;

    for(int i = 0; i < strlen(input); i++)
    {
        if( isalpha(input[i-1]) && (isblank(input[i]) || ispunct(input[i])) )
            word++;
        else if( isalpha(input[i]) )
            letter++;
        else if( ispunct(input[i-1]) || ispunct(input[i]) )
            sentence++;
        //else
            //printf("Did not read %c", input[i]);

       // printf("%c, word: %d, letter: %d, sentence: %d\n", input[i], word, letter, sentence);
    }//end loop

//set the variables to the correct condition for the algorithim

	word = word/100;

	letter = letter/word;

	sentence = sentence/word;

//Apply the algorithim

	int index = 0.0588 * letter - 0.296 * sentence - 15.8;

//Print the results

	if (index > 16)
		printf("Grade 16+\n");
	else if (index < 1)
		printf("Before Grade 1\n");
	else
		printf("Grade %d\n", index);	

}//end main


















