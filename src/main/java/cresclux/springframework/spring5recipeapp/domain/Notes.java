package cresclux.springframework.spring5recipeapp.domain;

import lombok.*;
import javax.persistence.*;

/**
 * Created by laksheenmendis on 6/21/20 at 1:34 PM
 */
@Data
@EqualsAndHashCode(exclude = {"recipe"})  // because a circular reference is created for bi-directional relationship, and it leads to a stackoverflow error
@Entity
public class Notes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // here we don't need to specify cascade, because Recipe owns it
    // and there's no need to remove a Recipe, if a Notes is removed. Thus, no need of cascade
    @OneToOne
    private Recipe recipe;

    @Lob // will be saved as CLOB
    private String recipeNotes;

}
