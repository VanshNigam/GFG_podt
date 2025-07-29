import pandas as pd

def count_city_population_categories(df):
    # Create a new column for category
    def classify(pop):
        if pop < 100000:
            return "Small City"
        elif pop <= 1000000:
            return "Medium City"
        else:
            return "Large City"
    
    df['category'] = df['population'].apply(classify)

    # Count cities per category
    counts = df['category'].value_counts().reindex(
        ["Small City", "Medium City", "Large City"], fill_value=0
    ).reset_index()

    counts.columns = ['category', 'cities_count']
    return counts
