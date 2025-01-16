import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.*;

public class Client {
    private Socket socket;
    private BufferedReader br;
    private PrintWriter out;

    private JFrame frame;
    private JTextArea messageArea;
    private JTextField messageInput;
    private JButton sendButton;

    public Client() {
        setupGUI();

        try {
            System.out.println("Sending request to server...");
            socket = new Socket("127.0.0.1", 8000);
            System.out.println("Connection established.");

            br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream(), true);

            startReading();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void setupGUI() {
        frame = new JFrame("Client Chat");
        frame.setSize(600, 700);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        messageArea = new JTextArea();
        messageArea.setEditable(false);
        messageArea.setFont(new Font("Arial", Font.PLAIN, 16));
        messageArea.setBackground(new Color(249, 213, 213)); // Light lavender background

        JScrollPane scrollPane = new JScrollPane(messageArea);

        messageInput = new JTextField();
        messageInput.setFont(new Font("Arial", Font.PLAIN, 16));
        sendButton = new JButton("Send");

        JPanel inputPanel = new JPanel(new BorderLayout());
        inputPanel.add(messageInput, BorderLayout.CENTER);
        inputPanel.add(sendButton, BorderLayout.EAST);

        frame.setLayout(new BorderLayout());
        frame.add(scrollPane, BorderLayout.CENTER);
        frame.add(inputPanel, BorderLayout.SOUTH);

        frame.setVisible(true);

        sendButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sendMessage();
            }
        });

        messageInput.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sendMessage();
            }
        });
    }

    private void sendMessage() {
        String content = messageInput.getText();
        if (!content.isEmpty()) {
            out.println(content);
            messageArea.append("You: " + content + "\n");
            messageInput.setText("");
            if (content.equalsIgnoreCase("bye")) {
                terminateChat("You terminated the chat.");
            }
        }
    }

    private void startReading() {
        Runnable r1 = () -> {
            System.out.println("Reader started...");
            try {
                while (true) {
                    String msg = br.readLine();
                    if (msg == null || msg.equalsIgnoreCase("bye")) {
                        terminateChat("Server terminated the chat.");
                        break;
                    }
                    messageArea.append("Server: " + msg + "\n");
                }
            } catch (Exception e) {
                System.out.println("Connection closed.");
            }
        };
        new Thread(r1).start();
    }

    private void terminateChat(String message) {
        try {
            messageArea.append(message + "\n");
            socket.close();
            frame.dispose(); // Close the GUI
            System.exit(0); // Exit the program
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        System.out.println("Starting Client");
        new Client();
    }
}
