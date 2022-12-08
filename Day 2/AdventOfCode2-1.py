import numpy as np

def get_data():
    #file_name = 'day2test.txt'
    file_name = 'day2.txt'

    with open(file_name) as fp:
        data = fp.read().strip()
        user_input = data.strip().split('\n')
        return user_input

userInput = get_data()
opponent = []
us = []
score = 0
for n in userInput:
    opp_choice = n[0]
    us_choice = n[2]
    if us_choice == 'X':
        score = score + 1
    elif us_choice == 'Y':
        score = score + 2
    elif us_choice == 'Z':
        score = score + 3

    if opp_choice == 'A' and us_choice == 'X':
        score = score + 3
    elif opp_choice == 'B' and us_choice == 'Y':
        score = score + 3
    elif opp_choice == 'C' and us_choice == 'Z':
        score = score + 3

    if us_choice == 'X' and opp_choice == 'C':
        score = score + 6
    elif us_choice == 'Y' and opp_choice == 'A':
        score = score + 6
    elif us_choice == 'Z' and opp_choice == 'B':
        score = score + 6

print(score)
