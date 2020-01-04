# #!/bin/python3

# import math
# import os
# import random
# import re
# import sys

# # Complete the arrayManipulation function below.
# def arrayManipulation(n, queries):
#     #Did not complete within the time constraints but it is correct
#     arr = [0 for i in range(n)]
#     i = 0
#     print(queries)
#     for item in queries:
#         a = item[0]
#         b = item[1]
#         k = item[2]
#         for j in range(a-1,b):
#             arr[j] = arr[j] + k
#     return max(arr)

# if __name__ == '__main__':
#     fptr = open(os.environ['OUTPUT_PATH'], 'w')

#     nm = input().split()

#     n = int(nm[0])

#     m = int(nm[1])

#     queries = []

#     for _ in range(m):
#         queries.append(list(map(int, input().rstrip().split())))

#     result = arrayManipulation(n, queries)

#     fptr.write(str(result) + '\n')

#     fptr.close()

n, inputs = [int(n) for n in input().split(" ")]
list = [0]*(n+1)
for _ in range(inputs):
    x, y, incr = [int(n) for n in input().split(" ")]
    list[x-1] += incr
    if((y)<=len(list)): list[y] -= incr;
max = x = 0
for i in list:
   x=x+i;
   if(max<x): max=x;
print(max)
