package com.monocle.models;

public  class Tuple {

	private final int _e0;

	private final int _e1;

	private final int _e2;

	public Tuple(final int e0, final int e1) {
		_e0 = e0;
		_e1 = e1;
		_e2 = 0;
	}

	public Tuple(final int e0, final int e1, final int e2) {
		_e0 = e0;
		_e1 = e1;
		_e2 = e2;
	}

	public int getE0() {
		return _e0;
	}

	public int getE1() {
		return _e1;
	}

	public int getE2() {
		return _e2;
	}
}