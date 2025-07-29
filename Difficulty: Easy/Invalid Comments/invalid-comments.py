def find_invalid_comments(df):
    return df[df['content'].str.len() > 20][['comment_id']]
