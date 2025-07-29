def delete_duplicate_phone_numbers(df):
    df = df.sort_values(by='id')
    df = df[~df.duplicated(subset='phone', keep='first')]
    return df
