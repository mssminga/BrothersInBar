### **How to run**

It's a Java console application that can be run as executable jar 
or from IDE of your choice. The entry point is in Main.java. 

When you start the app you would be asked to enter an integer number 
representing how many elements you want the array to have (maximum value = 100 000).
Then you would be asked to enter sequentially the elements of the array (maximum value = 
1 000 000).
 
**Sample input**
<pre>
10
1
1
2
3
3
3
2
2
1
1</pre>
 
**Sample output**
<pre>
Number of rounds with ArrayList: 3
Number of rounds with Array: 3</pre>

There are two methods used that is why there is a double output. 
 
### **Description**
 
 First I created the method using ArrayList and then I added a new one that work using simple array.
 The logic for both of them is the same. First I wanted to catch all the groups of three
 consecutive glasses of the same size in the line and for that I used a `for` cycle and an `if`.
 I then wrapped the `for` cycle with a `do while` cycle (to ensure at least one execution) 
 which breaks using a `boolean` value representing if there has not been a change in the line's
 size (if the brothers have not drank any drinks, and no glasses have been removed).
  
 