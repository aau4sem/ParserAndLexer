board_level[2] = "testTwoPath";
board_level[0] = "testZeroPath";

GamePiece x;
int y = 5;

Change(x, "", "testTwo", y);
Wait(x, 10);
Move(x, (1,2,3), 2);

vector t = (2,3);