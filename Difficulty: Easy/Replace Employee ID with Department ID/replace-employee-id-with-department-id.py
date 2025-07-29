def find_department_id(df_employees, df_employee_dept):
    result = pd.merge(df_employees, df_employee_dept, on='id', how='left')
    return result
