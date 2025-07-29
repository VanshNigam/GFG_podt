import pandas as pd

def find_salesperson_without_blue_orders(df_salesperson, df_orders, df_company):
    # Step 1: Find company IDs for company "BLUE"
    blue_company_ids = df_company[df_company['name'] == 'BLUE']['com_id']

    # Step 2: Find sales IDs who have orders for "BLUE"
    sales_ids_with_blue_orders = df_orders[df_orders['com_id'].isin(blue_company_ids)]['sales_id'].unique()

    # Step 3: Exclude those salespersons
    result = df_salesperson[~df_salesperson['sales_id'].isin(sales_ids_with_blue_orders)][['name']]
    
    return result
