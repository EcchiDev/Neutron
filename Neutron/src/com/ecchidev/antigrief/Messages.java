package com.ecchidev.antigrief;

//Jonne Saloranta - www.youtube.com/MasterSteve26

public class Messages {
	public enum Msg {
		NO_PERMISSION("Sorry, but you don't have permissions!"),
		PLAYER_REMOVED("Player removed succesfully"),
		PLAYER_ADDED("Player added succesfully"),
		MOB_KILL_NOT_ALLOWED("You are not allowed to kill animals on this region"),
		ONLY_IN_GAME_COMMAND("This command can be only used in game.");

		String msg;

		Msg(String msg) {
			this.msg = msg;
		}
		
		public String getMsg() {
			return msg;
		}
	}

}
