# Jim's Project Outline for tribe.com a community based social media site

## Overview

For my final project I want to implement a website from a "bare-metal" server instance, to a hosted website. I have not decided if I will use a CMS or not, I kind of want the challenge of building the LAMP stack, writing and styling all of the pages, and writing the server-side scripts. For System Administration last semester, our final project was to create a server instance and install a LAMP stack with a CMS. This would be a build-off of that. I mostly want to do the extra work so I can show this project off to employers. If the whole self-hosting thing is getting to be too much, then I'll move the website into classweb or hang it off of my Github site. All of the database construction will be based in scripts so moving into classweb will mostly be a file upload.

## Concept

This is an idea I have kicked around in my head for awhile. It is essentially my personal solution to the wild wild west of the social media giants such as Twitter and Facebook. Side note before I continue: I am basing the project for this class off of this concept so I can continue to play around with the basic mechanics of how I could possibly do this someday. If my life takes me in that direction of course. There is a lot of ugliness on social media. There are people who have the ability to "fire and forget" with their comments, accusations, fake news sharing. If you think about it did human communities always have this sort of discourse. I am going to say no. An individuals thoughts, feelings, and actions can extend to a global audience when it used to be the other people in the bar, or your Church, your town meeting, or the family dinner table. Saying things that harmed others unfarily had consequences. People shunned other people. If you were a jerk and unfair to someone, there was a vocal and or non-vocal response from your community that you had crossed a line. And it was REAL. Your voice is only 10% of communication. Now until they finish brain-cognitive interfaces, we will always have to deal with that 90% loss when communication happens between screens. I believe that the main thing missing from the social media giants is a sense of COMMUNITY due to the SCALE. There is also this growing trend of the individuals possessing two personalities: who they are on the internet and who they are in the real world. There is a growing discourse here on how the preference toward one or the other is GENERATIONAL, and can explain why none of us born before 1990 can make any sense of Gen X. So if we need more community on the internet how do we do it? Well, humans are already organized into groups IN THE REAL WORLD. Humans are instinctively tribal. Most people in modern life are in multiple tribes. These tribes exist in various states from fully codifed: the club softball team has a roster, to not formalized: the loose group of friends you had in college and all still kinda stay in touch. We do not even realize that we form tribes, but the same instincts that governed our ancestors to band together against the sabertooths are in the Thursday night bowling league's comraderie. 

So what I aim to do if you could not see it in the rambling, is create a social media site based entirely around groups. You do not get to add anybody in the world as a friend, you do not get to "swipe right" or "swipe left" on meaningless and fake pictures. You create a profile and either join together with at least one other person to found a "tribe" or you get invited to an existing one. When you make a comment or share something you choose the scope of the message. Each tribe will have a members list, a message board, and some kind of mechanism for making group decisions. But maybe that's a later thing because do you have "tribal councils" that call all of the shots, or a system of polling..... OR DO YOU LET THE TRIBAL FOUNDERS CHOOSE? See I have a lot of ideas about how to implement a community-driven social media tool, so I thought I would start here by making it from scratch. TODO find a way to keep Nazis off of it.... (always ruining good things)

## For the pages:

Login
=====
- conventional login page
- validates password starts a session and connects you to your profile page 
- if you are not a registered member, takes you to the register page

Register
========
- form for creating an account - I am keeping this to the most basic of info for now (maybe even just username, password)

Cave Wall
========
- your profile. I thought "cave wall" was keeping with the theme
- paint it anyway you like! Version 1 its only going to have a profile picture, username, and a list of tribes you are a member of.
- if I get time a V1.5 feature would be to have the cave wall painted with your recent activity, and a tool on the cave wall page to post to wherever
- inevitably I am seeing these as being a place to colorfully express yourself. You can put as many photos, inspirational quotes, article links on there as you want. Viewing access to those "wall spots" (name subject to revision) should have a privacy scope (set by tribe) and possible the whole cave wall itself

Found a Tribe
============
- page running a tribe creation form. I will need to work out the mechanics of how to make it so it takes at least 2 people to create.

Tribe
=====
- there will be 1 page per tribe. Only by being an invited member to that tribe will you be allowed to link to and view the page
- for starters this will just list members and have a message board. Probably a tribe picture

Tribe About
==========
- separate page for each tribe to say what they are about

Tribal Page
==========
- tribes can create 1 additional page for whatever they like

## Wrap-Up

So I know the assignment calls for 10 pages and I only have 7, but I see that the emphasis here is on the complexity. Now I can create multiple tribes and pages for grading purposes to meet the 10, and just pass you a login to an account I make that is a member of all of the tribes. If possible, I would prefer that so I can focus on the back-end portions that will make this successful and not a bunch of time on fluff. 
