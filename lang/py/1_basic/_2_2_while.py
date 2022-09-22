'''
Author: your name
Date: 2021-03-13 18:32:15
LastEditTime: 2021-04-15 23:28:13
LastEditors: Please set LastEditors
Description: In User Settings Edit
FilePath: /1_basic/2_2_while.py
'''

# must make sure can stop (have Fales / reach break)

# adding toppings to pizza (3 ways) ---------------------------------------
# when condition is simple
toppings = []
topping = ""  # initial value -> make while loop works
while topping != "quit":
    topping = input("what do you want to add? ")
    if topping != "quit":  # to avoid print "quit"
        toppings.append(topping)
print(toppings)

# when condition is complex
# (many events can make the loop stop, hard to check in the while statement
# use flag: while-statement check the flag; many events set the flag in block
toppings = []
active = True  # name can be anything, init True
while active:
    topping = input("what do you want to add? ")
    if topping != "quit":
        toppings.append(topping)
    else:
        active = False
print(toppings)

# when need to exit ASAP without running any remaining code
toppings = []
while True:
    topping = input("what do you want to add? ")
    if topping != "quit":
        toppings.append(topping)
    else:
        break
print(toppings)
# continue ------------------------------------------------------------
# when jmp to begining ASAP
num = 1
while num < 10:  # print odds from 1 to 10
    if num % 2 == 0:
        continue
    print(num)
