import numpy as np

def get_data():
    file_name = 'day3test.txt'
    #file_name = 'day3.txt'

    with open(file_name) as fp:
        data = fp.read().strip()
        user_input = data.strip().split('\n')
        return user_input

userInput = get_data()
priority = 0
for i in userInput:
    a=list(set(i[0:int(len(i)/2):1])&set(i[int(len(i)/2):len(i):1]))
    if ord(a[0]) < ord('a'):
        diff =  ord(a[0]) - ord('A') + 1 + 26
        #print(diff)
        priority = priority + diff
    else:
        diff = ord(a[0]) - ord('a') + 1
        #print(diff)
        priority = priority + diff
print(priority)
# for i in userInput:
#     length = len(i)
#     part1 = i[0:int(length/2):1]
#     part2 = i[int(length/2):length:1]
#     same = 'a'
#     cont = 0
#     for letter in part1:
#         if cont == 1:
#             break
#         for letter2 in part2:
#             if cont == 1:
#                 break
#             if letter == letter2:
#                 same = letter
#                 #print(same)
#                 #97 A
#                 #65 a
#                 if ord(same) < ord('a'):
#                     diff =  ord(same) - ord('A') + 1 + 26
#                     #print(diff)
#                     priority = priority + diff
#                     cont = 1
#                 else:
#                     diff = ord(same) - ord('a') + 1
#                     #print(diff)
#                     priority = priority + diff
#                     cont = 1
# print(priority)
