package com.entity;

import java.io.Serializable;

/**
 * 文件信息表
 * 
 * @author John
 *
 */
public class SpaceFileInfo implements Serializable {

	private static final long serialVersionUID = 1L; 

	private String fileId;// 文件Id
	private String spaceId;// 场地ID
	private String file;// 文件路径
	private String fileName;// 文件名

	public String getFileId() {
		return fileId;
	}

	public void setFileId(String fileId) {
		this.fileId = fileId;
	}

	public String getSpaceId() {
		return spaceId;
	}

	public void setSpaceId(String spaceId) {
		this.spaceId = spaceId;
	}

	public String getFile() {
		return file;
	}

	public void setFile(String file) {
		this.file = file;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	@Override
	public String toString() {
		return "SpaceFileInfo [fileId=" + fileId + ", spaceId=" + spaceId + ", file=" + file + ", fileName=" + fileName
				+ "]";
	}

}
