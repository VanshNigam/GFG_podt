import pandas as pd

def find_rank_scores(df):

  df['rank'] = df['score'].rank(method='min', ascending=False).astype(int)
  
  # Sort the entire DataFrame by the 'score' column in descending order.
  df_sorted = df.sort_values(by='score', ascending=False)
  
  # Select only the 'score' and 'rank' columns as required.
  result_df = df_sorted[['score', 'rank']]
  
  # Reset the index to be sequential (0, 1, 2, ...).
  # drop=True prevents the old index from being added as a new column.
  # This was the final step needed to match the expected output format.
  return result_df.reset_index(drop=True)