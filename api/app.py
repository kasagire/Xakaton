from flask import Flask, jsonify, request
from flask_cors import CORS

app = Flask(__name__)
CORS(app)  # Разрешаем CORS для всех маршрутов

# Пример данных о мероприятиях
events = [
    {"id": 1, "title": "Спортивный турнир", "category": "Внутри ВУЗа", "date": "2024-05-01"},
    {"id": 2, "title": "Научная конференция", "category": "Российские", "date": "2024-06-15"},
    {"id": 3, "title": "Городской фестиваль", "category": "Городские", "date": "2024-07-20"},
]

# Получение списка мероприятий
@app.route('/events', methods=['GET'])
def get_events():
    return jsonify(events)

# Добавление нового мероприятия
@app.route('/events', methods=['POST'])
def add_event():
    new_event = request.json
    events.append(new_event)
    return jsonify(new_event), 201

# Получение мероприятия по ID
@app.route('/events/<int:event_id>', methods=['GET'])
def get_event(event_id):
    event = next((event for event in events if event['id'] == event_id), None)
    return jsonify(event) if event else ('', 404)

if __name__ == '__main__':
    app.run(debug=True)