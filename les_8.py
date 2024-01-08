def copy_line_from_file(source_filename, destination_filename, line_number):
    try:
        with open(source_filename, 'r', encoding='utf-8') as source_file:
            lines = source_file.readlines()

            if 1 <= line_number <= len(lines):
                line_to_copy = lines[line_number - 1]

                with open(destination_filename, 'a', encoding='utf-8') as destination_file:
                    destination_file.write(line_to_copy)

                print(f"Строка {line_number} успешно скопирована в файл {destination_filename}.")
            else:
                print(f"Ошибка: Неверный номер строки. Доступные строки: от 1 до {len(lines)}.")

    except FileNotFoundError:
        print(f"Ошибка: Один из файлов не найден.")

# Пример использования
source_filename = 'source.txt'  # Замените на имя вашего исходного файла
destination_filename = 'destination.txt'  # Замените на имя вашего файла-приемника
line_number_to_copy = int(input("Введите номер строки для копирования: "))

copy_line_from_file(source_filename, destination_filename, line_number_to_copy)