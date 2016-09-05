package io.commitr.goal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Goal {
	@Id
	@GeneratedValue
	private Long id;
	private String guid;
	private String title;
}
