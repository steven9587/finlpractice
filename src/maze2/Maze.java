package maze2;

import java.util.List;

public class Maze {
	int row;
	int col;
	int trapCount;
	int[] trapLocation;
	List<String> number;
	Player player = new Player();

	public Maze(int row, int col, int trapCount, int[] trapLocation, List<String> number) {
		this.row = row;
		this.col = col;
		this.trapCount = trapCount;
		this.trapLocation = trapLocation;
		this.number = number;
	}

	public void judgement() {
		int judgment;
		for (int i = 0; i < trapLocation.length; i++) {
			System.out.println(trapLocation[i]);
		}
		for (int i = 0; i < number.size(); i++) {
			if (player.HP > 0) {
				judgment = 0;
				System.out.println("請輸入上(8)下(2)左(4)右(6)：");
				System.out.println(number.get(i));
				switch (number.get(i)) {
				case "8":
					if (player.location / 6 == 0) {
						System.out.println("撞牆!");
						player.HP -= 5;
					} else {
						player.location -= 6;
						for (int a = 0; a < trapLocation.length; a++) {
							if (trapLocation[a] == player.location) {
								judgment = 1;
							}
						}
						if (judgment == 1) {
							player.HP -= 20;
						} else {
							player.HP -= 1;
						}
					}
					if (player.HP > 0) {
						System.out.println("目前位置：" + player.location);
						System.out.println("目前血量：" + player.HP);
						break;
					} else {
						System.out.println("Game Over!");
						break;
					}
				case "2":
					if (player.location / 6 == 3) {
						System.out.println("撞牆!");
						player.HP -= 5;
					} else {
						player.location += 6;
						for (int a = 0; a < trapLocation.length; a++) {
							if (trapLocation[a] == player.location) {
								judgment = 1;
							}
						}
						if (judgment == 1) {
							player.HP -= 20;
						} else {
							player.HP -= 1;
						}
					}
					if (player.HP > 0) {
						System.out.println("目前位置：" + player.location);
						System.out.println("目前血量：" + player.HP);
						break;
					} else {
						System.out.println("Game Over!");
						break;
					}
				case "4":
					if (player.location % 6 == 0) {
						System.out.println("撞牆!");
						player.HP -= 5;
					} else {
						player.location -= 1;
						for (int a = 0; a < trapLocation.length; a++) {
							if (trapLocation[a] == player.location) {
								judgment = 1;
							}
						}
						if (judgment == 1) {
							player.HP -= 20;
						} else {
							player.HP -= 1;
						}
					}
					if (player.HP > 0) {
						System.out.println("目前位置：" + player.location);
						System.out.println("目前血量：" + player.HP);
						break;
					} else {
						System.out.println("Game Over!");
						break;
					}
				case "6":
					if (player.location % 6 == 5) {
						System.out.println("撞牆!");
						player.HP -= 5;
					} else {
						player.location += 1;
						for (int a = 0; a < trapLocation.length; a++) {
							if (trapLocation[a] == player.location) {
								judgment = 1;
							}
						}
						if (judgment == 1) {
							player.HP -= 20;
						} else {
							player.HP -= 1;
						}
					}
					if (player.HP > 0) {
						System.out.println("目前位置：" + player.location);
						System.out.println("目前血量：" + player.HP);
						break;
					} else {
						System.out.println("Game Over!");
						break;
					}
				default:
					break;
				}
			}
		}
	}

	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public int getCol() {
		return col;
	}

	public void setCol(int col) {
		this.col = col;
	}

	public int getTrapCount() {
		return trapCount;
	}

	public void setTrapCount(int trapCount) {
		this.trapCount = trapCount;
	}

	public int[] getTrapLocation() {
		return trapLocation;
	}

	public void setTrapLocation(int[] trapLocation) {
		this.trapLocation = trapLocation;
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public List<String> getNumber() {
		return number;
	}

	public void setNumber(List<String> number) {
		this.number = number;
	}

	public class Player {
		int HP = 100;
		int location = 0;
	}
}
