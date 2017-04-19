package com.practice.user.enums;

public enum UserState {
	ACTIVE(0),
	INACTIVE(1);
	
	private int value;
    private UserState(int value) {
        this.value = value;
    }
	
	public int value(){
		return value;
	};
}
