This project is a simple real-time WebSocket-based chat system

It demonstrates how to:

	•	Maintain long-lived WebSocket (TCP) connections
	
	•	Group connections into logical rooms
	
	•	Broadcast messages to all clients inside a room in real time
	

Google Docs is fundamentally a real-time collaborative system where:

	•	Many users are connected at the same time
	
	•	All users editing the same document belong to a logical group (document room)
	
	•	Any change made by one user is instantly propagated to all others

So conceptually:

One room = one document

One message = one operation on the document

Broadcasting = synchronizing document state

	1.	Import the project into IntelliJ IDEA as a Maven project.
	
	2.	Run the main method from WebSocketServer.java.
	
	3.	Go to the resources folder and open the HTML file in Chrome (or any web browser).
	
	4.	Enter a room name and click Join Room.
	
	5.	Open the same HTML file in another browser tab (or a different browser).
	
	6.	Enter the same room name and join.
	
	7.	Send a message from Tab 1 — you will see it instantly appear in Tab 2.
	
	8.	Send a message from Tab 2 — you will see it instantly appear in Tab 1.
