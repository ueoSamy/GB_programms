# Напишите программу, которая принимает на вход цифру, обозначающую день недели, и проверяет, является ли этот день выходным.
#
# *Пример:*
#
# - 6 -> да
# - 7 -> да
# - 1 -> нет

user_input = int(input('Введите день недели в цифрах: '))
if user_input <= 7:
    if 1 <= user_input <= 5:
        print('Не выходной')
    else:
        print('Выходной')
else:
    print('Введите число от 1 до 7')