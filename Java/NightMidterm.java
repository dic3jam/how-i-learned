/* CIS2271
 * Midterm
 * @author Jim DiCesare
 * 
 * Welcome to Night of the Midterm: a horrifying tale of one Java student's night of survival.
 * This is a text based mini-game written in Java that demonstrates some of the basics of the language.
 * It is contained in one class, it has a main menu, an opening sequence, 2 rooms with challenges, and a
 * closing sequence.
 * Failure will loop you back to the main menu. Which just consists of the option to play or terminate the
 * program.
 * Enjoy!
 */

import java.util.*;
import java.lang.*;
import java.util.concurrent.TimeUnit;

public class NightMidterm {

static int text = 5; //made the time text appears adjustable so I could debug easier
static int success = 1; //the main variable for program control

static Scanner sc = new Scanner(System.in); //the primary scanner

public static void main(String[] args) {
		
System.out.println("|-.  -| |   ---  | \\| (-) -- -| |-- | |-    ---  / -| | |-| |-- ---     ");
System.out.println("|.| | '-\\ / -\\ |  \\ | |/ -` | '- \\ --|  / - \\ |-  | --| '- \\/ - \\ ");
System.out.println("|.| | | | |  --/ | |\\ | | (-| | | | | |-  | (-) |  -| | |-| | | |  --/  "); 
System.out.println("|-|.|-| |-\\---| |-| \\|-\\--, |-| |-\\--| \\---/|-|   \\--|-| |-\\---|  ");
System.out.println(".                          |---/                                         ");
System.out.println("--. -- -     - -                                                         ");
System.out.println("|.\\/  (-) --| | |- --- - -- - -- ---                                    ");
System.out.println("|.\\/| | |/ -` | --/ -\\ '--| '- ` - \\                                  ");
System.out.println("|.|  | | | (-| | ||  --/ |  | | | | | |                                  ");
System.out.println("|-|. |-|-\\--,-\\-\\---|-|  |-| |-| |-|                                  ");
//good idea fairy but I did not want to sink the more than 30 minutes it took to get it to this point

	do  //I just have it continuously loop so you always get asked to exit before exiting.
	{
		
	mainMenu(); //always come back to here

	bedroom(); //The first room is just a story comment out if in a hurry
	
	success = hallway(); //1st challenge room. If you fail you go back to the main menu
	if (success != 1)
		continue;
	
	success = kitchen(); //if you beat hallway, then you move onto here. Failure returns you to the main menu
	if (success != 1)
		continue;
		
	backyard(); //just the closing scene. can be commented out if in a hurry
	
	} while(true);

}//end main

public static void mainMenu() //I found it easier to encapsulate the main menu than type it into main
{
	System.out.println("\nWelcome to The Night of the Midterm Please Choose an Option below: ");
	System.out.printf("Option 1: Start a new game\nOption 2: Exit\n\nPlease input your choice: "); 
	success = sc.nextInt();
	if (success != 1)
	{
		sc.close();
		System.exit(0);
	}
	else
	{
		System.out.println("Choose your text speed. 3- Fast. 5- Medium. 7-Slow: ");
		text = sc.nextInt();
	}

}//end mainMenu

public static void bedroom() //First room just story text 
{
	System.out.println("It is a dark and stormy night, the wind howls at the apple\ntree now rasping my window with the sound of nails on a chalkboard\n");
	delay(text);
	System.out.println("Sleeping on top of my computer with my screen open to \nmy nowhere-near-done CIS2271 Java Midterm, a puddle of drool pools on my trackpad\n");
	delay(text);
	System.out.println("Sleeping peacefully on the bed, my faithful(?) scroungy \nhound Willy snoozes despite the lightning and hellish wind.\n");
	delay(text);
	System.out.println("Suddenly screeches and crashes can be heard downstairs, \nthe house is bathed in a red light before it washes away.\n A hex symbol appears on the bedroom door\n");
	delay(text);
	System.out.println("Willy, who jumps up in fright, begins to bark, but instead says in \nEnglish \"Whoa whoa whoa go away I am sleeping!\". \nPuzzled even to himself as to how he suddenly gained the power to speak, Willy realizes he has to pee.\n");
	delay(text);
	System.out.println("Willy hops off the bed and begins to poke me gently with his paw\n \"Hey Jim get up I have to pee. You gotta let me out or I will pee all over the house\"\n");
	delay(text);
	System.out.println("I feel the pawing at my shoulder, and rouse from my demonic \nsleep in the groggiest of fogs to see Willy standing by my desk\n");
	delay(text);
	System.out.println("Willy speaks again \"Hey Jim so uh there is definitely something very\n hellish going on downstairs\n now normally I would say (not that I normally say anything) \nlet's sit this one out, but you're going to have to face the demons\n because I need to be let out and if you don't I will pee all over the house.\n");
	delay(text);
	System.out.println("\"Willy you're talking!?!\" I blurt out in astonishment. \n\"What the hell is going on here?\".\n");
	delay(text);
	System.out.println("\"I think that's the problem Jim... hell is in the house.\n I suspect that something to do with the strange noises downstairs\n and the hex symbol on the door... and could explain why I am talking\"\n");
	delay(text);
	System.out.println("I stammer \"So I mean shoot I don't want to go out there, \nthis program was written by guy who has terrible humor,\n are you really going to pee all over the house?\"\n");
	delay(text);
	System.out.println("\"Yes. Now I am going to open the door are you ready for the first demon?\"\n");
	delay(text);
	System.out.println("Fearing the wrath of my wife when Willy pees on the carpet \nmore than the powers of hell,\n I step past my scroungy hound and open the door to the hallway\n\n");
	delay(text);
}//end bedroom

public static int hallway() //face the demon Karen and her multiple choice riddle.
{
	System.out.println("ROOM 1 THE HALLWAY\n");
	delay(2);
	System.out.println("I open the door to hallway and am immediately greeted to\n the smell of pumpkin Yankee Candle\n hex symbols are all over the walls, \nand very low in the background Taylor Swift is playing.\n");
	delay(text);
	System.out.println("Willy turns to me \"Hey so uh I do not think these demons are \nwhat we were thinking. I think this one is a just a straight stereotype.\"\n");
	delay(text);
	System.out.println("Suddenly a woman steps from around the corner, \nher eyes are glowing but she is wearing Lululemon tights and carrying a Starbucks coffee.\n");
	delay(text);
	System.out.println("\"Who dares challenge me!\" says the woman \n\"I am the mighty demon Karen! If you challenge me you must solve my riddle!\n");
	delay(text);
	System.out.println("Ok let's be real that is pretty funny.\n A demon named Karen? I can't help but chuckle a little bit.\n");
	delay(text);
	System.out.println("\"How dare you laugh at me! Now I will make the riddle that much harder!\"\n");
	delay(text);
	System.out.println("Willy says \"Hey man you wanna give it a rest? \nI would like to not pee on the floor.\"\n");
	delay(text);
	System.out.println("\"Willy chill I got this. Ok Karen I accept you challenge.\" I reply.\n");
	delay(text);
	System.out.println("Karen starts her challenge \"I am tall when I am young, and I am short when I am old. What am I?\"\n");
	delay(text);
	System.out.println("Option 1: A dog\nOption 2: A person\nOption 3: A candle\nOption 4: A lamp\n\n Please input the number of your answer: ");
	
	int answer = sc.nextInt();
			
	if ( answer == 3 )
	{
		success = 1;
		System.out.println("\"Darn you have chosen correctly. My curse is lifted from this room, and you may pass.\"\nHallway Complete!\n\n");
		delay(text);
	}
	else
	{
		success = 0;
		System.out.println("\"You have chosen incorrectly and you are doomed!\"\n");
		delay(text);
		System.out.println("*Willy pees on floor*\n");
		delay(3);
	}
	
	if(success == 0)
	{
		System.out.println("GAME OVER");
		delay(2);
		System.out.println("Would you like to continue? 1 - yes. 2- no: ");
		int cont = sc.nextInt();
		if (cont == 1)
			success = hallway();
	}
	return success;
}//end hallway

public static int kitchen() //face the demon Keanu Reaves but don't worry he's not here to shoot you.
{
	Random gen = new Random();
	
	System.out.println("ROOM 2 THE KITCHEN\n\n");
	delay(3);
	System.out.println("After defeating Karen, Willy and I wondered what could be next.\nBravely we continued on down the stairs.\n");
	delay(text);
	System.out.println("Luckily the kitchen was right there so the programmer does\n not need to create more rooms.\n");
	delay(text);
	System.out.println("We entered the kitchen to find the counter covered in all different kinds of guns.\nTHe windows were scrolling glyphs like in the matrix\n and AC/DC played softly in the background.\n");
	delay(text);
	System.out.println("A figure dressed entirely in black and sitting in shadow is sitting at the kitchen table\n tossing a knife into the air and catching it perfectly everytime.\nThe knife blade menacingly catches the moon light with each flip,\n We stop dead in our tracks.\n");
	delay(text);
	System.out.println("Willy burps. \"Oh sorry I burp when I am nervous. So who are you supposed to be?\"\n");
	delay(text);
	System.out.println("\"Willy isn't it obvious?\" I chime in. \"That's Keanu Reaves!\nOh my god are you going to shoot us?\"\n");
	delay(text);
	System.out.println("The Boogeyman himself stabs the knife into the table, \nand rises into the light with his hands raised.\n \"Whoa easy gents I won't shoot you if you can guess what number I am thinking.\n");
	delay(text);
	System.out.println("Willy says \"That's the challenge? Oh god I really am going to pee on the floor\nsorry Jim.\n");
	delay(text);
	System.out.println("Keanu continues \"I am thinking of a number between 1 and 10.\nGuess correctly and I will lift my curse\"\n");
	delay(text);
	
	int keanu = gen.nextInt(10);
	
	System.out.println("Please input your guess: ");
	
	int guess = sc.nextInt();
	
    System.out.println("\"I guess " + guess + ". I state with confidence\"\n"); //My concatenated string
    delay(text);
    
    if ( guess == keanu )
    	System.out.printf("\"Wow I was thinking of %d... Well uh I forgot to\n mention there is more to the challenge.\"\n", keanu);
    else
    	System.out.println("\"Sorry man that's incorrect but good thing that's \nnot the real challenge or else I would go John Wick on you.\"\n");
	delay(text);
    
    System.out.println("Keanue continued \"Ya know what is better than guessing numbers \n and my favorite thing in the world?\"\n");
    delay(text);
    System.out.println("Willy can't help himself \"Oh oh is it dogs Mr. Keanu? I saw John Wick 1\"\n");
    delay(text);
    System.out.println("\"What, no it is not dogs Willy... it's MATH!\"\n");
    delay(text);		
    System.out.println("Keanu continues \"Ok one of you pick a number. For satisfying the rubric\n let's make it a double.\"\n");
    delay(text);
    System.out.println("Please input your double: ");
    double reaves = sc.nextDouble();
    
    System.out.printf("\"Ok so you picked %f, let's call that %d. What is the square root of that to the nearest whole number?\"\n", reaves, (int) reaves );
    
    reaves = Math.sqrt(reaves);
    double exp = Math.pow(reaves, 3);
 
    System.out.printf("Option 1: %f\nOption 2: %d\nOption 3: %d\nOption 4: %f\n\n Please input your answer: ",reaves, (int) reaves, (int) reaves + 1, exp);
    
    int answer = sc.nextInt();
    
    if (answer == (int) reaves)
    {
    	System.out.println("\"Well it would seem that is correct. You may let your dog outside to pee\nMy curse is lifted\"\n");
    	success = 1;
    	delay(text);  	
    }
    else
    {
    	System.out.println("\"You have failed this challenge and you may not pass\"\n");
    	success = 0;
    	delay(text);
    	System.out.println("*Willy pees on floor*\n");
    	delay(3);
    }
    
    if(success == 0)
	{
		System.out.println("GAME OVER");
		delay(2);
		System.out.println("Would you like to continue? 1 - yes. 2- no: ");
		int cont = sc.nextInt();
		if (cont == 1)
			success = kitchen();
	}
	return success;
}//end kitchen

public static void backyard() //our closing scene, if our hero succeeds in eradicating the demons, Willy 
{                             //gets to pee outside.
	System.out.println("EPILOGUE");
	delay(3);
	System.out.println("As I open the back door, the storm that was raging in the skies is lifted\nmoonlight shines through the parting clouds.");
	delay(text);
	System.out.println("Willy runs rather frantically to his favorite tree\n and relieves himself.");
	delay(text);
	System.out.println("I smile as I know that I don't have to clean up dog pee.\n What a great way to end a horrible night.");
	delay(text);
	System.out.println("THE END");
	delay(3);

}//end backyard

public static void delay(int seconds)//I found this was a waay easier way to integrate delays. Especially 
{                                    //because I needed them so much for the story text.
	try {
		TimeUnit.SECONDS.sleep(seconds);
	}
	catch (InterruptedException e) {
		e.printStackTrace();
	}
	
}//end delay

}//end class
