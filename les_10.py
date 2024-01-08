import pandas as pd

# Ваш исходный код для создания DataFrame
import random
lst = ['robot'] * 10
lst += ['human'] * 10
random.shuffle(lst)
data = pd.DataFrame({'whoAmI': lst})
print("Исходный DataFrame:")
print(data.head())

# Преобразование в one-hot формат без использования get_dummies
one_hot_data = pd.concat([pd.Series(data['whoAmI'] == 'robot').astype(int).rename('robot'),
                         pd.Series(data['whoAmI'] == 'human').astype(int).rename('human')],
                         axis=1)

print("\nDataFrame в one-hot формате:")
print(one_hot_data.head())
