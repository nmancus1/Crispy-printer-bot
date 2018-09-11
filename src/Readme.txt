Nick Mancuso
CSC214
9/11/18

Mini Project Written Reflection


1. Did you have the prerequisite skills (java programming) to complete the program?  Did you encounter technical hurdles?

	I did have the prerequisite skills to complete this program.  There was no technical hurdles to overcome in this case.  
Overall, this assignment was straighforward, assuming that I interpreted the vague requirements correctly.  I created two solutions to
the problem of monitoring the toner levels.  First, I created a CLI program that offered users several different options after parsing
a .csv file, like to display the index of printers and check toner levels.  Second, I added a feature that allowed a user to enter command
line arguements and the program would directly output a list  of printers that were low on toner. This output could then be piped to a logfile 
or sent in an automated email on a set interval using a script and cron.

Example:
~$ date >> text.txt && java Crispy_Bot -f filename.csv >> logfile.txt

This would pipe the date and printers low on toner to a logfile in the pwd. 
You could then direct your script to email the logfile to the admin:

Example:
~$ cat text.txt | mail -s "Low Toner Levels" you@domain.com

2. Did the vague assignment instructions frustrate you?  Why or why not?  Be specific.

	The vague assigment intructions did frustrate me a bit.  I always like as much detail as possible.  It is important to understand HOW a user intends
to use a program, not just want they need it to do.  This is why i implemented a versitile program that employed both and interface and an automated 
option.  In addition, I attempted to make the program fairly modular, so that if the program wasn't up to expectations, parts of it (objects, etc) could be 
reused again.

3.How do you approach a programming assignment like this?  Try to elaborate on each of the steps you take - there is no wrong answer!

	I start with a quick sketch of the basic flow of the program, then produce UML diagrams to really help visualize how this project can come together (the UML 
diagrams are located in the /src folder forl this project).  Next, I begin creating the objects and data structures needed to solve the problem most efficiently. 
Along the way, I constantly test each objects, and its dependencies, in addtion to refactoring frequently for more efficient code. Finally, I produce the actual 
driver program, and further test that, until the program meets the requirements and has sufficient error checking.  Throughout the entire process, I use git / 
GitHub for version control, in case of any regressions or the need for different branches.
