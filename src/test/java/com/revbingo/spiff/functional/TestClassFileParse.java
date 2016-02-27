/*
 * Copyright Mark Piper 2016
 *
 * This file is part of SPIFF.
 *
 * SPIFF is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * SPIFF is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with SPIFF.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.revbingo.spiff.functional;

import java.io.File;

import com.revbingo.spiff.datatypes.Datatype;
import com.revbingo.spiff.events.EventListener;
import org.junit.Test;

import com.revbingo.spiff.BinaryParser;
import com.revbingo.spiff.events.DebugEventListener;

public class TestClassFileParse {

	@Test
	public void canParseClassFile() throws Exception {
		EventListener noopListener = new EventListener(){

			@Override public void notifyData(Datatype ins) {}
			@Override public void notifyGroup(String groupName, boolean start) {}
		};

		BinaryParser parser = new BinaryParser(noopListener);
		parser.parse(new File("test-resources/javaclass.adf"), new File("target/test-classes/com/revbingo/spiff/functional/TestClassFileParse.class"));
	}
}
