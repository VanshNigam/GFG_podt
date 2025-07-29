import numpy as np

def sort_by_column(arr):

    arr = np.array(arr)
    
    # Sort along axis 0 (columns)
    # np.sort sorts along the specified axis
    result = np.sort(arr, axis=0)
    
    return result