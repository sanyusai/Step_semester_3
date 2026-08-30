# Step_semester_3:

CONTAINS ALL THE CLASS PROBLEMS AND THE ASSIGNMENTS AS WELL
# STEP Semester 3

A structured repository for maintaining Java programming practice, class exercises, and assignments completed as part of the **STEP / CodInClub program powered by BridgeLabz** during Semester 3.

The repository is organized week-wise to keep class problems and assignment problems separated and easy to navigate.

## 🛠️ Technologies Used

* **Java** — Programming language used for all solutions
* **Git** — Version control
* **GitHub** — Repository and code management
* **VS Code / IntelliJ IDEA** — Development environment
* **Terminal** — Compilation, execution, and Git operations

---

## 📂 Repository Structure

The repository follows a **week-wise structure**. Each week contains separate folders for problems solved during class and problems given as assignments.

```text
Step_semester_3/
│
├── README.md
│
└── src/
    └── main/
        └── java/
            │
            ├── week_1/
            │   ├── class_problems/
            │   │   ├── Problem1.java
            │   │   ├── Problem2.java
            │   │   └── ...
            │   │
            │   └── assignment_problems/
            │       ├── Problem1.java
            │       ├── Problem2.java
            │       └── ...
            │
            ├── week_2/
            │   ├── class_problems/
            │   └── assignment_problems/
            │
            ├── week_3/
            │   ├── class_problems/
            │   └── assignment_problems/
            │
            └── week_N/
                ├── class_problems/
                └── assignment_problems/
```

### 📋 Structure Guidelines

For every new week, follow the same pattern:

```text
week_X/
├── class_problems/
└── assignment_problems/
```

### 💻 Class Problems

Programs practiced or implemented during the live-coding/class sessions should be placed inside:

```text
week_X/class_problems/
```

For example:

```text
week_3/class_problems/
├── Problem1.java
├── Problem2.java
├── Problem3.java
└── Problem4.java
```

### 📝 Assignment Problems

Problems given as assignments should be placed inside:

```text
week_X/assignment_problems/
```

For example:

```text
week_3/assignment_problems/
├── Problem1.java
├── Problem2.java
├── Problem3.java
└── Problem4.java
```

### 📁 Adding a New Week

When a new week begins, create the following structure:

```text
week_X/
├── class_problems/
└── assignment_problems/
```

Then place each Java solution in the appropriate folder.

This ensures that:

* Class work and assignments remain separated
* Problems can easily be located by week
* The repository remains consistent throughout the semester
* New contributors can understand the organization immediately

---

## 🌿 Branching Structure

Weekly work can be maintained using feature branches:

```text
main
│
├── feature/week_1
├── feature/week_2
├── feature/week_3
├── feature/week_4
└── ...
```

Each branch contains the work associated with its respective week or session before being merged into the main branch.

---

## 🔄 Basic Workflow

```text
Create / Switch to Week Branch
          ↓
Create Week Folder
          ↓
Create class_problems & assignment_problems
          ↓
Add Java Programs
          ↓
Compile & Test
          ↓
git add .
          ↓
git commit
          ↓
git push
```

---

## 👨‍💻 Author

**Sanyu Sai**

B.Tech Computer Science and Engineering
Cybersecurity Specialization

GitHub: [sanyusai](https://github.com/sanyusai)

---

> **Learn → Practice → Implement → Test → Commit → Repeat**
