#include <stdio.h>
#include <stdlib.h>

#define MAX 100
#define YES 1
#define NO 0

struct record {
	char fname[16];
	char lname[21];
	char phone[10];
	long income;
	int month;
	int day;
	int year;
};

struct record list[MAX];

int last_entry = 0;

int main(void);
void get_data(void);
void display_report(void);
int continue_function(void);
void clear_kb(void);

int main( void )
{
	int cont = YES;
	int ch;

	while( cont == YES)
	{
		printf( "\n");
		printf( "\n	MENU");
		printf( "\n    ======\n");
		printf( "\n1.	Enter names");
		printf( "\n2. 	Print report");
		printf( "\n3.	Quit");
		printf( "\n\nEnter Selection ==> ");

		ch = getchar();

		fflush(stdin);

		switch( ch )
		{
			case '1':get_data();
				 break;
			case '2':display_report();
				 break;
			case '3':printf("\n\nThank you for using this program!\n");
				 cont = NO;
				 break;
			default: printf("\n\nInvalid choice, Please select 1 to 3!");
				 break;
		}
	}

	return 0;
}

void get_data(void)
{
	int cont;

	for( cont = YES; last_entry < MAX && cont ==YES; last_entry++ )
	{
		printf("\n\nEnter information for Person %d.", last_entry+1);

		printf("\n\nEnter first name: ");
		fgets(stdin, list[last_entry].fname);

		printf("\n\nEnter last name: ");
		fgets(stdin, list[last_entry].lname);

		printf("\nEnter phone in 123-4567 format: ");
		fgets(stdin, list[last_entry].phone);

		printf("\nEnter Yearly Income (whole dollars): ");
		scanf("%ld", &list[last_entry].income);

		printf("\nEnter Birthday: ");

		do
		{
			printf("\n\tMonth (0 - 12): ");
			scanf("%d", &list[last_entry].month);
		}while ( list[last_entry].month < 0 || list[last_entry].month > 12);

		do
		{
			printf("\n\tDay (0-31): ");
			scanf("%d", &list[last_entry].day);
		}while ( list[last_entry].day < 0 || list[last_entry].day > 31);

		do
		{
			printf("\n\tYear (1800 - 2020): ");
			scanf("%d", &list[last_entry].year);
		}while ( list[last_entry].year != 0 && 
				(list[last_entry].year < 1800 || list[last_entry].year > 2020));

	cont = continue_function();
	}

		
if( last_entry == MAX)
	printf("\n\nMaximum Number of Names has been entered!\n");

}

void display_report()
{
	long month_total = 0, grand_total = 0;
	int x,y;

	fprintf(stdout, "\n\n");
	fprintf(stdout, "\n		REPORT");
	fprintf(stdout, "\n	       ========");

for( x = 0; x <= 12; x++)
{
	month_total = 0;
	for( y = 0; y < last_entry; y++)
	{
		if( list[y].month == x )
		{
			fprintf(stdout, "\n\t%s %s %s %ld", list[y].fname,
				list[y].lname, list[y].phone,list[y].income);
		month_total += list[y].income;
		}
	}
fprintf(stdout, "\nTotal for month %d is %ld",x,month_total);
grand_total += month_total;
}
fprintf(stdout, "\n\nReport totals:");
fprintf(stdout, "\nTotal Income is %ld", grand_total);
fprintf(stdout, "\nAverage Income is %ld", grand_total/last_entry);

fprintf(stdout, "\n\n* * * End of Report * * *");
}

int continue_function( void )
{
	int ch;

	printf("\n\nDo you wish to continue? Y(es)/N(o): ");

	fflush(stdin);
	ch = getchar();

	while( ch != 'n' && ch != 'N' && ch != 'y' && ch!= 'Y' )
	{
		printf("\n%C is invalid!", ch);
		printf("\n\nPlease enter \'N\' to Quit or \'Y\' to Continue: ");

		fflush(stdin);
		ch = getchar();
	}

	clear_kb();

	if(ch == 'n' || ch == 'N')
		return (NO);
	else
		return (YES);
}

void clear_kb(void)
{
	char junk[80];
	fgets(stdin, junk);
}

