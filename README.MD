Software requirements: 
Java - 1.6+
Maven - 3.2.2

Steps to run test cases through maven: 
1. mvn clean 
2. mvn test to run all the test cases

Steps to run from command line:
1. cd to src directory
2. javac com/im/main/PointOfSale.java
3. java com.im.main.PointOfSale
4. Input all the pricing details and items in the cart

Details about test cases and sample run:
1. Tests are added in test.java.TestPOS class, following tests are added:
	a. testMultipleOccurenceOfAProduct e.g. ABCDABAA
	b. testSameProducts e.g. CCCCCCC
	c. testAllDifferentProdcut e.g. ABCD
	d. testIfProductNotExists e.g. ABCDPQ
2. Sample run:
Enter product name:
apple
Enter regular price:
12
Enter volume price (enter 0 if it's not to be sold in volume):
15
Enter volume quantity (enter 0 if it's not to be sold in volume):
2
Any more items to add (yes/no):
yes
Enter product name:
banana
Enter regular price:
10
Enter volume price (enter 0 if it's not to be sold in volume):
0
Enter volume quantity (enter 0 if it's not to be sold in volume):
0
Any more items to add (yes/no):
no
Enter item in your shopping cart (enter exit to stop adding):
apple
Enter item in your shopping cart (enter exit to stop adding):
apple
Enter item in your shopping cart (enter exit to stop adding):
apple
Enter item in your shopping cart (enter exit to stop adding):
banana
Enter item in your shopping cart (enter exit to stop adding):
exit
The total is: $37
