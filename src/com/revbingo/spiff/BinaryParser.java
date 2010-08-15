package com.revbingo.spiff;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.List;

import com.revbingo.spiff.events.EventDispatcher;
import com.revbingo.spiff.instructions.Instruction;
import com.revbingo.spiff.parser.ParseException;
import com.revbingo.spiff.parser.SpiffParser;

public class BinaryParser {

	private EventDispatcher eventDispatcher;
		
	public BinaryParser(EventDispatcher ed){	
		this.eventDispatcher = ed;
	}
	
	public void parse(File adfFile, File parseFile) throws AdfFormatException, ExecutionException {
		List<Instruction> instructions = parseAdf(adfFile);
		read(parseFile, instructions);
	}

	List<Instruction> parseAdf(File adfFile) throws AdfFormatException {
		try {
			return parseAdf(new FileInputStream(adfFile));
		} catch (FileNotFoundException e) {
			throw new AdfFormatException("File " + adfFile.getAbsolutePath() + " does not exist");
		}
	}
	
	List<Instruction> parseAdf(InputStream adf) throws AdfFormatException { 
		try {
            SpiffParser parser = new SpiffParser(adf);
            parser.start();
            return parser.getInstructions();
		} catch (ParseException e) {
			throw new AdfFormatException("Error in adf file", e);
		}
	}
	
	void read(File binaryFile, List<Instruction> instructions) throws ExecutionException {
		try {
			FileChannel fc = new FileInputStream(binaryFile).getChannel();
			ByteBuffer buffer = ByteBuffer.allocate((int) binaryFile.length());			
			fc.read(buffer);
			buffer.flip();

			for(Instruction ins : instructions){
				ins.execute(buffer, eventDispatcher);
			}
		} catch (IOException e) {
			throw new ExecutionException("Could not read file " + binaryFile.getAbsolutePath(), e);
		}
	}
}
