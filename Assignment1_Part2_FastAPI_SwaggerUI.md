# Assignment 1 - Part 2  
## Web API Design and Testing Tools (FastAPI + Swagger UI)

### 1. Introduction
The goal of this assignment is to design and test a RESTful Web API using **FastAPI**, a modern and high-performance Python framework for building web APIs.  
Instead of using Postman, this implementation leverages **FastAPI's built-in Swagger UI**, which provides an interactive web interface for testing and exploring the API endpoints.

The main objective is to demonstrate the process of creating and testing CRUD (Create, Read, Update, Delete) operations through an example **Student Management API**.

---

### 2. Implementation Steps

#### Step 1: Project Setup
- Created a virtual environment and installed required dependencies:
  ```bash
  python -m venv venv
  source venv/bin/activate  # For Windows: venv\Scripts\activate
  pip install fastapi uvicorn
  ```

#### Step 2: Define the Model and API Routes
A `Student` model was created using **Pydantic**, and routes were defined using **FastAPI** decorators for handling CRUD operations.

```python
from fastapi import FastAPI, HTTPException
from pydantic import BaseModel
from typing import List

app = FastAPI()

class Student(BaseModel):
    id: int
    name: str
    department: str
    email: str

students = []

@app.get("/students", response_model=List[Student])
def get_students():
    return students

@app.get("/students/{student_id}", response_model=Student)
def get_student(student_id: int):
    for student in students:
        if student.id == student_id:
            return student
    raise HTTPException(status_code=404, detail="Student not found")

@app.post("/students", response_model=Student)
def add_student(student: Student):
    students.append(student)
    return student

@app.put("/students/{student_id}", response_model=Student)
def update_student(student_id: int, updated_student: Student):
    for i, s in enumerate(students):
        if s.id == student_id:
            students[i] = updated_student
            return updated_student
    raise HTTPException(status_code=404, detail="Student not found")

@app.delete("/students/{student_id}")
def delete_student(student_id: int):
    global students
    students = [s for s in students if s.id != student_id]
    return {"message": "Student deleted successfully"}
```

#### Step 3: Running the Server
To start the application:
```bash
uvicorn main:app --reload
```
The server runs on: **http://127.0.0.1:8000**

Swagger UI for testing is available at: **http://127.0.0.1:8000/docs**

---

### 3. Tools and Technologies Used

| Tool | Purpose |
|------|----------|
| **Python (FastAPI)** | Web API development |
| **Uvicorn** | ASGI server for running FastAPI applications |
| **Swagger UI** | Built-in API testing and documentation tool |
| **Pydantic** | Data validation and serialization |
| **VS Code / PyCharm** | Development environment |

---

### 4. Results and Observations

#### Example 1: POST Request (Add Student)
**Endpoint:** `/students`  
**Request Body:**
```json
{
  "id": 1,
  "name": "Betselot Abraham",
  "department": "Software Engineering",
  "email": "betselot@ju.edu"
}
```
**Response:**
```json
{
  "id": 1,
  "name": "Betselot Abraham",
  "department": "Software Engineering",
  "email": "betselot@ju.edu"
}
```

#### Example 2: GET Request (Fetch All Students)
**Endpoint:** `/students`  
**Response:**
```json
[
  {
    "id": 1,
    "name": "Betselot Abraham",
    "department": "Software Engineering",
    "email": "betselot@ju.edu"
  }
]
```

#### Example 3: DELETE Request
**Endpoint:** `/students/1`  
**Response:**
```json
{
  "message": "Student deleted successfully"
}
```

> All endpoints were successfully tested and verified through Swagger UI, confirming proper API functionality and validation.

---

### 5. Conclusion
This exercise demonstrated how to design and test a RESTful API using **FastAPI** with **Swagger UI**.  
FastAPI’s automatic documentation, type validation, and live testing capabilities simplify the API development process significantly.  
Through this project, I learned how to define routes, handle HTTP methods, and perform structured testing without external tools like Postman.

---

**Prepared by:** Betselot Abraham Gizaw  
**Course:** Web Service  
**Assignment:** No. 2 — Web API Design and Testing Tools (FastAPI + Swagger UI)  
**GitHub Repository:** [text](https://github.com/mengistu3137/Web_Service/) 
