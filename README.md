# java-multiclient-chat-application
A multi-client chat application built using Java Socket Programming.  It supports real-time messaging between multiple users, private messaging,  and online user tracking. Demonstrates core concepts like networking,  multithreading, and client-server architecture in Java.

It demonstrates key **Java networking and multithreading concepts**, making it ideal for beginners learning how real-time communication systems work.

---

## 🚀 Features

* Multi-client chat support
* Username-based messaging
* Broadcast messaging to all users
* Private messaging between users
* View online users
* Graceful exit command

---

## 🧠 Concepts Used

* Java Socket Programming
* Client–Server Architecture
* Multithreading
* Input/Output Streams
* Java Collections
* Command parsing

---

## 📂 Project Structure

```
JavaChatApp
│
├── Server.java
├── ClientHandler.java
└── Client.java
```

---

## ⚙️ Requirements

* Java JDK 8 or higher
* Terminal / Command Prompt

---

## ▶️ How to Run

### 1️⃣ Compile the project

```
javac *.java
```

### 2️⃣ Start the server

```
java Server
```

Output:

```
Chat Server Started...
```

### 3️⃣ Start client(s)

Open another terminal and run:

```
java Client
```

You can start **multiple clients** to simulate multiple users.

---

## 💬 Chat Commands

### Send message

```
Hello everyone
```

### Private message

```
/msg username message
```

Example:

```
/msg Alex Hello
```

### Show online users

```
/users
```

### Exit chat

```
/quit
```

---

## 🖥️ Example Chat

```
Alex joined the chat!
John joined the chat!

Alex: Hello everyone
John: Hi Alex!

(Private) John: Hello
```

---

## 📚 Learning Outcomes

This project helps beginners understand:

* How client-server systems work
* Real-time communication in Java
* Managing multiple users with threads
* Networking fundamentals

---

## 🔧 Future Improvements

* GUI using Java Swing
* Message timestamps
* Multiple chat rooms
* Message encryption
* User authentication

---

## 👨‍💻 Author

Built as a **Java networking practice project** and for learning purposes.
