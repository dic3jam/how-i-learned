#CS50 Week 7 SQL

def f(item):
	return item[1]

for title, count in sorted(counts.items(), key=f, reverse=True):
	print(title, count, sep = " | ")

.items() returns key and value

will print the key with value right next to it each on own line, sorted by the value of the counts

f(item) is returning the second part of the counts.items() so in this case the value of the key

can also use **lambda**:

	... , key=lambda item: item[1],

lambda give me a function (never going to use again)
"item" input to this function
: item[1] return value
limited to 1 line

**sqlite3**

can create new database or open existing at CLI -> sqlite3 favorites.db
.mode csv
.import "file"
.schema

select title, count(title) from favorites group by favorites

limit 10 - limits to first 10

**relational database** - store data and provide fast access with SQl

sqlite3 is a CLI program

Create
Read
Update
Delete
**
Most frequently used:
insert

select

update 

delete	

**Create**
create table "table" (column type, ....);

SQL 5 main data types

integer- smallint, integer, bigint

real(decimal) - real, double precision

numeric - boolean, date, datetime, numeric(can specify decimal places), time, timestamp

text - char(number), varchar(upper and lower bound number), text

blob - binary large object - store binary data represent files in binary format

functions:
avg
count
distinct
max
min

where at end of query
like
limit
group by
order by
join

select title from favories where title like "%the office%";

% is wildcard

to get count of that:

select count(title) from ....

update favories set title = "The Office" where title like "%office%"

delete from table where condition;

to delete table drop 'table'




**import.py** - importing .tsv file into a sqlite db

open("shows3.db", "w").close()   	#like touching a file

db = cs50.SQL("sqlite:///shows3.db")

db.execute("create table shows (tconst text, primarytitle text, startyear, genres")		#db.execute allows you to execute sql in open db file

db = cs50.SQL("sqlite:///shows3.db")

with open("titles.basics.tsv", "r") as titles:

	reader = csv.DictReader(titles, delimiter="\t")

	for row in reader:
		
		if row["titleType"] == "tvSeries" and row ["isAdult"] == "0":
		blahblah

		db.execute("insert into shows (tconst, primarytitle, startyear, genres) values(?,?,?,?)", tconst, primarytitle, startyear, genres)	

**Joins**

separate table unique id based on table it came from

**join** - 

select * from shows join genres on shows.id = genres.show_id where...

subquery

select * from stars where person_id = (select id from people where name = "Ellen DeGeneres")

select title from people join on people.id = stars.person_id join shows on stars.show_id = shows.id where name = "Ellen DeGeneres"

primary key 
foreign key
unique
index

create index show_index on stars(show_id);

indexes are tree like structures for faster searching

##Shorts - SQL

char - fixed length string

varchar - variable length string up to the specified amount

SQLITE groups all the data types into 5 affinities (has all but these are most common)
-null
-integer
-real
-text
-blob

-insert
-select
-update
-delete

insert into 'table' ('columns','columns') values ('value1','value2')

primary key: auto-increment

update 'table' set 'column' = 'value' where 'predicate'

delete from 'table' where 'predicate'



















