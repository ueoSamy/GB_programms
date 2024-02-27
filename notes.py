import json
import os
import datetime

NOTES_FILE = "notes.json"

def load_notes():
    if not os.path.exists(NOTES_FILE):
        return []
    with open(NOTES_FILE, "r") as file:
        return json.load(file)

def save_notes(notes):
    with open(NOTES_FILE, "w") as file:
        json.dump(notes, file, indent=4)

def add_note(title, message):
    notes = load_notes()
    now = datetime.datetime.now().strftime("%Y-%m-%d %H:%M:%S")
    note = {"id": len(notes) + 1, "title": title, "message": message, "created_at": now}
    notes.append(note)
    save_notes(notes)

def list_notes():
    notes = load_notes()
    for note in notes:
        print(f"{note['id']}. {note['title']} - {note['created_at']}")
    if not notes:
        print("No notes found.")

def delete_note(note_id):
    notes = load_notes()
    for note in notes:
        if note["id"] == note_id:
            notes.remove(note)
            save_notes(notes)
            print("Note deleted successfully.")
            return
    print("Note not found.")

def main():
    while True:
        print("\nCommands:")
        print("1. add - Add a new note")
        print("2. list - List all notes")
        print("3. delete <id> - Delete a note by id")
        print("4. exit - Exit the program")

        command = input("Enter command: ").strip().split(" ", 1)

        if command[0] == "add":
            if len(command) != 2:
                print("Usage: add <title> <message>")
            else:
                title, message = command[1].split(" ", 1)
                add_note(title, message)
                print("Note added successfully.")
        elif command[0] == "list":
            list_notes()
        elif command[0] == "delete":
            if len(command) != 2:
                print("Usage: delete <id>")
            else:
                try:
                    note_id = int(command[1])
                    delete_note(note_id)
                except ValueError:
                    print("Invalid note id.")
        elif command[0] == "exit":
            break
        else:
            print("Invalid command.")

if __name__ == "__main__":
    main()
