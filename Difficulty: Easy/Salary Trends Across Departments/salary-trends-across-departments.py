def average_salary_by_department(df):
    result = df.groupby('department', as_index=False)['salary'].mean()
    result.columns = ['department', 'average_salary']
    result = result.sort_values('department').reset_index(drop=True)
    return result
