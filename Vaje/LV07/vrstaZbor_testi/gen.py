#!/usr/bin/python

import sys
import random

n = int(sys.argv[1])
t = []
for i in range(n):
    t.append(random.randint(160, 220))
print n
print ' '.join([str(s) for s in t])
