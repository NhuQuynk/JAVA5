package com.poly.model;
import javax.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CategoryDTO {
	
	private Integer id;
	@NotBlank
	private String name;
	
    private String note;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

}
