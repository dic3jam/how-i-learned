def hourglassSum(arr):
    max_sum = 0
    i, j = 0
    while j < 3:
        while i < 3:
            sum_hrgl = arr[i][j] + arr[i+1][j] + arr[i+2][j] + arr[i+1][j+1] + arr[i][j+2] + arr[i+1][j+2] + arr[i+2][j+2]
            if(sum_hrgl > max_sum):
               max_sum = sum_hrgl 
            i += 1
        j += 1

    return max_sum
