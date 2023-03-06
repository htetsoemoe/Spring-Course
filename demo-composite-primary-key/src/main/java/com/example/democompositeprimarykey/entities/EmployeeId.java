package com.example.democompositeprimarykey.entities;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@Data //  Equivalent to {@code @Getter @Setter @RequiredArgsConstructor @ToString @EqualsAndHashCode}.
@AllArgsConstructor
public class EmployeeId implements Serializable {



    private String city;
    private String cubicleNO;

    public EmployeeId() {
    }
}
