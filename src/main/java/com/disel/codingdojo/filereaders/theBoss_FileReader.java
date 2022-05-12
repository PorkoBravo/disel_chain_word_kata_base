package com.disel.codingdojo.filereaders;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

import org.springframework.stereotype.Component;

@Component
public class theBoss_FileReader implements FileReader {
	

	@Override
	public String readFile(InputStream inputStream) {
		try {
			return this.readFromInputStream(inputStream);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	@Override
	public Stream<String> readFileAsStream(Path path, Charset charset) {
		try {
			return Files.lines(path,charset);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	private String readFromInputStream(InputStream inputStream) throws IOException {
		if(inputStream == null) {
			throw new IOException();
		}
		StringBuilder resultStringBuilder = new StringBuilder();
		try (BufferedReader br = new BufferedReader(new InputStreamReader(inputStream))) {
			String line;
			while ((line = br.readLine()) != null) {
				resultStringBuilder.append(line).append("\n");
			}
			br.close();
		}
		return resultStringBuilder.toString();
	}
}
