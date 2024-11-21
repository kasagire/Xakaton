import os
import json
from flask import Flask, jsonify, request
from flask_cors import CORS

app = Flask(__name__)
CORS(app)

DATA_FILE = "events.json"

# Функции для работы с файлом данных
def load_events():
    """Загружает мероприятия из файла."""
    if os.path.exists(DATA_FILE):
        with open(DATA_FILE, "r", encoding="utf-8") as file:
            return json.load(file)
    return []

def save_events(events):
    """Сохраняет мероприятия в файл."""
    with open(DATA_FILE, "w", encoding="utf-8") as file:
        json.dump(events, file, ensure_ascii=False, indent=4)

# Инициализация данных
events = load_events()

# Получение списка мероприятий
@app.route('/events', methods=['GET'])
def get_events():
    return jsonify(events)

# Добавление нового мероприятия
@app.route('/events', methods=['POST'])
def add_event():
    new_event = request.json
    events.append(new_event)
    save_events(events)  # Сохраняем изменения
    return jsonify(new_event), 201

# Получение мероприятия по ID
@app.route('/events/<int:event_id>', methods=['GET'])
def get_event(event_id):
    event = next((event for event in events if event['id'] == event_id), None)
    return jsonify(event) if event else ('', 404)

# Изменение мероприятия по ID
@app.route('/events/<int:event_id>', methods=['PUT'])
def update_event(event_id):
    update_data = request.json
    event = next((event for event in events if event['id'] == event_id), None)
    if event:
        # Обновляем только указанные поля
        event.update({key: value for key, value in update_data.items() if key in event})
        save_events(events)  # Сохраняем изменения
        return jsonify(event), 200
    else:
        return jsonify({"error": "Мероприятие не найдено"}), 404

# Удаление мероприятия по ID
@app.route('/events/<int:event_id>', methods=['DELETE'])
def delete_event(event_id):
    global events
    event = next((event for event in events if event['id'] == event_id), None)
    if event:
        events = [e for e in events if e['id'] != event_id]  # Исключаем удалённое мероприятие
        save_events(events)  # Сохраняем изменения
        return jsonify({"message": f"Мероприятие с ID {event_id} удалено"}), 200
    else:
        return jsonify({"error": "Мероприятие не найдено"}), 404

if __name__ == '__main__':
    app.run(debug=True)
