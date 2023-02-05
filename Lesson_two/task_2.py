# Задание 2.
#
# Пользователь вводит целое положительное число.
# Найдите самую большую цифру в числе.
# Для решения используйте цикл while и только арифметические операции.
# Не используйте взятие по индексу.
#
# Пример:
# Ведите целое положительное число: 123456789
# Самая большая цифра в числе: 9

user_num = int(input('Ведите целое положительное число: '))
max_num = 0

while user_num > 0:
    if user_num % 10 > max_num:
        max_num = user_num % 10
    user_num = user_num // 10

print(f'Самая большая цифра в числе: {max_num}')