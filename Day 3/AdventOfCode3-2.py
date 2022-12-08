import numpy as np

def get_data():
    #file_name = 'day3test.txt'
    file_name = 'day3.txt'

    with open(file_name) as fp:
        data = fp.read().strip()
        user_input = data.strip().split('\n')
        return user_input

userInput = get_data()
priority = 0
for i in range(0,len(userInput),3):
    sorted1 = sorted(userInput[i])
    sorted2 = sorted(userInput[i+1])
    sorted3 = sorted(userInput[i+2])
    same = 'a'
    cont = 0
    for letter in sorted1:
        if cont == 1:
            break
        for letter2 in sorted2:
            if cont == 1:
                break
            for letter3 in sorted3:
                if cont == 1:
                    break
                if letter == letter2 and letter2 == letter3:
                    same = letter
                    #print(same)
                    #97 A
                    #65 a
                    if ord(same) < ord('a'):
                        diff =  ord(same) - ord('A') + 1 + 26
                        #print(diff)
                        priority = priority + diff
                        cont = 1
                    else:
                        diff = ord(same) - ord('a') + 1
                        #print(diff)
                        priority = priority + diff
                        cont = 1
print(priority)
