import pandas as pd

def count_unique_projects(df):
  result_series = df.drop_duplicates(subset=['employee_id', 'project_id'])['employee_id'].value_counts()
  
  # 4. Format the result to match the expected output schema
  result_df = result_series.reset_index(name='cnt').rename(columns={'index': 'employee_id'})
  
  # 5. Sort the final DataFrame by 'employee_id' to match the expected output order.
  # This was the missing step causing the "Wrong Answer".
  return result_df.sort_values(by='employee_id', ignore_index=True)