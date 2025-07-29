import pandas as pd

def find_patients_with_hypertension(df):
    def first_condition_is_htn(conditions):
        if pd.isna(conditions):
            return False
        words = conditions.split()
        return len(words) > 0 and words[0].startswith("HTN")

    return df[df['conditions'].apply(first_condition_is_htn)][['patient_id', 'patient_name', 'conditions']]
