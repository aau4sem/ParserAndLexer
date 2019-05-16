GamePiece Player1;
GamePiece Player2;
GamePiece Player3;

Board = "file:///C:/Users/Ali/Desktop/test.png";

Player1.position = (170,609,0);
Player2.position = (519,611,0);
Player3.position = (853,612,0);

Move(Player1, (170, 361), 500);
Move(Player2, (519, 361), 500);

Change(Player2, "color", "#0000ff", 500);
Change(Player1, "size", 3, 500);

Move(Player1, (170, 150), 1000);
Move(Player2, (519, 150), 1000);
Move(Player3, (860, 150), 1000);

Change(Player2, "size", 5, 1000);
Change(Player2, "color", "#FFFFFF", 1000);

Move(Player1, (170, 60), 1500);
Move(Player2, (519, 60), 1500);
Move(Player3, (860, 60), 1500);

;