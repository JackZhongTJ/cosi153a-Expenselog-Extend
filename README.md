# cosi153a-Expenselog
**cosi153a programming assignment:**  
This is a extended version of former expense log application that allows users to dynamically add or delete expense log.  
The data would be stored into sqlite.

1.  Extend the Expense log application to implement a delete mechanism so that you can delete a particular item from the list. Hint: Think of providing a button on each list item, the onClick method of which should delete that particular list item.  
2. Make data persistent in Expense log application either by implementing SQLite database methods or by using content provider. You should be able to store at least 10 items in the database. If you close your application the user should see all those 10 items when he re-launches the application.
3. Use SimpleCursorAdapter to display result on the listview.

Each entry in the Expense Log will contain 3 data items (all Strings):
-  a two to three word description of the Expense heading
-  some notes about expense
- the time/date of the entry  

The three fields for each log entry will be displayed as three successive TextViews in a scrolling list of log entries.  The ListView of these entries will be populated dynamically by a custom data adapter.
In addition, the main Activity will have a single options menu button, Add, which will cause a second Activity to be displayed in which the user can type in a expense and some notes (the time/date will be automatically generated) and then can either Save or Cancel (via two Buttons).  When Save is pressed, the new entry will display at the end of the list of log entries on the main screen.
