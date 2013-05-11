package com.wordpress.marleneknoche.sea.ui;

import java.io.File;

public class Sequence {
	
	private static Sequence singleton = new Sequence();
	private File sequence;
	
	public static Sequence getInstance(){
		return singleton;
	}
	
	private Sequence() {
		
	}


	public void setFile(File sequence) {
		this.sequence = sequence;		
	}

	public File getFile() {
		return sequence;
	}

}
