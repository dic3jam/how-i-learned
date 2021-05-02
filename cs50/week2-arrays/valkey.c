

int valkey(string key)
{

    //test string string key = "AbCDeFGHIJKBMNOPQRSTUVWXYZ";

    //evalutate key length

    if(strlen(key) != 26)
        {
        printf("not correct length %lu\n", strlen(key));
        return(0);
        }

    //evaluate for non-letters

     for(int i = 0; i < 26; i++)
           {
               if ( !(isalpha(key[i])) )
                 {
                printf("non letter present\n");
                return(0);
                }
           }

    //evaluate for repeated characters

    for(int letter = 97; letter < 123; letter++)
        {
           int repeat = 0;

           for(int i = 0; i < 26; i++)
           {
               if( tolower(key[i]) == letter )
               repeat++;
           }

           if ( repeat > 1)
           {
            printf("multiple use of same character\n");
           return(0);
           }

        }//end repeated characters loop

    return 1;

}//end valkey









