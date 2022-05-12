package com.disel.codingdojo.filereaders;

import java.io.InputStream;
import java.nio.charset.Charset;
import java.nio.file.Path;
import java.util.stream.Stream;

public interface FileReader {

	String readFile(InputStream inputStream);
	Stream<String> readFileAsStream(Path path, Charset charset);

}