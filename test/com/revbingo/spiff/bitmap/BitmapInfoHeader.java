/*******************************************************************************
 * Copyright 2012 Mark Piper
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 ******************************************************************************/
package com.revbingo.spiff.bitmap;

public class BitmapInfoHeader {

	private int biSize;
	private int biWidth;
	private int biHeight;
	private short biPlanes;
	private short	biBitCount;
	private int	biCompression;
	private int	biSizeImage;
	private int	biXPelsPerMeter;
	private int	biYPelsPerMeter;
	private int	biClrUsed;
	private int	biClrImportant;
	
	public int getBiSize() {
		return biSize;
	}
	public void setBiSize(int biSize) {
		this.biSize = biSize;
	}
	public int getBiWidth() {
		return biWidth;
	}
	public void setBiWidth(int biWidth) {
		this.biWidth = biWidth;
	}
	public int getBiHeight() {
		return biHeight;
	}
	public void setBiHeight(int biHeight) {
		this.biHeight = biHeight;
	}
	public short getBiPlanes() {
		return biPlanes;
	}
	public void setBiPlanes(short biPlanes) {
		this.biPlanes = biPlanes;
	}
	public short getBiBitCount() {
		return biBitCount;
	}
	public void setBiBitCount(short biBitCount) {
		this.biBitCount = biBitCount;
	}
	public int getBiCompression() {
		return biCompression;
	}
	public void setBiCompression(int biCompression) {
		this.biCompression = biCompression;
	}
	public int getBiSizeImage() {
		return biSizeImage;
	}
	public void setBiSizeImage(int biSizeImage) {
		this.biSizeImage = biSizeImage;
	}
	public int getBiXPelsPerMeter() {
		return biXPelsPerMeter;
	}
	public void setBiXPelsPerMeter(int biXPelsPerMeter) {
		this.biXPelsPerMeter = biXPelsPerMeter;
	}
	public int getBiYPelsPerMeter() {
		return biYPelsPerMeter;
	}
	public void setBiYPelsPerMeter(int biYPelsPerMeter) {
		this.biYPelsPerMeter = biYPelsPerMeter;
	}
	public int getBiClrUsed() {
		return biClrUsed;
	}
	public void setBiClrUsed(int biClrUsed) {
		this.biClrUsed = biClrUsed;
	}
	public int getBiClrImportant() {
		return biClrImportant;
	}
	public void setBiClrImportant(int biClrImportant) {
		this.biClrImportant = biClrImportant;
	}
}
