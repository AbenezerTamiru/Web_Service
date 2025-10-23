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

@app.post("/students", response_model=Student)
def add_student(student: Student):
    students.append(student)
    return student

