#include "table_tests.h"

using namespace std;

int main()
{
    HashTable* table = empty_table();
    printf("%s\n", table_to_string(table));
    insert_tests();
    search_tests();
    remove_tests();
    replace_tests();
    combo_tests();
}
