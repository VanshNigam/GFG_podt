import numpy as np

def matrix_multiplication(matrix1, matrix2):

    matrix1 = np.array(matrix1)
    matrix2 = np.array(matrix2)
    
    # Use NumPy's dot function to compute the matrix product
    result = np.dot(matrix1, matrix2)
    
    return result