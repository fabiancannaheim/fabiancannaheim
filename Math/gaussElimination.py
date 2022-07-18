# -*- coding: utf-8 -*-
"""
Created on Fri Dec 10 11:31:30 2021
@author: Fabian C. Annaheim
@description: Gauss elimination, also known as row reduction,
is an algorithm for solving systems of linear equations. It
consists of a sequence of operations performed on a corresponding
matrix of coefficients.
"""

import numpy as np

def gauss_elimination(A, b):

    A = np.copy(A)  # Prevent changes in original matrix A
    b = np.copy(b)  # Prevent changes in original vector b
    A = A.astype('float64')  # Ensure that A is of type float
    b = b.astype('float64')  # Ensure that b is of type float

    n = np.shape(A)[0]

    # Gauss elimination
    for i in np.arange(0, n):
        j = i
        while j < n and A[j, i] == 0:
            j = j + 1
        if j != i:
            swap(A, b, i, j)
        for j in np.arange(i + 1, n):
            c = A[j, i] / A[i, i]
            subtract(A, b, j, i, c)

    return A, b


def swap(A, b, i, j):
    dummy = np.copy(A[i, :])
    A[i, :] = A[j, :]
    A[j, :] = dummy
    dummy = np.copy(b[i])
    b[i] = b[j]
    b[j] = dummy
    return A, b


def subtract(A, b, j, i, c):
    A[j, :] = A[j, :] - c * A[i, :]
    b[j] = b[j] - c * b[i]
    return A, b