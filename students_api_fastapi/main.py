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
