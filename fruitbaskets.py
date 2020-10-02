# https://open.kattis.com/problems/fruitbaskets
# Given n number of inputs 
# outputs the sum of all diff. combinations of the inputs that are > 200
# each number can be used at most once  
# i.e. input: 50 60 70 120 
# (60+70+120), (50+70+120), (50+60+120), (50+60+70+120) => output: 1020
# range from 1 to n number of items 
from itertools import islice

def add_all(lst,i,n,included):
    if i == n-1:
        included[i] = True
        a = sum(lst[j] for j in range(i+1) if included[j])
        if a < 200:
            # we don't want baskets that weight < 200
            return 0
        included[i] = False
        b = sum(lst[j] for j in range(i+1) if included[j])
        if b < 200:
            return a
        else:
            return b
    else:
        included[i] = True
        z = sum(lst[j] for j in range(i+1) if included[j])
        if z >= 200:
            b = 2**(n-i-2) * (2*z+sum(islice(lst, i+1, None)))
        else:
            b = add_all(lst,i+1,n,included)
        included[i] = False
        z = sum(lst[j] for j in range(i+1) if included[j])
        if z >= 200:
            a = 2**(n-i-2) * (2*z+sum(islice(lst, i+1, None)))
        else:
            a = add_all(lst,i+1,n,included)
        return a+b

def main():
    n = int(input())
    lst = sorted(map(int,input().split()),reverse=True)
    print(add_all(lst,0,n,[False]*n))

if __name__ == "__main__":
    main()