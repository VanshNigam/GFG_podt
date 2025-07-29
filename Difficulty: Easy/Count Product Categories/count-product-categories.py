import pandas as pd

def count_product_categories(df: pd.DataFrame) -> pd.DataFrame:
    """
    Given a DataFrame with columns ['product_id', 'category_name'],
    returns a new DataFrame with the count of products in each category,
    sorted by category_name in ascending order.
    """
    # Create a dictionary to count categories
    category_counts = {}
    
    # Iterate through the dataframe (can be faster for small datasets)
    for category in df['category_name']:
        if category in category_counts:
            category_counts[category] += 1
        else:
            category_counts[category] = 1
    
    # Convert to DataFrame
    result = pd.DataFrame({
        'category_name': list(category_counts.keys()),
        'products_count': list(category_counts.values())
    })
    
    # Sort by category_name
    result = result.sort_values('category_name').reset_index(drop=True)
    
    return result
