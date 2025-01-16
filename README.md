# Chat Application

This project is a **Chat Application** built using Java that allows two users to communicate over a network. The application includes a graphical user interface (GUI) created with the Swing library, providing a user-friendly chat experience.

## Features

- **Client-Server Architecture**: The application uses a socket-based client-server model to facilitate communication between two parties.
- **Graphical User Interface**: Both the client and server applications feature GUIs for sending and receiving messages, making the chat experience intuitive.
- **Real-time Messaging**: Messages are transmitted in real-time between the client and server.
- **Chat Termination**: The chat session ends gracefully when either party sends the message `bye`.
- **Scrollable Message Area**: The chat window includes a scrollable text area to display the chat history.
- **Customizable UI**: The GUI features fonts, colors, and layouts designed for readability and ease of use.

## Components

### Client
- **Message Input Field**: Allows the user to type messages.
- **Send Button**: Sends the typed message to the server.
- **Message Display Area**: Displays messages from both the client and the server.
- **Chat Termination**: Detects when `bye` is sent or received, closes the connection, and exits the application.

### Server
- **Message Input Field**: Allows the server user to type messages.
- **Send Button**: Sends the typed message to the client.
- **Message Display Area**: Displays messages from both the client and the server.
- **Chat Termination**: Detects when `bye` is sent or received, closes the connection, and exits the application.

## How It Works

1. The **server** starts first and waits for a connection from the client.
2. The **client** initiates a connection to the server.
3. Once connected, both users can send and receive messages in real time.
4. When either user sends the message `bye`, the chat session ends, and the application terminates.

## Prerequisites

- **Java Development Kit (JDK)**: Version 8 or higher.
- **Network Configuration**: Both the client and server should be able to connect over the specified IP address and port (default: `127.0.0.1:8000`).

## Setup and Usage

1. Clone this repository:
   ```bash
   git clone https://github.com/your-repo/chat-application.git
   ```
2. Navigate to the project directory:
   ```bash
   cd chat-application
   ```
3. Compile the Java files:
   ```bash
   javac Server.java Client.java
   ```
4. Start the server:
   ```bash
   java Server
   ```
5. Start the client:
   ```bash
   java Client
   ```
6. Begin chatting!

## Termination

- To terminate the chat, either user can type `bye` and press Enter. The application will close the connection and exit gracefully.

## Future Enhancements

- **User Authentication**: Add login functionality to authenticate users.
- **Multi-Client Support**: Allow multiple clients to connect to the server simultaneously.
- **Message Encryption**: Implement end-to-end encryption for secure communication.
- **File Sharing**: Enable users to send and receive files.

## Author

[Syed Fahad Faheem Shah](https://github.com/SyedFahadShah-f7)
