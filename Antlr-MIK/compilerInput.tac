GamePiece Player1;
GamePiece Player2;
GamePiece Player3;

board_level[0] = "file:///C:/Users/Ali/Desktop/test.png";

Player1.position = (170,609,0);
Player2.position = (519,611,0);
Player3.position = (853,612,0);

move(Player1, (170, 361), 500);
move(Player2, (519, 361), 500);

move(Player1, (170, 150), 500);
move(Player2, (519, 150), 500);

move(Player3, (853, 150), 1000);

;