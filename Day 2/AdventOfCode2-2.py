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
    result = n[2]
    us_choice = 'Q'
    if result == 'Y': #tie
        score = score + 3
        us_choice = opp_choice
    if result == 'X': #lose
        if opp_choice == 'A':
            us_choice = 'C'
        elif opp_choice == 'B':
            us_choice = 'A'
        elif opp_choice == 'C':
            us_choice = 'B'
    if result == 'Z':
        if opp_choice == 'A':
            us_choice = 'B'
        elif opp_choice == 'B':
            us_choice = 'C'
        elif opp_choice == 'C':
            us_choice = 'A'
        score = score + 6
    if us_choice == 'A':
        score = score + 1
    elif us_choice == 'B':
        score = score + 2
    elif us_choice == 'C':
        score = score + 3
print(score)
