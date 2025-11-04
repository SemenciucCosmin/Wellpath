# 🧠 Therapist–Patient Communication App

A mobile and web application that facilitates secure communication, journaling, and progress tracking between **therapists** and **patients**.  
The system supports authentication, wellness exercises, assignments, and journaling features to enhance therapy engagement and continuity.

---

## 🚀 Overview

This project aims to provide a digital space where therapists and patients can:
- Communicate securely and efficiently
- Share tasks, wellness exercises, and forms
- Monitor emotional progress through journaling
- Encourage self-awareness and mental health growth

---

## ⚙️ Engineering Requirements

### 🔐 Authentication
There are **two possible authentication flows**:

1. **Patient-Self Registration Flow**
  - The patient creates an account manually.
  - Upon signup, the patient must **choose a therapist** from a list of available therapists.
  - A **connection request** is sent to the selected therapist.
  - The patient waits for therapist confirmation before gaining full access.

2. **Therapist-Created Account Flow**
  - The therapist creates the patient’s account from the therapist dashboard.
  - The patient account comes **pre-linked** to the therapist.
  - The patient can only **log in**, not self-register.

Both authentication flows are designed to ensure **secure therapist–patient linking** and **data privacy**.

---

## 🌿 Wellness Exercises

A dedicated section in the **patient app** featuring three categories:

1. **Breathing Exercises**
2. **Mindfulness Exercises**
3. **CBT (Cognitive Behavioral Therapy) Exercises**

### Functionality:
- Exercises can be **assigned by the therapist** or **initiated manually** by the patient.
- Each exercise type can have structured steps, progress tracking, and completion status.
- The therapist can monitor exercise completion and engagement.

---

## 🧾 Assignments

The **therapist** can assign specific tasks to the patient to support therapy goals.

### Task Types:
- Psychological or diagnostic **tests**
- **Reading materials** or articles
- **Wellness exercises**
- **Custom forms** (reflecting patient’s mood, mental state, or specific themes)

### Flow:
1. The therapist **uploads or creates** the task in the system.
2. The task becomes available for **assignment** to one or more patients.
3. The patient receives a **notification** and can complete the task within the app.
4. Completion status and responses are visible to the therapist.

---

## 📓 Journal

A reflective section for patients to record their daily or weekly thoughts, feelings, and experiences.

### Features:
- The patient completes a **form** acting as a digital journal page.
- The patient can **view all past entries** for reflection and self-awareness.
- The therapist has **full access** to the patient’s journal entries for analysis and discussion.

---

## 🧩 Core Features Summary

| Feature | Patient | Therapist |
|----------|----------|------------|
| Authentication | Register / Log in | Approve / Create patients |
| Therapist Linking | Request / Wait for approval | Approve connection |
| Wellness Exercises | Start or complete exercises | Assign exercises |
| Assignments | View & complete tasks | Create, upload, assign tasks |
| Journal | Add and view entries | View patient journals |

---