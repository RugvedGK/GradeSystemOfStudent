package dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class StudentGrade {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int classs;
	private String name;
	private int sub1;
	private int sub2;
	private int sub3;
	private int sub4;
	private int sub5;
	private int sub6;
}
