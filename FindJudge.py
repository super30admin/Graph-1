#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Mon Sep 30 11:17:52 2019

@author: tanvirkaur
"""
class Solution(object):
    def findJudge(self, N, trust):
        """
        :type N: int
        :type trust: List[List[int]]
        :rtype: int
        """
        Degrees = [0]*(N)
        for a, b in trust:
            Degrees[a-1] -= 1
            Degrees[b-1] += 1
        for i in range(0,N):
            if Degrees[i] == N-1:
                return i+1
        return -1