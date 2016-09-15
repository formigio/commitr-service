package io.commitr.goal;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.commitr.task.Task;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import java.util.Set;
import java.util.UUID;

@Data
@Entity
public class Goal {
	@Id
	@GeneratedValue
	@JsonIgnore
	private Long id;

	@NotNull
	@JsonProperty("guid")
	private UUID uuid;

	@Length(max = 255)
	private String title;

	@OneToMany(mappedBy = "goal", cascade = CascadeType.ALL)
	@Null
	private Set<Task> tasks;

	@PrePersist
	void prePersist() {
		if (null==this.uuid) {
			this.uuid = UUID.randomUUID();
		}
	}
}
