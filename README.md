# crispy-printer-bot  
        __  ____   ____ _____ ____  __ __      ____  ____   ____  ____   ______    ___  ____       ____    ___   ______ 
       /  ]|    \ |    / ___/|    \|  |  |    |    \|    \ |    ||    \ |      |  /  _]|    \     |    \  /   \ |      |
      /  / |  D  ) |  (   \_ |  o  )  |  |    |  o  )  D  ) |  | |  _  ||      | /  [_ |  D  )    |  o  )|     ||      |
     /  /  |    /  |  |\__  ||   _/|  ~  |    |   _/|    /  |  | |  |  ||_|  |_||    _]|    /     |     ||  O  ||_|  |_|
    /   \_ |    \  |  |/  \ ||  |  |___, |    |  |  |    \  |  | |  |  |  |  |  |   [_ |    \     |  O  ||     |  |  |  
    \     ||  .  \ |  |\    ||  |  |     |    |  |  |  .  \ |  | |  |  |  |  |  |     ||  .  \    |     ||     |  |  |  
     \____||__|\_||____|\___||__|  |____/     |__|  |__|\_||____||__|__|  |__|  |_____||__|\_|    |_____| \___/   |__|  
    
- Author: Nick Mancuso 

Purpose
=======

    This command line applet consumes a .csv file, and builds an index of printers from it.               
    After parsing and building the index, the user can choose to parse more .csv files to keep             
    building the index, or display all printers in the index.  The check low toner level                    
    option will display only the printers that are low on toner, and specify which cartridge         
    to replace.  This program can also be run directly from the command line to check toner                  
    levels, to be used with scripts. Ex: 'java Crispy_Bot -f filename.csv'  
    
Features
========

- Program features a menu driven CLI interface
- Parses .csv files containing printer information
- Displays printer index
- Displays printer status and toner level
- Feature that allows a user to enter command line arguments when running the program, which will directly output a list of printers that are low on toner. This output could then be piped to a logfile or sent in an automated email on a set interval using a script and cron.

Example:

      ~$ date >> text.txt && java Crispy_Bot -f filename.csv >> logfile.txt
    
  This would pipe the date and printers low on toner to a logfile in the pwd. 
  You could then direct your script to email the logfile to the person responsible for ordering toner:
  
  Example:
      
      ~$ cat text.txt | mail -s "Low Toner Levels" you@domain.com


- Written with Java, so this program is OS agnostic
- Great ascii text!

Documentation
=============
The documentation is contained within inline comments and headers in the various files, but especially `Readme.txt`.

Contribute
==========

You are of course welcome to contribute, this is what GitHub is for.
