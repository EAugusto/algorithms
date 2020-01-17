package com.eaugusto.algorithms;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.Random;
import java.util.stream.IntStream;

public class DataCreation {
	public OutputStream os = null;
	public StringBuilder buffer = null; 
	public static void main(String[] args) throws Exception {

		int block = 10_000;
		DataCreation dataCreation = new DataCreation();
		dataCreation.os = getOutputStream(0);
		dataCreation.buffer = new StringBuilder(block * 2);
		Random random = new Random();
		IntStream.rangeClosed(1, 5_000_000).forEach(l -> {
			int newInt = random.nextInt(5_000_000);
			try {
				dataCreation.buffer.append(newInt + " ");
				boolean isNewBlock = l % block == 0;
				if(isNewBlock) {
					dataCreation.os.write(dataCreation.buffer.toString().getBytes());
					dataCreation.os.flush();
					dataCreation.os.close();
					dataCreation.buffer = new StringBuilder(block * 2);
					dataCreation.os = getOutputStream(l + 1);
				}
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
		});
	}

	private static OutputStream getOutputStream(int i) {
		int unit = (i / 1_000_000) + 1;
		try {
			return new FileOutputStream("src/main/resources/unordered-array_" + unit + "_000_000.txt", true);
		} catch (FileNotFoundException e) {
			throw new RuntimeException(e);
		}
	}
}