GamePiece Player1;

Board = "file:///C:/Users/Ali/Desktop/test.png";

Player1.position = (151,651,0);
Player1.label = "Bigkilla";

Move(Player1, (165,135), 1000);
Change(Player1, "size", 3, 1000);

Move(Player1, (501,189), 2000);
Change(Player1, "color", "rgb(0,0,255)", 2000);

Move(Player1, (810,135), 3000);
Change(Player1, "opacity", 0.5, 3000);
Wait(Player1, 3500);

Move(Player1, (850,652), 4000);
Change(Player1, "opacity", 1, 4000);

Move(Player1, (494,636), 5000);

Change(Player1, "position", (163, 135), 6000);

;
