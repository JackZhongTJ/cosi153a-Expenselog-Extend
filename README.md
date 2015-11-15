# cosi153a-Expenselog
**cosi153a programming assignment:**  
Create a expense log that allows users to dynamically add expense log.  

Each entry in the Expense Log will contain 3 data items (all Strings):
-  a two to three word description of the Expense heading
-  some notes about expense
- the time/date of the entry  

The three fields for each log entry will be displayed as three successive TextViews in a scrolling list of log entries.  The ListView of these entries will be populated dynamically by a custom data adapter.
In addition, the main Activity will have a single options menu button, Add, which will cause a second Activity to be displayed in which the user can type in a expense and some notes (the time/date will be automatically generated) and then can either Save or Cancel (via two Buttons).  When Save is pressed, the new entry will display at the end of the list of log entries on the main screen.
