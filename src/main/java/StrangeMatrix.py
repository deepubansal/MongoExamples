import sys
from sys import stdin, stdout

    
first = stdin.readline().split()
n = int(first[0])
m = int(first[1])
p = int(first[2])

matrix = [[m-1]+[0 for x in range(m+1)] for x in range(n)]
if m > 1:
    list = stdin.readlines()
    for line1 in list:
        line = line1.split()
        i = int(line[0])-1
        j = int(line[1])
        matrix[i][j] += 1
        if j == 1:
            matrix[i][0] -= 1
            if matrix[i][j] - matrix[i][j+1] >= 2:
                matrix[i][m+1] -= 1
        if j == m:
            matrix[i][0] += 1
            if matrix[i][j-1] - matrix[i][j] >= 1:
                matrix[i][m+1] += 1
        if j > 1 and j < m:
            if matrix[i][j] - matrix[i][j+1] >= 2:
                matrix[i][m+1] -= 1
            if matrix[i][j-1] - matrix[i][j] >= 1:
                matrix[i][m+1] += 1
for l in matrix:
    if l[m+1] < 0:
        stdout.write(str(-1)+"\n")
    else:
        stdout.write(str(l[0])+"\n") 
