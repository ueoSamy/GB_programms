# Задание 3.
#
# Узнайте у пользователя целое положительное число n.
# Найдите сумму чисел n + nn + nnn.
#
# Пример:
# Введите число n: 3
# n + nn + nnn = 369

n_num = input('Введите число N: ')
print(f'{n_num} + {n_num + n_num} + {n_num * 3} = {int(n_num) + int(n_num + n_num) + int(n_num * 3)}')
