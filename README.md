# tsiva006_lab1

Full name: Trisha Siva
E-mail: tsiva006@ucr.edu
UCR NetID: tsiva006
Student ID: 862359127

# Answers

# (Q1) What is the name of the directory that mvn archectype:generate command creates?

tsiva006

# (Q2) What do you see at the console output when you run the java command?

Printing numbers in the range [3,20]
3
5
6
9
10
12
15
18
20


# (Q3) Which of the following is the right way to call the IsEven function?

new IsEven().apply(5)

# (Q4) Did the program compile after you added the base=0 line?

No

# (Q5) If your answer to (Q4) is No, what is the error message you get?

The base variable causes an issue because it’s being used in a way that makes it "locked" or unchangeable (like a final variable) once it’s used in the lambda function. After that, you’re not allowed to modify it, which is why the program throws an error.


